package com.g1dra.crm.repositories;

import com.g1dra.crm.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
