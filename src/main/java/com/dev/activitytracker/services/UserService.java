package com.dev.activitytracker.services;

import com.dev.activitytracker.pojos.User;

import java.util.Optional;

public interface UserService {
//    User createUser(UserDto userDto);
    User saveUser(User user);

    Optional<User> findByUserId(Long userId);



}
