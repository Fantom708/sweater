package com.example.sweater.repos;

import com.example.sweater.domain.User;
import com.example.sweater.domain.dto.UserDto;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByActivationCode(String code);


    @Query("select new com.example.sweater.domain.dto.UserDto(u) from User u")
    List<UserDto> findAllwithPosts();
}
