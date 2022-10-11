package tech.reliab.cource.toropchnda.bank.service.impl;

import lombok.AllArgsConstructor;
import tech.reliab.cource.toropchnda.bank.entity.Bank;
import tech.reliab.cource.toropchnda.bank.entity.BankAtm;
import tech.reliab.cource.toropchnda.bank.entity.BankOffice;
import tech.reliab.cource.toropchnda.bank.entity.Employee;
import tech.reliab.cource.toropchnda.bank.enums.WorkStatus;
import tech.reliab.cource.toropchnda.bank.repository.BankAtmRepository;
import tech.reliab.cource.toropchnda.bank.service.AtmService;
import tech.reliab.cource.toropchnda.bank.service.BankService;

import java.util.Random;

@AllArgsConstructor
public class AtmServiceImpl implements AtmService {

    private BankAtmRepository bankAtmRepository;
    private BankService bankService;
    private static Long idGenerator = 0L;


    /**
     * Создает банкомат, увеличивает количество банкоматов в bank
     */
    @Override
    public BankAtm create(String name, Bank bank, BankOffice office, Employee employee) {
        Random random = new Random();
        BankAtm bankAtm = BankAtm
                .builder()
                .id(idGenerator++)
                .name(name)
                .location(office.getAddress())
                .status(WorkStatus.getRandomStatus())
                .bank(bank)
                .servingEmployee(employee)
                .extradition(random.nextBoolean())
                .introduction(random.nextBoolean())
                .moneyAmount(bank.getMoneyAmount())
                .maintenanceCost(random.nextInt(10000))
                .build();
        bankAtmRepository.save(bankAtm);
        bankService.addAtm(bank);

        return bankAtm;
    }

    @Override
    public BankAtm getBankAtm() {
        return bankAtmRepository.getEntity();
    }

    @Override
    public void delete(BankAtm bankAtm) {
        bankAtmRepository.delete(bankAtm);
        bankService.deleteAtm(bankAtm.getBank());
    }

    @Override
    public void update(BankAtm bankAtm) {
        bankAtmRepository.save(bankAtm);
    }
}
