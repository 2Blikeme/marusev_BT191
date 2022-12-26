package tech.reliab.cource.toropchnda.bank.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentAccount {
    private Long id;
    @ToString.Exclude
    @JsonIgnore
    private User user;
    private String bank;
    private Integer moneyAmount;
}
