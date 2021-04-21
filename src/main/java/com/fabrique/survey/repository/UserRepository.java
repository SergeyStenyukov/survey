package com.fabrique.survey.repository;

import com.fabrique.survey.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
