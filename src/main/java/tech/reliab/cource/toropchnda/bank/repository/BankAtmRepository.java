package tech.reliab.cource.toropchnda.bank.repository;

import lombok.Getter;
import tech.reliab.cource.toropchnda.bank.entity.BankAtm;

import java.util.Objects;

@Getter
public class BankAtmRepository implements Repository<BankAtm> {

    private BankAtm entity;


    public void save(BankAtm entity) {
        this.entity = entity;
    }

    public void delete(BankAtm entity) {
        if (Objects.equals(this.entity, entity)) {
            this.entity = null;
        }
    }
}
