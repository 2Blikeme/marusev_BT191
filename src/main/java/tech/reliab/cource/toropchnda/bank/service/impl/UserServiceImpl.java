package tech.reliab.cource.toropchnda.bank.service.impl;

import lombok.AllArgsConstructor;
import tech.reliab.cource.toropchnda.bank.entity.Bank;
import tech.reliab.cource.toropchnda.bank.entity.User;
import tech.reliab.cource.toropchnda.bank.repository.UserRepository;
import tech.reliab.cource.toropchnda.bank.service.BankService;
import tech.reliab.cource.toropchnda.bank.service.CreditAccountService;
import tech.reliab.cource.toropchnda.bank.service.PaymentAccountService;
import tech.reliab.cource.toropchnda.bank.service.UserService;
import tech.reliab.cource.toropchnda.bank.utils.ModelProvider;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import static tech.reliab.cource.toropchnda.bank.utils.FileJsonUtil.objectMapper;

@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private BankService bankService;
    private PaymentAccountService paymentAccountService;
    private CreditAccountService creditAccountService;
    private static Long idGenerator = 0L;


    @Override
    public User create(String fullName,
                       String workPlace,
                       Bank bank) {

        Random random = new Random();
        var userIncome = random.nextInt(30_000, 100_000);
        var user = User
                .builder()
                .id(idGenerator++)
                .fullName(fullName)
                .birthday(LocalDate.now().minusYears(random.nextLong(20, 50)))
                .banks(new ArrayList<>())
                .creditAccounts(new ArrayList<>())
                .paymentAccounts(new ArrayList<>())
                .workPlace(workPlace)
                .income(userIncome)
                .rate(userIncome / 10)
                .build();

        user.getBanks().add(bank);
        userRepository.save(user);
        bankService.addClient(bank);

        return user;
    }


    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        user.getCreditAccounts().forEach(creditAccount -> creditAccountService.delete(creditAccount));
        user.getPaymentAccounts().forEach(paymentAccount -> paymentAccountService.delete(paymentAccount));
        user.getBanks().forEach(bank -> bankService.deleteClient(bank));
        userRepository.delete(user);
    }

    @Override
    public void outputCreditAccountsToJson(User user, String fileName) throws IOException {
        var creditAccountsJsonString = objectMapper.writeValueAsString(user.getCreditAccounts());
        FileWriter creditAccountsJsonFile = new FileWriter(fileName);
        creditAccountsJsonFile.write(creditAccountsJsonString);
        creditAccountsJsonFile.close();
    }

    @Override
    public void outputPaymentAccountsToJson(User user, String fileName) throws IOException {
        var paymentAccountsJsonString = objectMapper.writeValueAsString(user.getPaymentAccounts());
        FileWriter paymentAccountsJsonFile = new FileWriter(fileName);
        paymentAccountsJsonFile.write(paymentAccountsJsonString);
        paymentAccountsJsonFile.close();
    }

    @Override
    public boolean transferAccountsToAnotherBank(User user, Bank oldBank, Bank newBank) throws IOException {
        var usersPaymentsAccounts = user.getPaymentAccounts()
                .stream()
                .filter(paymentAccount -> paymentAccount.getBank().equals(oldBank.getName()))
                .toList();
        var usersCreditAccounts = user.getCreditAccounts()
                .stream()
                .filter(creditAccount -> creditAccount.getBankName().equals(oldBank.getName()))
                .toList();

        var paymentAccountsJsonFileName = "payment.json";
        var creditAccountsJsonFileName = "credit.json";

        try (FileWriter paymentAccountsJsonFile = new FileWriter(paymentAccountsJsonFileName);
             FileWriter creditAccountsJsonFile = new FileWriter(creditAccountsJsonFileName);
        ) {
            paymentAccountsJsonFile.write(objectMapper.writeValueAsString(usersPaymentsAccounts));
            creditAccountsJsonFile.write(objectMapper.writeValueAsString(usersCreditAccounts));
        }

        outputPaymentAccountsToJson(user, paymentAccountsJsonFileName);
        outputCreditAccountsToJson(user, creditAccountsJsonFileName);

        try {
            ModelProvider.creditAccountRepository.delete(usersCreditAccounts);
            ModelProvider.paymentAccountRepository.delete(usersPaymentsAccounts);

            bankService.transferUsersPaymentAccounts(user, newBank, paymentAccountsJsonFileName);
            bankService.transferUsersCreditAccounts(user, newBank, creditAccountsJsonFileName);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
