package org.projekt3_gruppe_3.repository.interfaces;

import java.util.List;

public interface CruRepository<T>{
        void create(T entity);
        void update(T entity);
        List<T> getAll();
        T getById(int id);


}
