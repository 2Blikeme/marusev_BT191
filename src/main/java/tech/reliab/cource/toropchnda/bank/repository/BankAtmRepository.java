package tech.reliab.cource.toropchnda.bank.repository;

import tech.reliab.cource.toropchnda.bank.entity.Bank;
import tech.reliab.cource.toropchnda.bank.entity.BankAtm;
import tech.reliab.cource.toropchnda.bank.entity.BankOffice;
import tech.reliab.cource.toropchnda.bank.enums.WorkStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BankAtmRepository implements Repository<BankAtm> {

    private final List<BankAtm> entities = new ArrayList<>();


    public void save(BankAtm entity) {
        // т.к. ссылка уже находится в массиве,
        // то там уже все изменилось, поэтому не имеет смысла пересохранять
        if (entities.contains(entity)) { return; }
        this.entities.add(entity);
    }

    public List<BankAtm> getAllByOfficeLocationAndWorksAndMoneyContains(BankOffice bankOffice, Long moneyAmount) {
        return entities.stream()
                .filter(bankAtm -> bankAtm.getLocation().equals(bankOffice.getAddress()) &&
                        bankAtm.getStatus().equals(WorkStatus.WORKING) &&
                        bankAtm.getMoneyAmount() > moneyAmount &&
                        bankAtm.getBank().equals(bankOffice.getBank())
                )
                .collect(Collectors.toList());
    }

    public void delete(BankAtm entity) {
        this.entities.removeIf(el -> el.equals(entity));
    }
}
