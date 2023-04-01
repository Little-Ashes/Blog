package com.ggl.service;

import com.ggl.domain.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeService {
    Type saveType(Type type);

    Type getTypes(Long id);

    Page<Type> listType(Pageable pageable);

    List<Type> listType();

    List<Type> listTypeTop(Integer size);

    Type getTypeByName(String name);

    Type updateType(Long id,Type type);

    void deleteType(Long id);
}
