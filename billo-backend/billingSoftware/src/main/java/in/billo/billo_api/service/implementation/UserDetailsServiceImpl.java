package in.billo.billo_api.service.implementation;

import in.billo.billo_api.entity.UserEntity;
import in.billo.billo_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity existingUser = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Email not found for mail: " + email));
        return new User(existingUser.getUserEmail(), existingUser.getUserPassword(), Collections.singleton(new SimpleGrantedAuthority(existingUser.getUserRole())));
    }
}
