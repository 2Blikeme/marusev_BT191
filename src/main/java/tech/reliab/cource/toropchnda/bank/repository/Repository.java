package tech.reliab.cource.toropchnda.bank.repository;

public interface Repository<T> {

    /**
     * Сохраняет сущность
     */
    void save(T entity);

    /**
     * Удаляет сущность
     */
    void delete(T entity);
}
