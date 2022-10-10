package com.example.kportfolio.Service;

import com.example.kportfolio.Repository.UserRepository;
import com.example.kportfolio.model.User;
import com.example.kportfolio.model.UserWithRoles;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


    @Service
    public class UserDetailLoader extends User implements UserDetailsService {
        private final UserRepository users;

        public UserDetailLoader(UserRepository users) {
            this.users = users;
        }

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            User user = users.findByName(username);
            if (user == null) {
                throw new UsernameNotFoundException("No user found for " + username);
            }
            return new UserWithRoles(user);
        }
    }

