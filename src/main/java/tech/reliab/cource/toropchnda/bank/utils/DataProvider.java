package tech.reliab.cource.toropchnda.bank.utils;

import java.util.List;
import java.util.Random;

public class DataProvider {

    private final static List<String> names = List.of(
            "Иванов Иван Иванович",
            "Петров Петр Петрович",
            "Игорев Игорь Игоревич",
            "Ирова Ирина Игоревна",
            "Владиимир Александрович Зеле́нский",
            "Фывовна Светлана Ивановна",
            "Путин Владимир Владимирович",
            "Медведев Дмитрий Анатольевич"
    );

    private final static List<String> workPlaces = List.of(
            "Пятерочка",
            "Магнит",
            "Сбербанк",
            "Вкусвилл",
            "Вуз",
            "Школа",
            "Детский сад",
            "Яндекс"
    );

    private static final Random random = new Random();

    public static String getRandomName() {
        return names.get(random.nextInt(names.size()));
    }

    public static String getRandomWorkSpace() {
        return workPlaces.get(random.nextInt(names.size()));
    }

}
