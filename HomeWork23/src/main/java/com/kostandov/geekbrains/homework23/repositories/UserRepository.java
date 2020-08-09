package com.kostandov.geekbrains.homework23.repositories;

import com.kostandov.geekbrains.homework23.entitys.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
