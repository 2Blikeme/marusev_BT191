package tech.reliab.cource.toropchnda.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tech.reliab.cource.toropchnda.bank.enums.WorkStatus;

@Getter
@Setter
@Builder
public class BankAtm {
    private Long id;
    private String name;
    private WorkStatus status;
    private Bank bank;
    private String location;
    private Employee servingEmployee;
    private Boolean extradition;
    private Boolean introduction;
    private Long moneyAmount;
    private Integer maintenanceCost;

    @Override
    public String toString() {
        return "BankAtm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", bank=" + bank +
                ", location='" + location + '\'' +
                ", extradition=" + extradition +
                ", introduction=" + introduction +
                ", moneyAmount=" + moneyAmount +
                ", maintenanceCost=" + maintenanceCost +
                '}';
    }
}
