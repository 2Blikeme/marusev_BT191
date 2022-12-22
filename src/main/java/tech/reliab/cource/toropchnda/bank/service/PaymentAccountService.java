package tech.reliab.cource.toropchnda.bank.service;

import tech.reliab.cource.toropchnda.bank.entity.PaymentAccount;
import tech.reliab.cource.toropchnda.bank.entity.User;

public interface PaymentAccountService {

    /**
     * Создает платежный аккаунт
     * @param user      пользователь
     * @param bankName  имя банка
     */
    PaymentAccount create(User user, String bankName);


    /**
     * Возвращает платежный аккаунт
     */
    void update(PaymentAccount paymentAccount);

    /**
     * Удаляет платежный аккаунт
     */
    void delete(PaymentAccount paymentAccount);
}
