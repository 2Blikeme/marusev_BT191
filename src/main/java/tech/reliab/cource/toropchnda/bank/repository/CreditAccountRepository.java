package tech.reliab.cource.toropchnda.bank.repository;

import tech.reliab.cource.toropchnda.bank.entity.CreditAccount;
import tech.reliab.cource.toropchnda.bank.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CreditAccountRepository implements Repository<CreditAccount> {

    private final List<CreditAccount> entities = new ArrayList<>();

    public void save(CreditAccount entity) {
        // т.к. ссылка уже находится в массиве,
        // то там уже все изменилось, поэтому не имеет смысла пересохранять
        if (entities.contains(entity)) { return; }
        this.entities.add(entity);
    }

    public void delete(CreditAccount entity) {
        this.entities.removeIf(el -> el.equals(entity));
    }

    public List<CreditAccount> findAllByUser(User user) {
        return entities
                .stream()
                .filter(creditAccount -> creditAccount.getUser().equals(user))
                .collect(Collectors.toList());
    }
}
