package tech.reliab.cource.toropchnda.bank.repository;

import tech.reliab.cource.toropchnda.bank.entity.Bank;
import tech.reliab.cource.toropchnda.bank.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepository implements Repository<User> {

    private final List<User> entities = new ArrayList<>();

    public void save(User entity) {
        // т.к. ссылка уже находится в массиве,
        // то там уже все изменилось, поэтому не имеет смысла пересохранять
        if (entities.contains(entity)) { return; }
        this.entities.add(entity);
    }

    public User findById(Long id) {
        return entities.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    public List<User> findAll() {
        return entities;
    }

    public void delete(User entity) {
        this.entities.removeIf(el -> el.equals(entity));
    }

    public List<User> findAllByBank(Bank bank) {
        return entities
                .stream()
                .filter(user -> user.getBanks().contains(bank))
                .collect(Collectors.toList());
    }
}
