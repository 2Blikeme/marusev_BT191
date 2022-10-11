package tech.reliab.cource.toropchnda.bank.repository;

import lombok.Getter;
import tech.reliab.cource.toropchnda.bank.entity.Employee;

import java.util.Objects;

@Getter
public class EmployeeRepository implements Repository<Employee> {

    private Employee entity;

    public void save(Employee entity) {
        this.entity = entity;
    }

    public void delete(Employee entity) {
        if (Objects.equals(this.entity, entity)) {
            this.entity = null;
        }
    }
}
