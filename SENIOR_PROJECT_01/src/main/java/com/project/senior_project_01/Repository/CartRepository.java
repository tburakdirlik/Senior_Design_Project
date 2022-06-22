package com.project.senior_project_01.Repository;

import java.util.List;
import com.project.senior_project_01.Entity.Cart;
import com.project.senior_project_01.Entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findAllByUser(User user);
}

