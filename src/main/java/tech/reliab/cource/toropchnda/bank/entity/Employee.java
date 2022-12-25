package tech.reliab.cource.toropchnda.bank.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import tech.reliab.cource.toropchnda.bank.enums.BankPost;

import java.time.LocalDate;

@Data
@Builder
public class Employee {
    private Long id;
    private String fullName;
    private LocalDate birthday;
    private BankPost post;
    @ToString.Exclude
    private Bank bank;
    private Boolean remotely;
    @ToString.Exclude
    private BankOffice office;
    private Boolean creditAvailable;
    private Integer salary;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", post=" + post +
                ", creditAvailable=" + creditAvailable +
                '}';
    }
}
