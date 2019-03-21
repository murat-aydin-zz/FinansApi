package com.kocfinans.kocfinans.service;


import com.kocfinans.kocfinans.command.UsersCommand;
import com.kocfinans.kocfinans.converter.UsersToUsersCommandConverter;
import com.kocfinans.kocfinans.domain.Users;
import com.kocfinans.kocfinans.model.CustomUserDetails;
import com.kocfinans.kocfinans.repository.UsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    UsersRepository usersRepository;
    UsersToUsersCommandConverter usersToUsersCommandConverter;

    public CustomUserDetailsService(UsersRepository usersRepository, UsersToUsersCommandConverter usersToUsersCommandConverter) {
        this.usersRepository = usersRepository;
        this.usersToUsersCommandConverter = usersToUsersCommandConverter;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> userOptional = usersRepository.findByUserName(username);

        userOptional.orElseThrow(() ->new UsernameNotFoundException("user not found"));

        Optional<UsersCommand> usersCommandOptional = Optional.of(usersToUsersCommandConverter.convert(userOptional.get()));

        return usersCommandOptional.map(CustomUserDetails::new).get();

    }
}