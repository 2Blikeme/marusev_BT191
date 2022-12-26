package tech.reliab.cource.toropchnda.bank.service;

import tech.reliab.cource.toropchnda.bank.entity.Bank;
import tech.reliab.cource.toropchnda.bank.entity.User;

import java.io.IOException;

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


    /**
     * Создает json кредитных аккаунтов пользователя
     */
    void outputCreditAccountsToJson(User user, String fileName) throws IOException;

    /**
     * Создает json платежных аккаунтов пользователя
     */
    void outputPaymentAccountsToJson(User user, String fileName) throws IOException;

    /**
     * Переводит все счета пользователя из старого банка в новый
     */
    boolean transferAccountsToAnotherBank(User user, Bank oldBank, Bank newBank) throws IOException;
}
