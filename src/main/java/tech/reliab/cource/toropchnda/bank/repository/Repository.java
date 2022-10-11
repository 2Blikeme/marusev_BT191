package tech.reliab.cource.toropchnda.bank.repository;

public interface Repository<T> {
    void save(T entity);
    void delete(T entity);
}
