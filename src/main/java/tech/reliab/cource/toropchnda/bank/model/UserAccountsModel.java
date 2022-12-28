package tech.reliab.cource.toropchnda.bank.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tech.reliab.cource.toropchnda.bank.entity.CreditAccount;
import tech.reliab.cource.toropchnda.bank.entity.PaymentAccount;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
public class UserAccountsModel implements Serializable {
    private List<CreditAccount> creditAccount;
    private List<PaymentAccount> paymentAccounts;
}
