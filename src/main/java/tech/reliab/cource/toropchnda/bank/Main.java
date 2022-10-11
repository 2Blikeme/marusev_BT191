package tech.reliab.cource.toropchnda.bank;

import tech.reliab.cource.toropchnda.bank.repository.BankAtmRepository;
import tech.reliab.cource.toropchnda.bank.repository.BankOfficeRepository;
import tech.reliab.cource.toropchnda.bank.repository.BankRepository;
import tech.reliab.cource.toropchnda.bank.repository.CreditAccountRepository;
import tech.reliab.cource.toropchnda.bank.repository.EmployeeRepository;
import tech.reliab.cource.toropchnda.bank.repository.PaymentAccountRepository;
import tech.reliab.cource.toropchnda.bank.repository.UserRepository;
import tech.reliab.cource.toropchnda.bank.service.AtmService;
import tech.reliab.cource.toropchnda.bank.service.BankOfficeService;
import tech.reliab.cource.toropchnda.bank.service.BankService;
import tech.reliab.cource.toropchnda.bank.service.CreditAccountService;
import tech.reliab.cource.toropchnda.bank.service.EmployeeService;
import tech.reliab.cource.toropchnda.bank.service.PaymentAccountService;
import tech.reliab.cource.toropchnda.bank.service.UserService;
import tech.reliab.cource.toropchnda.bank.service.impl.AtmServiceImpl;
import tech.reliab.cource.toropchnda.bank.service.impl.BankOfficeServiceImpl;
import tech.reliab.cource.toropchnda.bank.service.impl.BankServiceImpl;
import tech.reliab.cource.toropchnda.bank.service.impl.CreditAccountServiceImpl;
import tech.reliab.cource.toropchnda.bank.service.impl.EmployeeServiceImpl;
import tech.reliab.cource.toropchnda.bank.service.impl.PaymentAccountServiceImpl;
import tech.reliab.cource.toropchnda.bank.service.impl.UserServiceImpl;

public class Main {

    public static void main(String[] args) {
        // репозитории
        BankRepository bankRepository = new BankRepository();
        BankAtmRepository bankAtmRepository = new BankAtmRepository();
        BankOfficeRepository bankOfficeRepository = new BankOfficeRepository();
        CreditAccountRepository creditAccountRepository = new CreditAccountRepository();
        EmployeeRepository employeeRepository = new EmployeeRepository();
        PaymentAccountRepository paymentAccountRepository = new PaymentAccountRepository();
        UserRepository userRepository = new UserRepository();

        // сервисы
        BankService bankService = new BankServiceImpl(bankRepository);
        AtmService atmService = new AtmServiceImpl(bankAtmRepository, bankService);
        BankOfficeService bankOfficeService = new BankOfficeServiceImpl(bankOfficeRepository, bankService);
        EmployeeService employeeService = new EmployeeServiceImpl(employeeRepository, bankService);
        CreditAccountService creditAccountService = new CreditAccountServiceImpl(creditAccountRepository, bankRepository);
        PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl(paymentAccountRepository);
        UserService userService = new UserServiceImpl(userRepository, bankService,
                paymentAccountService, creditAccountService, employeeRepository);


        // создаем банк
        var bank = bankService.createBank("Банк 1");

        // создаем офис
        var bankOffice = bankOfficeService.create("Офис 1", "Адрес 1, улица 1, дом 1", bank);

        // создаем работника
        var employee = employeeService.create("Иванов Иван Иванович", "Охранник", bank, bankOffice);

        // создаем банкомат
        var atm = atmService.create("Банкомат 1", bank, bankOffice, employee);

        // создаем клиента
        var user = userService.create("Иванов Иван Иванович", "Пятерочка", bank);

        var creditAccount = creditAccountRepository.getEntity();
        var paymentAccount = paymentAccountRepository.getEntity();

        System.out.println(bank);
        System.out.println(bankOffice);
        System.out.println(employee);
        System.out.println(atm);
        System.out.println(user);
        System.out.println(creditAccount);
        System.out.println(paymentAccount);
    }
}
