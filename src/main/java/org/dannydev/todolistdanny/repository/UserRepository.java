package org.dannydev.todolistdanny.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.dannydev.todolistdanny.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
