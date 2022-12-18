package tech.reliab.cource.toropchnda.bank.enums;

import java.util.Random;

public enum WorkStatus {
    WORKING("Работает"),
    NOT_WORKING("Не работает"),
    NO_MONEY("Нет денег");

    private final String name;
    private static final Random random = new Random();

    WorkStatus(String name) {
        this.name = name;
    }

    public static WorkStatus getRandomStatus() {
        var values = values();
        return values[random.nextInt(values.length)];
    }

    @Override
    public String toString() {
        return name;
    }
}
