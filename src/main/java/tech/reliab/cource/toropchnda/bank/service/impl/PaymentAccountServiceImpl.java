package tech.reliab.cource.toropchnda.bank.service.impl;

import lombok.AllArgsConstructor;
import tech.reliab.cource.toropchnda.bank.entity.PaymentAccount;
import tech.reliab.cource.toropchnda.bank.entity.User;
import tech.reliab.cource.toropchnda.bank.repository.PaymentAccountRepository;
import tech.reliab.cource.toropchnda.bank.service.PaymentAccountService;

import java.util.Random;

@AllArgsConstructor
public class PaymentAccountServiceImpl implements PaymentAccountService {

    private PaymentAccountRepository paymentAccountRepository;
    private static Long idGenerator = 0L;


    @Override
    public PaymentAccount create(User user, String bankName) {
        Random random = new Random();
        var account = PaymentAccount
                .builder()
                .id(++idGenerator)
                .user(user)
                .bank(bankName)
                .moneyAmount(random.nextInt(100_000))
                .build();
        paymentAccountRepository.save(account);
        user.getPaymentAccounts().add(account);

        return account;
    }


    @Override
    public void update(PaymentAccount paymentAccount) {
        paymentAccountRepository.save(paymentAccount);
    }

    @Override
    public void delete(PaymentAccount paymentAccount) {
        paymentAccountRepository.delete(paymentAccount);
    }
}
