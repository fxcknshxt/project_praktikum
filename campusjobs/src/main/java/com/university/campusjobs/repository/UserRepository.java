package com.university.campusjobs.repository;

import com.university.campusjobs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}