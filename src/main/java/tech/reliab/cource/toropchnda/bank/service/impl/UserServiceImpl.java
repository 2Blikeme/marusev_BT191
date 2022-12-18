package tech.reliab.cource.toropchnda.bank.service.impl;

import lombok.AllArgsConstructor;
import tech.reliab.cource.toropchnda.bank.entity.Bank;
import tech.reliab.cource.toropchnda.bank.entity.User;
import tech.reliab.cource.toropchnda.bank.repository.EmployeeRepository;
import tech.reliab.cource.toropchnda.bank.repository.UserRepository;
import tech.reliab.cource.toropchnda.bank.service.BankService;
import tech.reliab.cource.toropchnda.bank.service.CreditAccountService;
import tech.reliab.cource.toropchnda.bank.service.PaymentAccountService;
import tech.reliab.cource.toropchnda.bank.service.UserService;
import tech.reliab.cource.toropchnda.bank.utils.CreditCalculator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private BankService bankService;
    private PaymentAccountService paymentAccountService;
    private CreditAccountService creditAccountService;
    private EmployeeRepository employeeRepository;
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
                .workPlace(workPlace)
                .income(userIncome)
                .banks(bank)
                .rate(userIncome / 10)
                .build();




        var paymentAccount = paymentAccountService.create(user, bank.getName());

        // TODO: 11.10.2022 вынести это в отдельный метод, когда будем брать кредит
        var employee = employeeRepository.getEntity();

        var creditBegin = LocalDate.now();
        var creditEnd = LocalDate.now().plusMonths(random.nextLong(12, 25));
        var creditAmount = random.nextLong(10_000, 1_000_000L);

        var creditAccount = creditAccountService
                .create(user, bank.getName(),
                        creditBegin, creditEnd,
                        creditAmount,
                        CreditCalculator
                                .calcMonthPayment(creditBegin, creditEnd, creditAmount, bank.getInterestRate()),
                        employee, paymentAccount);
        user.setPaymentAccounts(paymentAccount);
        user.setCreditAccounts(creditAccount);

        userRepository.save(user);
        bankService.addClient(bank);

        return user;
    }

    @Override
    public User getUser() {
        return userRepository.getEntity();
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
        bankService.deleteClient(user.getBanks());
    }
}
