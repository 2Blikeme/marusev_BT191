package tech.reliab.cource.toropchnda.bank.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.reliab.cource.toropchnda.bank.enums.WorkStatus;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankOffice implements Serializable {
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

    @Override
    public String toString() {
        return "BankOffice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", creditAvailable=" + creditAvailable +
                '}';
    }
}
