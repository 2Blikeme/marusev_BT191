package tech.reliab.cource.toropchnda.bank.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
public class PaymentAccount {
    private Long id;
    @ToString.Exclude
    private User user;
    private String bank;
    private Integer moneyAmount;
}
