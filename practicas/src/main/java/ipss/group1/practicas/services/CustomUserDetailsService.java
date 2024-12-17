package ipss.group1.practicas.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final List<UserDetails> users = List.of(
            User.withUsername("admin")
                    .password("adminPass")
                    .roles("ADMIN")
                    .build(),
            User.withUsername("profesor")
                    .password("profesorPass")
                    .roles("PROFESOR")
                    .build(),
            User.withUsername("estudiante")
                    .password("estudiantePass")
                    .roles("ESTUDIANTE")
                    .build()
    );

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDetails> user = users.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst();
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}