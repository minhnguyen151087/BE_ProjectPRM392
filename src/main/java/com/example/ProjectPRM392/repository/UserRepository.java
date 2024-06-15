package com.example.ProjectPRM392.repository;

import com.example.ProjectPRM392.entity.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;

public interface UserRepository extends CrudRepository<Users, Integer> {
    Users findByUserName(String userName);
    @Query(value ="select * from Users u where u.user_name = :userName and u.password = :password",nativeQuery = true)
    Users loadUserByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);
    @Query(value = "INSERT INTO Users(user_id,user_name,password,name,date_of_birth,phoneNumber,address,role_id)" +
            "VALUES('NEWID()',:userName,:password,:name,:dob,:phoneNumber,:address,:roleId) ",nativeQuery = true)
    int saveUser(@Param("userName") String userName, @Param("password") String password, @Param("name") String name,
                  @Param("dob") Date dob,@Param("phoneNumber") int phoneNumber,
                  @Param("address") String address,@Param("roleId") int roleId);
    boolean existsByUserName(String userName);
}
