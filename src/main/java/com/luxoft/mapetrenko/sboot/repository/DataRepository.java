package com.luxoft.mapetrenko.sboot.repository;

import com.luxoft.mapetrenko.sboot.entity.DomainObject;

import java.util.Set;

public interface DataRepository<T extends DomainObject> {

    void persist(T object);

    void delete(T object);

    Set<String> getRandomData();
}
