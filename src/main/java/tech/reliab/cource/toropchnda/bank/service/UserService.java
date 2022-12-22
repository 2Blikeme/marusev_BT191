package tech.reliab.cource.toropchnda.bank.service;

import tech.reliab.cource.toropchnda.bank.entity.Bank;
import tech.reliab.cource.toropchnda.bank.entity.User;

public interface UserService {

    /**
     * Создает пользователя
     * @param fullName      имя
     * @param workPlace     место работы
     * @param bank          банк
     */
    User create(String fullName, String workPlace, Bank bank);


    /**
     * Обновляет пользователя
     */
    void update(User user);

    /**
     * Удаляет пользователя
     */
    void delete(User user);

}
