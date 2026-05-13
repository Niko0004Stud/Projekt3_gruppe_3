package org.projekt3_gruppe_3.repository.interfaces;

import java.util.List;

public interface CrudRepository<T> {
    void create(T entity);
    void update(T entity);
    void delete(int id);
    List<T> getAll();
    T getById(int id);
}
