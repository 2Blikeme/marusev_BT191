package tech.reliab.cource.toropchnda.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@ToString
public class CreditAccount {
    private Long id;
    private User user;
    private String bankName;
    private LocalDate creditStart;
    private LocalDate creditEnd;
    private Integer creditMonthCount;
    private Long creditAmount;
    private Long monthPayment;
    private Integer interestRate;
    private Employee creditor;
    private PaymentAccount paymentAccount;

}
