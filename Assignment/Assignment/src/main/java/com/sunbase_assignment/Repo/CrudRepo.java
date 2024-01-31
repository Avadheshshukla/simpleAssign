package com.sunbase_assignment.Repo;

import com.sunbase_assignment.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CrudRepo extends JpaRepository<User, String> {


    // User findFirstByUserEmail(String email);

}
