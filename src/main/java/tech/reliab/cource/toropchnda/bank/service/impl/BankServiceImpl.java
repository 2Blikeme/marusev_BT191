package tech.reliab.cource.toropchnda.bank.service.impl;

import lombok.AllArgsConstructor;
import tech.reliab.cource.toropchnda.bank.entity.Bank;
import tech.reliab.cource.toropchnda.bank.entity.BankAtm;
import tech.reliab.cource.toropchnda.bank.repository.BankRepository;
import tech.reliab.cource.toropchnda.bank.service.BankService;
import tech.reliab.cource.toropchnda.bank.utils.ModelProvider;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;
    private static Long idGenerator = 0L;


    @Override
    public Bank createBank(String name) {
        Random random = new Random();
        var rate = random.nextInt(100);
        Bank bank = Bank
                .builder()
                .id(idGenerator++)
                .name(name)
                .officeCount(0)
                .atmCount(0)
                .employeeCount(0)
                .clientCount(0)
                .rate(rate)
                .moneyAmount(random.nextLong(500_000,1_000_000L))
                .interestRate(20 - rate / 10D)
                .build();
        bankRepository.save(bank);

        return bank;
    }


    @Override
    public void update(Bank bank) {
        bankRepository.save(bank);
    }


    @Override
    public void delete(Bank bank) {
        bankRepository.delete(bank);
    }


    @Override
    public void addAtm(Bank bank) {
        var bankAtmCount = bank.getAtmCount();
        bank.setAtmCount(++bankAtmCount);
        this.update(bank);
    }

    @Override
    public void deleteAtm(Bank bank) {
        var bankAtmCount = bank.getAtmCount();
        bank.setAtmCount(--bankAtmCount);
        this.update(bank);
    }

    @Override
    public void addBankOffice(Bank bank) {
        var officeCount = bank.getOfficeCount();
        bank.setOfficeCount(++officeCount);
        this.update(bank);
    }

    @Override
    public void deleteBankOffice(Bank bank) {
        var officeCount = bank.getOfficeCount();
        bank.setOfficeCount(--officeCount);
        this.update(bank);
    }

    @Override
    public void addEmployee(Bank bank) {
        var employeeCount = bank.getEmployeeCount();
        bank.setEmployeeCount(++employeeCount);
        this.update(bank);
    }

    @Override
    public void deleteEmployee(Bank bank) {
        var employeeCount = bank.getEmployeeCount();
        bank.setEmployeeCount(--employeeCount);
        this.update(bank);
    }

    @Override
    public void addClient(Bank bank) {
        var clientCount = bank.getClientCount();
        bank.setClientCount(++clientCount);
        this.update(bank);
    }

    @Override
    public void deleteClient(Bank bank) {
        var clientCount = bank.getClientCount();
        bank.setClientCount(--clientCount);
        this.update(bank);
    }

    @Override
    public Bank getBestBank() {
        var banks = ModelProvider.bankRepository.findAll();
        Bank bestBank = banks.get(0);
        for (Bank bank : banks) {
            if (bestBank.getAtmCount() < bank.getAtmCount() &&
                    bestBank.getEmployeeCount() < bank.getEmployeeCount()) {
                if (bestBank.getOfficeCount() < bank.getOfficeCount()) {
                    bestBank = bank;
                } else if (bestBank.getInterestRate() < bank.getInterestRate()) {
                    bestBank = bank;
                }
            }
        }
        return bestBank;
    }

    @Override
    public List<BankAtm> getAtmsToExtraditeCredit(Bank bank, Long creditAmount) {
        var offices = ModelProvider.bankOfficeRepository.findAllByBank(bank);
        return offices
                .stream()
                .map(bankOffice ->
                        ModelProvider.bankAtmRepository
                                .getAllByOfficeLocationAndWorksAndMoneyContains(bankOffice, creditAmount)
                )
                .findFirst()
                .orElse(null);

    }
}
