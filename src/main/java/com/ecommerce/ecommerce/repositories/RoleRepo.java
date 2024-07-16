package com.ecommerce.ecommerce.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecommerce.entites.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

}
