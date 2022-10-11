package tech.reliab.cource.toropchnda.bank.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class PaymentAccount {
    private Long id;
    private User user;
    private String bank;
    private Integer moneyAmount;
}
