package com.devsuperior.demo.services;

import com.devsuperior.demo.entities.Role;
import com.devsuperior.demo.entities.User;
import com.devsuperior.demo.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private static final String USER_NOT_FOUND = "User not found.";

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByEmail(username);

        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.getRoles().addAll(getAuthorities(user));
        return newUser;
    }

    protected User findByEmail(String email) {
        User user = repository.findByEmailIgnoreCase(email);
        if (Objects.isNull(user)) throw new UsernameNotFoundException(USER_NOT_FOUND);

        return user;
    }

    protected Set<Role> getAuthorities(User user) {
        return user.getAuthorities()
                .stream()
                .map(role -> new Role(role.getAuthority()))
                .collect(Collectors.toSet());
    }
}
