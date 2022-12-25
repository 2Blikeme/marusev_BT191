package tech.reliab.cource.toropchnda.bank.service;

import tech.reliab.cource.toropchnda.bank.entity.Bank;
import tech.reliab.cource.toropchnda.bank.entity.BankAtm;
import tech.reliab.cource.toropchnda.bank.entity.BankOffice;

import java.util.List;

public interface BankOfficeService {

    /**
     * Создает офис
     * @param name      имя офиса
     * @param address   адресс
     * @param bank      банк
     */
    BankOffice create(String name, String address, Bank bank);

    /**
     * Обновляет банк
     */
    void update(BankOffice bankOffice);

    /**
     * Удаляет банк
     */
    void delete(BankOffice bankOffice);

    /**
     * Добавляет банкомат в офис
     */
    void addAtm(BankOffice office, BankAtm bankAtm);

    /**
     * Возвращает все работающие офисы банка выдающие кредит
     */
    List<BankOffice> getAllWorksOffices(Bank bank);
}
