package io.swagger.logic.service;

import io.swagger.api.response.UserResponse;
import io.swagger.data.entity.User;
import io.swagger.data.repository.UserRepository;
import io.swagger.logic.exception.AuthorizationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(email).orElseThrow(() -> new UsernameNotFoundException(email));
        return buildUserForAuthentication(user);
    }

    private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user){
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long getLoggedInUserId() throws AuthorizationException {
        return getLoggedInUserEntity().getId();
    }

    public UserResponse getLoggedInUser() throws AuthorizationException {
        User user = getLoggedInUserEntity();
        return new UserResponse(user.getId(), user.getUsername());
    }

    public User getLoggedInUserEntity() throws AuthorizationException {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(principal instanceof org.springframework.security.core.userdetails.User) {
            org.springframework.security.core.userdetails.User user=
                    ((org.springframework.security.core.userdetails.User) principal);
            return userRepository.findByUsername(user.getUsername()).get();
        }
        throw new AuthorizationException();
    }

}
