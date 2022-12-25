package tech.reliab.cource.toropchnda.bank.utils;

import tech.reliab.cource.toropchnda.bank.entity.*;
import tech.reliab.cource.toropchnda.bank.enums.BankPost;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataGenerator {

    private static final Random random = new Random();

    public void generateData() {

        List<Employee> bankEmployeeList = new ArrayList<>();

        // создаем банки, офисы и сотрудников для них
        for (int i = 0; i < 10; i++) {

            // создаем банк
            var bank = ModelProvider.bankService.createBank("Банк " + i);

            // для банка создаем офисы банка
            for (int j = 0; j < 10; j++) {
                var bankOffice = ModelProvider.bankOfficeService.create("Офис " + (i + j),
                        String.format("Адрес %s, улица %s, дом %s", (i + j), (i + j), (i + j)), bank);

                // создаем сотрудников
                for (int k = 0; k < 15; k++) {
                    bankEmployeeList.add(ModelProvider.employeeService.create(DataProvider.getRandomName(),
                            BankPost.getRandomPost(), bank, bankOffice));
                }

                // создаем банкоматы для офиса банка
                for (int k = 0; k < 10; k++) {
                    ModelProvider.atmService.create(
                            "Банкомат " + k,
                            bank,
                            bankOffice,
                            bankEmployeeList.get(random.nextInt(5))
                    );
                }

                // создаем клиентов
                for (int k = 0; k < 2; k++) {
                    var user = ModelProvider.userService.create(
                            DataProvider.getRandomName(),
                            DataProvider.getRandomWorkSpace(),
                            bank
                    );

                    // создаем платежные и кредитные аккаунты
                    for (int l = 0; l < 2; l++) {
                        var paymentAccount = ModelProvider
                                .paymentAccountService.create(user, bank.getName());

                        var creditBegin = LocalDate.now();
                        var creditEnd = LocalDate.now().plusMonths(random.nextLong(12, 25));
                        var creditAmount = random.nextLong(10_000, 1_000_000L);

                        ModelProvider.creditAccountService
                                .create(user, bank.getName(),
                                        creditBegin, creditEnd,
                                        creditAmount,
                                        CreditCalculator
                                                .calcMonthPayment(creditBegin, creditEnd, creditAmount,
                                                        bank.getInterestRate()),
                                        bankEmployeeList.get(random.nextInt(5)), paymentAccount);

//                        user.getPaymentAccounts().add(paymentAccount);
//                        user.getCreditAccounts().add(creditAccount);
                    }
                }
                bankEmployeeList.clear();
            }
        }
    }
}
