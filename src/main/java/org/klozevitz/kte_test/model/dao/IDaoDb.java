package org.klozevitz.kte_test.model.dao;

import java.util.List;
import java.util.Optional;

public interface IDaoDb<E> {
    List<E> findAll();

    Optional<E> findById(Integer id);

    E save(E e);

    E update(E e);

    void delete(Integer id);
}
