package tech.reliab.cource.toropchnda.bank.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import tech.reliab.cource.toropchnda.bank.enums.BankPost;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class Employee {
    private Long id;
    private String fullName;
    private LocalDate birthday;
    private BankPost post;
    private Bank bank;
    private Boolean remotely;
    private BankOffice office;
    private Boolean creditAvailable;
    private Integer salary;
}
