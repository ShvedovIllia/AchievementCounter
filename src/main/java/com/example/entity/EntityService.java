package com.example.entity;

import java.util.List;

public interface EntityService<T, D> {
    T getById(Long id);

    List<T> getAll();

    D create(D dto);

    D update(D dto, Long id);
}
