package tech.reliab.cource.toropchnda.bank.service;

import tech.reliab.cource.toropchnda.bank.entity.Bank;
import tech.reliab.cource.toropchnda.bank.entity.BankAtm;
import tech.reliab.cource.toropchnda.bank.entity.BankOffice;

import java.util.List;

public interface BankService {

    /**
     * Создает банк
     * @param name  имя банка
     */
    Bank createBank(String name);


    /**
     * Обновляет банк
     */
    void update(Bank bank);

    /**
     * Удаляет банк
     */
    void delete(Bank bank);

    /**
     * Возвращает 'лучший' банк
     */
    Bank getBestBank();

    /**
     *  Возвращает банкоматы банка которые могут выдать данную сумму
     */
    List<BankAtm> getAtmsToExtraditeCredit(Bank bank, Long creditAmount);

    //------------------------------------------------------------
    // какая-то логика добавления/удаления сущностей
    void addAtm(Bank bank);
    void deleteAtm(Bank bank);

    void addBankOffice(Bank bank);
    void deleteBankOffice(Bank bank);

    void addEmployee(Bank bank);
    void deleteEmployee(Bank bank);

    void addClient(Bank bank);
    void deleteClient(Bank bank);
}
