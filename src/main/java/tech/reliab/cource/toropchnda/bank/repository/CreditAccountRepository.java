package tech.reliab.cource.toropchnda.bank.repository;

import lombok.Getter;
import tech.reliab.cource.toropchnda.bank.entity.CreditAccount;

import java.util.Objects;

@Getter
public class CreditAccountRepository implements Repository<CreditAccount> {

    private CreditAccount entity;

    public void save(CreditAccount entity) {
        this.entity = entity;
    }

    public void delete(CreditAccount entity) {
        if (this.entity.equals(entity)) {
            this.entity = null;
        }
    }
}
