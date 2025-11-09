package com.singularix.restfulws.jpa;
import org.springframework.data.jpa.repository.JpaRepository;

import com.singularix.restfulws.user.User;

public interface UserRepository extends JpaRepository <User, Integer>{

}
