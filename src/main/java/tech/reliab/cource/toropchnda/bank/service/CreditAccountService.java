package tech.reliab.cource.toropchnda.bank.service;

import tech.reliab.cource.toropchnda.bank.entity.CreditAccount;
import tech.reliab.cource.toropchnda.bank.entity.Employee;
import tech.reliab.cource.toropchnda.bank.entity.PaymentAccount;
import tech.reliab.cource.toropchnda.bank.entity.User;

import java.time.LocalDate;

public interface CreditAccountService {

    /**
     * Создает кредитный аккаунт
     * @param user              пользователь
     * @param bankName          имя банка
     * @param creditBegin       дата начала кредита
     * @param creditEnd         дата окончания кредита
     * @param creditAmount      сумма кредита
     * @param mouthPayment      месячная оплата
     * @param employee          обслуживающий сотрудник
     * @param paymentAccount    платежный аккаунт
     */
    CreditAccount create(User user, String bankName,
                         LocalDate creditBegin, LocalDate creditEnd,
                         Long creditAmount, Double mouthPayment,
                         Employee employee, PaymentAccount paymentAccount);


    /**
     * Обновляет кредитный аккаунт
     */
    void update(CreditAccount creditAccount);

    /**
     * Удаляет кредитный аккаунт
     */
    void delete(CreditAccount creditAccount);

}
