package tech.reliab.cource.toropchnda.bank.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentAccount {
    private Long id;
    private User user;
    private String bank;
    private Integer moneyAmount;
}
