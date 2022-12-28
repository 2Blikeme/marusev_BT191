package tech.reliab.cource.toropchnda.bank.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tech.reliab.cource.toropchnda.bank.enums.BankPost;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {
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
