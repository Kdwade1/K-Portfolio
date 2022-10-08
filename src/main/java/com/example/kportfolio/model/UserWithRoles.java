package com.example.kportfolio.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

    public class UserWithRoles extends User implements UserDetails {

        private User user;

        public UserWithRoles(User user) {
            super(user);  // Call the copy constructor defined in User
            this.user = user;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            String roles = ""; // Since we're not using the authorization part of the component
            return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
        }

        @Override
        public String getPassword() {
            return user.getPassword();
        }

        @Override
        public String getUsername() {
            return null;
        }

        @Override
        public String getName() {
            return user.getName();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return user.isEnable();
        }


    }
