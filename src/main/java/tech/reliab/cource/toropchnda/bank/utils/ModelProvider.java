package tech.reliab.cource.toropchnda.bank.utils;

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


public class ModelProvider {

    // репозитории
    public static BankRepository bankRepository;
    public static BankAtmRepository bankAtmRepository;
    public static BankOfficeRepository bankOfficeRepository;
    public static CreditAccountRepository creditAccountRepository;
    public static EmployeeRepository employeeRepository;
    public static PaymentAccountRepository paymentAccountRepository;
    public static UserRepository userRepository;

    // сервисы
    public static BankService bankService;
    public static BankOfficeService bankOfficeService;
    public static AtmService atmService;
    public static EmployeeService employeeService;
    public static CreditAccountService creditAccountService;
    public static PaymentAccountService paymentAccountService;
    public static UserService userService;

    static {
        // создаем репы
        bankRepository = new BankRepository();
        bankAtmRepository = new BankAtmRepository();
        bankOfficeRepository = new BankOfficeRepository();
        creditAccountRepository = new CreditAccountRepository();
        employeeRepository = new EmployeeRepository();
        paymentAccountRepository = new PaymentAccountRepository();
        userRepository = new UserRepository();

        // создаем сервисы
        bankService = new BankServiceImpl(bankRepository);
        bankOfficeService = new BankOfficeServiceImpl(bankOfficeRepository, bankService);
        atmService = new AtmServiceImpl(bankAtmRepository, bankOfficeService, bankService);
        employeeService = new EmployeeServiceImpl(employeeRepository, bankService);
        creditAccountService = new CreditAccountServiceImpl(creditAccountRepository, bankRepository);
        paymentAccountService = new PaymentAccountServiceImpl(paymentAccountRepository);
        userService = new UserServiceImpl(userRepository, bankService,
                paymentAccountService, creditAccountService);
    }
}
