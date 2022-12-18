package tech.reliab.cource.toropchnda.bank.service.impl;

import lombok.AllArgsConstructor;
import tech.reliab.cource.toropchnda.bank.entity.CreditAccount;
import tech.reliab.cource.toropchnda.bank.entity.Employee;
import tech.reliab.cource.toropchnda.bank.entity.PaymentAccount;
import tech.reliab.cource.toropchnda.bank.entity.User;
import tech.reliab.cource.toropchnda.bank.repository.BankRepository;
import tech.reliab.cource.toropchnda.bank.repository.CreditAccountRepository;
import tech.reliab.cource.toropchnda.bank.service.CreditAccountService;

import java.time.LocalDate;
import java.time.Period;

@AllArgsConstructor
public class CreditAccountServiceImpl implements CreditAccountService {

    private CreditAccountRepository creditAccountRepository;
    private BankRepository bankRepository;
    private static Long idGenerator = 0L;


    @Override
    public CreditAccount create(User user, String bankName,
                                LocalDate creditBegin, LocalDate creditEnd,
                                Long creditAmount, Double mouthPayment,
                                Employee employee, PaymentAccount paymentAccount) {
        var bank = bankRepository.getByName(bankName);
        var account = CreditAccount
                .builder()
                .id(idGenerator++)
                .user(user)
                .bankName(bankName)
                .creditStart(creditBegin)
                .creditEnd(creditEnd)
                .creditMonthCount(Period.between(creditBegin, creditEnd).getMonths())
                .creditAmount(creditAmount)
                .monthPayment(mouthPayment)
                .interestRate(bank.getInterestRate())
                .creditor(employee)
                .paymentAccount(paymentAccount)
                .build();
        creditAccountRepository.save(account);

        return account;
    }

    @Override
    public CreditAccount getCreditAccount() {
        return creditAccountRepository.getEntity();
    }

    @Override
    public void update(CreditAccount creditAccount) {
        creditAccountRepository.save(creditAccount);
    }

    @Override
    public void delete(CreditAccount creditAccount) {
        creditAccountRepository.delete(creditAccount);
    }
}
