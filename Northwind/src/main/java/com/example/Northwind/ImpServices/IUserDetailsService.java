package com.example.Northwind.ImpServices;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Set;

public class IUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var user = getById(username);

        if (user == null)
            throw new UsernameNotFoundException(username);
        return User
                .withUsername(username)
                .password(user.password())
                .roles(user.roles().toArray(new String[0]))
                .build();
    }

    public record User(String username, String password, Set<String> roles) {}

    public static User getById(String username) {
        var password = "$2a$10$56VCAiApLO8NQYeOPiu2De/EBC5RWrTZvLI7voeC3r/iXinRiiiq";
        User josue = new User(
          "josueth",
          password,
          Set.of("USER")
        );

        User zule = new User(
                "zulelc",
                password,
                Set.of("ADMIN")
        );

        var users = List.of(josue, zule);

        return users
                .stream()
                .filter(e -> e.username.equals(username))
                .findFirst()
                .orElse(null);
    }
}