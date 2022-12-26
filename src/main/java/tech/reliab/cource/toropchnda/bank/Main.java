package tech.reliab.cource.toropchnda.bank;

import tech.reliab.cource.toropchnda.bank.entity.BankOffice;
import tech.reliab.cource.toropchnda.bank.entity.Employee;
import tech.reliab.cource.toropchnda.bank.entity.User;
import tech.reliab.cource.toropchnda.bank.exceptions.BankException;
import tech.reliab.cource.toropchnda.bank.exceptions.BankOfficeException;
import tech.reliab.cource.toropchnda.bank.exceptions.CreditAmountException;
import tech.reliab.cource.toropchnda.bank.exceptions.EmployeeException;
import tech.reliab.cource.toropchnda.bank.utils.CreditCalculator;
import tech.reliab.cource.toropchnda.bank.utils.DataGenerator;
import tech.reliab.cource.toropchnda.bank.utils.ModelProvider;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();


    public static void main(String[] args) {
        DataGenerator generator = new DataGenerator();
        generator.generateData();

        var users = ModelProvider.userRepository.findAll();
        users.forEach(System.out::println);

        try {
            System.out.print("Введите ваш id: ");
            var userId = scanner.nextLong();
            var user = ModelProvider.userRepository.findById(userId).orElse(null);
            if (user == null) {
                System.out.println("Такой пользователь не найден");
            } else {
                System.out.print("Какую сумму вы хотите взять? ");
                var creditAmount = scanner.nextLong();
                if (creditAmount < 10000) {
                    throw new CreditAmountException("Ну это не серьезно, сумма слишком маленькая, идите в микрозаймы.");
                } else if (creditAmount > 1_000_000_00){
                    throw new CreditAmountException("Ого О_о, мы не можем вам столько дать.");
                } else {
                    getCredit(user, creditAmount);
                }
            }
        } catch (RuntimeException e) {
            System.out.println("Что-то пошло не так! Причина: " + e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void getCredit(User user, Long creditAmount) throws InterruptedException {
        var bank = ModelProvider.bankService.getBestBank();
        var offices = ModelProvider.bankOfficeService.getAllWorksOffices(bank);

        // выбираем банк
        if (offices == null || offices.isEmpty()) {
            throw new BankException("Нет работающих банков выдающих кредит(");
        }

        // выбираем офис
        System.out.println("Выберете id офиса: ");
        offices.forEach(System.out::println);

        if (offices.stream().filter(office -> office.getMoneyAmount() > creditAmount).findFirst().isEmpty()) {
            throw new CreditAmountException("Умерьте свой пыл. Нет офисов с таким количеством денег.");
        }

        BankOffice office;
        do {
            var officeId = scanner.nextLong();
            office = offices.stream().filter(el -> el.getId().equals(officeId)).findFirst().orElse(null);

            if (office == null) {
                System.out.println("Такой офис не найден");
            } else if (office.getMoneyAmount() < creditAmount) {
                System.out.println("В этом офисе нет столько денег");
            }
        } while (office == null || office.getMoneyAmount() < creditAmount);

        // выбираем сотрудника
        var employees = ModelProvider.employeeRepository.findAllCreditAvailableByOffice(office);
        if (employees.isEmpty()) {
            throw new EmployeeException("Нет сотрудников, которые могут выдать кредит");
        }

        System.out.print("Выберете id сотрудника: ");
        employees.forEach(System.out::println);

        Employee employee;
        do {
            var employeeId = scanner.nextLong();
            employee = employees.stream().filter(el -> el.getId().equals(employeeId)).findFirst().orElse(null);
            if (employee == null) {
                System.out.println("Такой такого сотрудника нет. Это кто?");
            }
        } while (employee == null);

        System.out.println("Вы выбрали сотрудника, смотрим есть ли у вас счет у нас в банке");
        Thread.sleep(3000);
        var paymentAccount = ModelProvider.paymentAccountRepository.getPaymentAccountByBankAndUser(bank, user);
        if (paymentAccount != null) {
            System.out.println("Круто! У вас есть счет, идем дальше");
        } else {
            System.out.println("Ой-ой-ой! Счет не найден. Заводим его");
            paymentAccount = ModelProvider.paymentAccountService.create(user, bank.getName());
        }

        System.out.println("Делаем несколько проверок, подождите секундочку");
        Thread.sleep(2000);

        System.out.println("Ваш кредитный рейтинг = " + user.getRate());
        System.out.println("Рейтинг банка = " + bank.getRate());
        if (user.getRate() < 5000 && bank.getRate() > 50) {
            throw new BankException("Мы навели справки, мы не можем выдать кредит. Всего доброго.");
        }
        System.out.println("Вам одобрен кредит. Создаем кредитный аккаунт.");
        Thread.sleep(2000);

        var creditBegin = LocalDate.now();
        var creditEnd = LocalDate.now().plusMonths(random.nextLong(12, 25));

        var creditAccount = ModelProvider.creditAccountService
                .create(user, bank.getName(),
                        creditBegin, creditEnd,
                        creditAmount,
                        CreditCalculator
                                .calcMonthPayment(creditBegin, creditEnd, creditAmount,
                                        bank.getInterestRate()),
                        employee, paymentAccount);

        System.out.println("Вам был выдан кредит. Поздравляем! Вот его условия: ");
        System.out.println(creditAccount);

        var atms = ModelProvider
                .bankAtmRepository.getAllByOfficeLocationAndWorksAndMoneyContains(office, creditAmount);

        if (atms.isEmpty()) {
            System.out.println("В нашем офисе нет банкоматов для выдачи вашей суммы");
            atms = ModelProvider.bankService.getAtmsToExtraditeCredit(bank, creditAmount);
            System.out.println("Вы можете получить ваши деньки по этим адресам: ");
            atms.forEach(bankAtm -> System.out.println(bankAtm.getLocation()));
        } else {
            throw new BankOfficeException("На данный момент нет доступных банкоматов для выдачи вашей суммы.\n" +
                    "Мы с вами свяжемся.");
        }

        System.out.println("Спасибо что воспользовались наши банком, всего доброго!");
    }
}
