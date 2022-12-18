package tech.reliab.cource.toropchnda.bank.enums;

import java.util.Random;

public enum BankPost {

    // НЕ могут выдавать кредиты
    SECURITY_GUARD("Охраник"),
    DIRECTOR("Директор"),

    // Могут выдавать кредиты
    CREDITOR("Кредитор");

    private final String name;

    BankPost(String name) {
        this.name = name;
    }

    private static final Random random = new Random();

    public static BankPost getRandomPost() {
        var values = values();
        return values[random.nextInt(values.length)];
    }

    @Override
    public String toString() {
        return name;
    }
}
