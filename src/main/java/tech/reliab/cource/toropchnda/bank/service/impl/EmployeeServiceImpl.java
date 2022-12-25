package tech.reliab.cource.toropchnda.bank.service.impl;

import lombok.AllArgsConstructor;
import tech.reliab.cource.toropchnda.bank.entity.Bank;
import tech.reliab.cource.toropchnda.bank.entity.BankOffice;
import tech.reliab.cource.toropchnda.bank.entity.Employee;
import tech.reliab.cource.toropchnda.bank.enums.BankPost;
import tech.reliab.cource.toropchnda.bank.repository.EmployeeRepository;
import tech.reliab.cource.toropchnda.bank.service.BankService;
import tech.reliab.cource.toropchnda.bank.service.EmployeeService;

import java.time.LocalDate;
import java.util.Random;

@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private BankService bankService;
    private static Long idGenerator = 0L;


    @Override
    public Employee create(String fullName, BankPost post, Bank bank, BankOffice office) {
        Random random = new Random();
        var employee = Employee
                .builder()
                .id(idGenerator++)
                .fullName(fullName)
                .birthday(LocalDate.now().minusYears(random.nextLong(20, 50)))
                .post(post)
                .bank(bank)
                .remotely(random.nextBoolean())
                .office(office)
                .creditAvailable(post == BankPost.CREDITOR && random.nextBoolean())
                .salary(random.nextInt(15000, 50000))
                .build();
        employeeRepository.save(employee);
        bankService.addEmployee(bank);

        return employee;
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
