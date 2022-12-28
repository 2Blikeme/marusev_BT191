package tech.reliab.cource.toropchnda.bank.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentAccount implements Serializable {
    private Long id;
    @ToString.Exclude
    private User user;
    private String bank;
    private Integer moneyAmount;
}
