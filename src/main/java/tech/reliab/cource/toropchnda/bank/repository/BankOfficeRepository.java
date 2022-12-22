package tech.reliab.cource.toropchnda.bank.repository;

import tech.reliab.cource.toropchnda.bank.entity.Bank;
import tech.reliab.cource.toropchnda.bank.entity.BankOffice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BankOfficeRepository implements Repository<BankOffice> {

    private final List<BankOffice> entities = new ArrayList<>();

    public void save(BankOffice entity) {
        // т.к. ссылка уже находится в массиве,
        // то там уже все изменилось, поэтому не имеет смысла пересохранять
        if (entities.contains(entity)) { return; }
        this.entities.add(entity);
    }

    public void delete(BankOffice entity) {
        this.entities.removeIf(el -> el.equals(entity));
    }

    public List<BankOffice> findAllByBank(Bank bank) {
        return entities
                .stream()
                .filter(bankOffice -> bankOffice.getBank().equals(bank))
                .collect(Collectors.toList());
    }
}
