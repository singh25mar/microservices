package com.lcwd.user.service.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.user.service.entity.User;

public interface UserRepository extends JpaRepository<User, String> {



}
