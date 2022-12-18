package tech.reliab.cource.toropchnda.bank.repository;

import lombok.Getter;
import tech.reliab.cource.toropchnda.bank.entity.User;

import java.util.Objects;

@Getter
public class UserRepository implements Repository<User> {

    private User entity;

    public void save(User entity) {
        this.entity = entity;
    }

    public void delete(User entity) {
        if (this.entity.equals(entity)) {
            this.entity = null;
        }
    }
}
