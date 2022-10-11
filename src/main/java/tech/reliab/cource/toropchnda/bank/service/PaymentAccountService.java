package tech.reliab.cource.toropchnda.bank.service;

import tech.reliab.cource.toropchnda.bank.entity.PaymentAccount;
import tech.reliab.cource.toropchnda.bank.entity.User;

public interface PaymentAccountService {

    PaymentAccount create(User user, String bankName);

    PaymentAccount getPaymentAccount();

    void update(PaymentAccount paymentAccount);
    void delete(PaymentAccount paymentAccount);
}
