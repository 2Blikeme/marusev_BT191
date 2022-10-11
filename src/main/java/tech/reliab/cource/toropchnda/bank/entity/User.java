package tech.reliab.cource.toropchnda.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@Builder
public class User {
    private Long id;
    private String fullName;
    private Date birthday;
    private String workPlace;
    private Integer income;
    //------------------------------------
    // TODO: 08.10.2022 сделать списком
    private Bank banks;
    private CreditAccount creditAccounts;
    private PaymentAccount paymentAccounts;
    //-------------------------------------

    private Integer rate;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthday=" + birthday +
                ", workPlace='" + workPlace + '\'' +
                ", income=" + income +
                ", banks=" + banks +
                ", rate=" + rate +
                '}';
    }
}