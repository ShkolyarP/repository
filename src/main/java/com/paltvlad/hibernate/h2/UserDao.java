package com.paltvlad.hibernate.h2;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    Optional<User> findById(Long id);
    Optional<User> findByName(String name);
    List<User>findAll();
    void save(User user);
    void updateNameById(Long id, String name);
}
