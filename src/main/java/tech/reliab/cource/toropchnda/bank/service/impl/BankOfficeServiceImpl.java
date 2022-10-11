package tech.reliab.cource.toropchnda.bank.service.impl;

import lombok.AllArgsConstructor;
import tech.reliab.cource.toropchnda.bank.entity.Bank;
import tech.reliab.cource.toropchnda.bank.entity.BankOffice;
import tech.reliab.cource.toropchnda.bank.enums.WorkStatus;
import tech.reliab.cource.toropchnda.bank.repository.BankOfficeRepository;
import tech.reliab.cource.toropchnda.bank.service.BankOfficeService;
import tech.reliab.cource.toropchnda.bank.service.BankService;

import java.util.Random;

@AllArgsConstructor
public class BankOfficeServiceImpl implements BankOfficeService {

    private BankOfficeRepository bankOfficeRepository;
    private BankService bankService;

    private static Long idGenerator = 0L;

    /**
     * Создает офис, увеличивает количество офисов в банке
     */
    @Override
    public BankOffice create(String name, String address, Bank bank) {
        Random random = new Random();
        BankOffice bankOffice = BankOffice
                .builder()
                .id(idGenerator++)
                .name(name)
                .address(address)
                .status(WorkStatus.getRandomStatus())
                .placeAtmAvailable(random.nextBoolean())
                .atmCount(bank.getAtmCount())
                .creditAvailable(random.nextBoolean())
                .extradition(random.nextBoolean())
                .introduction(random.nextBoolean())
                .moneyAmount(bank.getMoneyAmount())
                .rentCost(random.nextInt(100_000))
                .bank(bank)
                .build();
        bankOfficeRepository.save(bankOffice);
        bankService.addBankOffice(bank);

        return bankOffice;
    }

    @Override
    public BankOffice getBankOffice() {
        return bankOfficeRepository.getEntity();
    }

    @Override
    public void update(BankOffice bankOffice) {
        bankOfficeRepository.save(bankOffice);
    }

    @Override
    public void delete(BankOffice bankOffice) {
        bankOfficeRepository.save(bankOffice);
        bankService.deleteBankOffice(bankOffice.getBank());
    }
}
