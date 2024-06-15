package com.example.ProjectPRM392.repository;

import com.example.ProjectPRM392.entity.Roles;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Roles,Integer> {
    @Query(value = "SELECT * FROM Roles where role_id = :roleId",nativeQuery = true)
    Roles getRoleById(@Param("roleId") int roleId);
}
