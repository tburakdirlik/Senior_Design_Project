package com.project.senior_project_01.Repository;

import org.springframework.stereotype.Repository;
import com.project.senior_project_01.Entity.OrderAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderAdminRepository extends JpaRepository<OrderAdmin, Integer> {

}
