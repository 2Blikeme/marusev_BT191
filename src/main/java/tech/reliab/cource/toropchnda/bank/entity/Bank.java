package tech.reliab.cource.toropchnda.bank.entity;

import lombok.Builder;
import lombok.Data;

@Data
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
    private Double interestRate;
}

