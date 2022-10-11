package tech.reliab.cource.toropchnda.bank.service;

import tech.reliab.cource.toropchnda.bank.entity.Bank;
import tech.reliab.cource.toropchnda.bank.entity.BankOffice;

public interface BankOfficeService {
    BankOffice create(String name, String address, Bank bank);

    BankOffice getBankOffice();

    void update(BankOffice bankOffice);

    void delete(BankOffice bankOffice);
}
