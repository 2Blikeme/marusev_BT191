package tech.reliab.cource.toropchnda.bank.repository;

import lombok.Getter;
import tech.reliab.cource.toropchnda.bank.entity.Bank;

import java.util.Objects;

@Getter
public class BankRepository implements Repository<Bank> {

    private Bank entity;

    public void save(Bank entity) {
        this.entity = entity;
    }

    public void delete(Bank entity) {
        if (Objects.equals(this.entity, entity)) {
            this.entity = null;
        }
    }

    public Bank getByName(String name) {
        return entity.getName().equals(name) ? entity : null;
    }
}
