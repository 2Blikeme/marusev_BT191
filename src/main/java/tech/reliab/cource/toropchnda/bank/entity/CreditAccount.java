package tech.reliab.cource.toropchnda.bank.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@Builder
public class CreditAccount {
    private Long id;
    @ToString.Exclude
    private User user;
    private String bankName;
    private LocalDate creditStart;
    private LocalDate creditEnd;
    private Integer creditMonthCount;
    private Long creditAmount;
    private Double monthPayment;
    private Double interestRate;
    @ToString.Exclude
    private Employee creditor;
    @ToString.Exclude
    private PaymentAccount paymentAccount;

    @Override
    public String toString() {
        return "CreditAccount{" +
                "id=" + id +
                ", bankName='" + bankName + '\'' +
                ", creditStart=" + creditStart +
                ", creditEnd=" + creditEnd +
                ", creditMonthCount=" + creditMonthCount +
                ", creditAmount=" + creditAmount +
                ", monthPayment=" + monthPayment +
                '}';
    }
}
