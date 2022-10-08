package com.example.kportfolio.Service;

import com.example.kportfolio.Repository.UserRepository;
import com.example.kportfolio.model.User;
import com.example.kportfolio.model.UserWithRoles;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

public class UserDetailLoader {
    @Service
    public
    class UserDetailsLoader extends User implements UserDetailsService {
        private final UserRepository users;

        public UserDetailsLoader(UserRepository users) {
            this.users = users;
        }

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            User user = users.findByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("No user found for " + username);
            }
            return new UserWithRoles(user);
        }
    }
}
