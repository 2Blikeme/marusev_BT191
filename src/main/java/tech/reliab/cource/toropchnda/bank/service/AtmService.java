package tech.reliab.cource.toropchnda.bank.service;

import tech.reliab.cource.toropchnda.bank.entity.Bank;
import tech.reliab.cource.toropchnda.bank.entity.BankAtm;
import tech.reliab.cource.toropchnda.bank.entity.BankOffice;
import tech.reliab.cource.toropchnda.bank.entity.Employee;

public interface AtmService {

    /**
     * Создает банкомат
     * @param name      имя банкомата
     * @param bank      банк, к котором пренадлежит банкомат
     * @param office    офис
     * @param employee  обслуживающий сотрудник
     */
    BankAtm create(String name, Bank bank, BankOffice office, Employee employee);


    /**
     * Удаляет банкомат
     */
    void delete(BankAtm bankAtm);

    /**
     * Обновляет банкомат
     */
    void update(BankAtm bankAtm);
}
