package tech.reliab.cource.toropchnda.bank.repository;

import tech.reliab.cource.toropchnda.bank.entity.Bank;
import tech.reliab.cource.toropchnda.bank.entity.PaymentAccount;
import tech.reliab.cource.toropchnda.bank.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PaymentAccountRepository implements Repository<PaymentAccount> {

    private final List<PaymentAccount> entities = new ArrayList<>();

    public void save(PaymentAccount entity) {
        // т.к. ссылка уже находится в массиве,
        // то там уже все изменилось, поэтому не имеет смысла пересохранять
        if (entities.contains(entity)) { return; }
        this.entities.add(entity);
    }

    public void save(List<PaymentAccount> accounts) {
        this.entities.addAll(accounts);
    }

    public void delete(PaymentAccount entity) {
        this.entities.removeIf(el -> el.equals(entity));
    }

    public List<PaymentAccount> findAllByUser(User user) {
        return entities
                .stream()
                .filter(paymentAccount -> paymentAccount.getUser().equals(user))
                .collect(Collectors.toList());
    }

    public PaymentAccount getPaymentAccountByBankAndUser(Bank bank, User user) {
        return entities.stream()
                .filter(paymentAccount ->
                        paymentAccount.getUser().equals(user) &&
                                paymentAccount.getBank().equals(bank.getName()))
                .findFirst()
                .orElse(null);
    }

    public void delete(List<PaymentAccount> accounts) {
        entities.removeAll(accounts);
    }
}
