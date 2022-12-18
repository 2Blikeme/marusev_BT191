package tech.reliab.cource.toropchnda.bank.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import tech.reliab.cource.toropchnda.bank.enums.WorkStatus;

@Data
@Builder
public class BankAtm {
    private Long id;
    private String name;
    private WorkStatus status;
    @ToString.Exclude
    private Bank bank;
    private String location;
    @ToString.Exclude
    private Employee servingEmployee;
    private Boolean extradition;
    private Boolean introduction;
    private Long moneyAmount;
    private Integer maintenanceCost;
}
