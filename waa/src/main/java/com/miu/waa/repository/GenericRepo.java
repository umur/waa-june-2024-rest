package com.miu.waa.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GenericRepo<T> {

    private List<T> entities = new ArrayList<>();

    public void add(T entity) {
        entities.add(entity);
    }

    public List<T> getEntities() {
        return entities;
    }

    public T getById(Long id) {
        return null;
    }
}
