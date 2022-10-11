package tech.reliab.cource.toropchnda.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tech.reliab.cource.toropchnda.bank.enums.WorkStatus;

@Getter
@Setter
@Builder
@ToString
public class BankOffice {
    private Long id;
    private String name;
    private String address;
    private WorkStatus status;
    private Boolean placeAtmAvailable;
    private Integer atmCount;
    private Boolean creditAvailable;
    private Boolean extradition;
    private Boolean introduction;
    private Long moneyAmount;
    private Integer rentCost;

    private Bank bank;
}
