package tech.reliab.cource.toropchnda.bank.repository;

import lombok.Getter;
import tech.reliab.cource.toropchnda.bank.entity.BankOffice;

import java.util.Objects;

@Getter
public class BankOfficeRepository implements Repository<BankOffice> {

    private BankOffice entity;

    public void save(BankOffice entity) {
        this.entity = entity;
    }

    public void delete(BankOffice entity) {
        if (this.entity.equals(entity)) {
            this.entity = null;
        }
    }
}
