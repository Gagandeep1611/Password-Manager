package com.project.passwordManager.Repository;

import com.project.passwordManager.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {


    Users findByEmail(String email);
}
