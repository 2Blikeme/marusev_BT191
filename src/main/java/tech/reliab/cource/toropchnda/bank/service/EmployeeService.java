package tech.reliab.cource.toropchnda.bank.service;

import tech.reliab.cource.toropchnda.bank.entity.Bank;
import tech.reliab.cource.toropchnda.bank.entity.BankOffice;
import tech.reliab.cource.toropchnda.bank.entity.Employee;
import tech.reliab.cource.toropchnda.bank.enums.BankPost;

public interface EmployeeService {

    /**
     * Создает сотрудника банка
     * @param fullName      имя
     * @param post          должность
     * @param bank          банк
     * @param office        офис
     */
    Employee create(String fullName, BankPost post, Bank bank, BankOffice office);

    /**
     * Возвращает сотрудника
     */
    Employee getEmployee();

    /**
     * Обновляет сотрудника
     */
    void update(Employee employee);

    /**
     * Удаляет сотрудника
     */
    void delete(Employee employee);
}
