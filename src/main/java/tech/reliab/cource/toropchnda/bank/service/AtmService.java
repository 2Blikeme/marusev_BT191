package tech.reliab.cource.toropchnda.bank.service;

import tech.reliab.cource.toropchnda.bank.entity.Bank;
import tech.reliab.cource.toropchnda.bank.entity.BankAtm;
import tech.reliab.cource.toropchnda.bank.entity.BankOffice;
import tech.reliab.cource.toropchnda.bank.entity.Employee;

public interface AtmService {

    BankAtm create(String name, Bank bank, BankOffice office, Employee employee);

    BankAtm getBankAtm();

    void delete(BankAtm bankAtm);

    void update(BankAtm bankAtm);
}
