package tech.reliab.cource.toropchnda.bank;

import tech.reliab.cource.toropchnda.bank.utils.DataGenerator;
import tech.reliab.cource.toropchnda.bank.utils.ModelProvider;

public class Main {

    public static void main(String[] args) {
        DataGenerator generator = new DataGenerator();
        generator.generateData();

        for (int i = 0; i < 3; i++) {
            ModelProvider.bankRepository.getByName("Банк " + i).printBankInformation();
            String separator = "==========================================" +
                    "=====================================================" +
                    "=====================================================" +
                    "===============================";
            System.out.println(separator);

        }


    }
}
