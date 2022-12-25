package tech.reliab.cource.toropchnda.bank.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import tech.reliab.cource.toropchnda.bank.utils.ModelProvider;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class User {
    private Long id;
    private String fullName;
    private LocalDate birthday;
    private String workPlace;
    private Integer income;
    @ToString.Exclude
    private List<Bank> banks;
    @ToString.Exclude
    private List<CreditAccount> creditAccounts;
    @ToString.Exclude
    private List<PaymentAccount> paymentAccounts;
    private Integer rate;

    public void printUserInfo() {
        System.out.println("Клиент: \n" + this);
        System.out.println("Кредитные счета: \n" + ModelProvider.creditAccountRepository.findAllByUser(this));
        System.out.println("Платежные счета: \n" + ModelProvider.paymentAccountRepository.findAllByUser(this));
        System.out.println("Клиент: \n" + this);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", income=" + income +
                ", rate=" + rate +
                '}';
    }
}