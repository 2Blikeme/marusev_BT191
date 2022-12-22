package tech.reliab.cource.toropchnda.bank.service.impl;

import lombok.AllArgsConstructor;
import tech.reliab.cource.toropchnda.bank.entity.Bank;
import tech.reliab.cource.toropchnda.bank.entity.User;
import tech.reliab.cource.toropchnda.bank.repository.UserRepository;
import tech.reliab.cource.toropchnda.bank.service.BankService;
import tech.reliab.cource.toropchnda.bank.service.CreditAccountService;
import tech.reliab.cource.toropchnda.bank.service.PaymentAccountService;
import tech.reliab.cource.toropchnda.bank.service.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

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
        var userIncome = random.nextInt(10_000);
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
}
