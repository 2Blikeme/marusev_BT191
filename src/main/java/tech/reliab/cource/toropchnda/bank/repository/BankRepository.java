package tech.reliab.cource.toropchnda.bank.repository;

import tech.reliab.cource.toropchnda.bank.entity.Bank;

import java.util.ArrayList;
import java.util.List;

public class BankRepository implements Repository<Bank> {

    private final List<Bank> entities = new ArrayList<>();

    public void save(Bank entity) {
        // т.к. ссылка уже находится в массиве,
        // то там уже все изменилось, поэтому не имеет смысла пересохранять
        if (entities.contains(entity)) { return; }
        this.entities.add(entity);
    }

    public void delete(Bank entity) {
        this.entities.removeIf(el -> el.equals(entity));
    }

    public Bank getByName(String name) {
        return entities
                .stream()
                .filter(bank -> bank.getName().equals(name))
                .findAny().orElseThrow();
    }
}
