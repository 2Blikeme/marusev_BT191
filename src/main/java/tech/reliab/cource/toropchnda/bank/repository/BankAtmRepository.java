package tech.reliab.cource.toropchnda.bank.repository;

import tech.reliab.cource.toropchnda.bank.entity.BankAtm;

import java.util.ArrayList;
import java.util.List;

public class BankAtmRepository implements Repository<BankAtm> {

    private final List<BankAtm> entities = new ArrayList<>();


    public void save(BankAtm entity) {
        // т.к. ссылка уже находится в массиве,
        // то там уже все изменилось, поэтому не имеет смысла пересохранять
        if (entities.contains(entity)) { return; }
        this.entities.add(entity);
    }

    public void delete(BankAtm entity) {
        this.entities.removeIf(el -> el.equals(entity));
    }
}
