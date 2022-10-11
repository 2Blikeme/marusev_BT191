package tech.reliab.cource.toropchnda.bank.service;

import tech.reliab.cource.toropchnda.bank.entity.Bank;
import tech.reliab.cource.toropchnda.bank.entity.User;

public interface UserService {

    User create(String fullName, String workPlace, Bank bank);
    User getUser();
    void update(User user);
    void delete(User user);

}
