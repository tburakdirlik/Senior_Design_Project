package com.project.senior_project_01.Repository;

import org.springframework.stereotype.Repository;
import com.project.senior_project_01.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

}
