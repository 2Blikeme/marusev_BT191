package tech.reliab.cource.toropchnda.bank.entity;

import lombok.Builder;
import lombok.Data;
import tech.reliab.cource.toropchnda.bank.utils.ModelProvider;

@Data
@Builder
public class Bank {
    private Long id;
    private String name;
    private Integer officeCount;
    private Integer atmCount;
    private Integer employeeCount;
    private Integer clientCount;
    private Integer rate;
    private Long moneyAmount;
    private Double interestRate;

    public void printBankInformation() {
        System.out.println("Банк: \n" + this);
        System.out.println("Офисы:");
        ModelProvider.bankOfficeRepository.findAllByBank(this).forEach(System.out::println);
        System.out.println("Сотрудники офисов:");
        ModelProvider.employeeRepository.findAllByBank(this).forEach(System.out::println);
        System.out.println("Клиенты:");
        ModelProvider.userRepository.findAllByBank(this).forEach(User::printUserInfo);
    }
}
