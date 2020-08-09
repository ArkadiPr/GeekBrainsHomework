package com.kostandov.geekbrains.homework23.repositories;

import com.kostandov.geekbrains.homework23.entitys.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item,Long> {
}
