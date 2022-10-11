package tech.reliab.cource.toropchnda.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Builder
public class Bank {
    private Long id;
    private String name;
    private Integer officeCount;
    private Integer atmCount;
    private Integer employeeCount;
    private Integer clientCount;
    private Integer rate;
    private Long moneyAmount;
    private Integer interestRate;
}

