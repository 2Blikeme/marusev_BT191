package tech.reliab.cource.toropchnda.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@Builder
@ToString
public class Employee {
    private Long id;
    private String fullName;
    private Date birthday;
    private String post;
    private Bank bank;
    private Boolean remotely;
    private BankOffice office;
    private Boolean creditAvailable;
    private Integer salary;
}
