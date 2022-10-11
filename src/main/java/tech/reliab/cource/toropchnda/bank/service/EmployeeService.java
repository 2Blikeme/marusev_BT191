package tech.reliab.cource.toropchnda.bank.service;

import tech.reliab.cource.toropchnda.bank.entity.Bank;
import tech.reliab.cource.toropchnda.bank.entity.BankOffice;
import tech.reliab.cource.toropchnda.bank.entity.Employee;

public interface EmployeeService {
    Employee create(String fullName, String post, Bank bank, BankOffice office);
    Employee getEmployee();
    void update(Employee employee);
    void delete(Employee employee);
}
