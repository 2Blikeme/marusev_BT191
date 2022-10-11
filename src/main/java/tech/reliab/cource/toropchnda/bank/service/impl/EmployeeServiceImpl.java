package tech.reliab.cource.toropchnda.bank.service.impl;

import lombok.AllArgsConstructor;
import tech.reliab.cource.toropchnda.bank.entity.Bank;
import tech.reliab.cource.toropchnda.bank.entity.BankOffice;
import tech.reliab.cource.toropchnda.bank.entity.Employee;
import tech.reliab.cource.toropchnda.bank.repository.EmployeeRepository;
import tech.reliab.cource.toropchnda.bank.service.BankService;
import tech.reliab.cource.toropchnda.bank.service.EmployeeService;

import java.time.Instant;
import java.util.Date;
import java.util.Random;

@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private BankService bankService;

    private static Long idGenerator = 0L;

    /**
     * Создает сотрудника банка, увеличивает число сотрудников в банке
     */
    @Override
    public Employee create(String fullName, String post, Bank bank, BankOffice office) {
        Random random = new Random();
        var employee = Employee
                .builder()
                .id(idGenerator++)
                .fullName(fullName)
                .birthday(Date.from(Instant.now()))
                .post(post)
                .bank(bank)
                .remotely(random.nextBoolean())
                .office(office)
                .creditAvailable(random.nextBoolean())
                .salary(random.nextInt(100_000))
                .build();
        employeeRepository.save(employee);
        bankService.addEmployee(bank);

        return employee;
    }

    @Override
    public Employee getEmployee() {
        return employeeRepository.getEntity();
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
        bankService.deleteEmployee(employee.getBank());
    }
}
