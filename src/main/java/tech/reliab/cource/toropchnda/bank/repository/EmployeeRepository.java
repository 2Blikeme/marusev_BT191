package tech.reliab.cource.toropchnda.bank.repository;

import tech.reliab.cource.toropchnda.bank.entity.Bank;
import tech.reliab.cource.toropchnda.bank.entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeRepository implements Repository<Employee> {

    private final List<Employee> entities = new ArrayList<>();

    public void save(Employee entity) {
        // т.к. ссылка уже находится в массиве,
        // то там уже все изменилось, поэтому не имеет смысла пересохранять
        if (entities.contains(entity)) { return; }
        this.entities.add(entity);
    }

    public void delete(Employee entity) {
        this.entities.removeIf(el -> el.equals(entity));
    }

    public List<Employee> findAllByBank(Bank bank) {
        return entities
                .stream()
                .filter(employee -> employee.getBank().equals(bank))
                .collect(Collectors.toList());
    }
}
