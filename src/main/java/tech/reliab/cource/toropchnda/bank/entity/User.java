package tech.reliab.cource.toropchnda.bank.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class User {
    private Long id;
    private String fullName;
    private LocalDate birthday;
    private String workPlace;
    private Integer income;
    //------------------------------------
    // TODO: 08.10.2022 сделать списком
    private Bank banks;
    @ToString.Exclude
    private CreditAccount creditAccounts;
    @ToString.Exclude
    private PaymentAccount paymentAccounts;
    //-------------------------------------
    private Integer rate;

}