package com.sys.gin.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface EntityMapper<E, D> {
  D toDTO(E entity);

  E toEntity(D dto);

  default List<D> toDTOList(List<E> entityList) {
    if (entityList == null) {
      return null;
    }

    return entityList.stream().map(this::toDTO).collect(Collectors.toList());
  }

  default List<E> toEntityList(List<D> dtoList) {
    if (dtoList == null) {
      return null;
    }

    return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
  }
}
