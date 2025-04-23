package in.billo.billo_api.service.implementation;

import in.billo.billo_api.entity.UserEntity;
import in.billo.billo_api.repository.UserRepository;
import in.billo.billo_api.req_resp.UserRequest;
import in.billo.billo_api.req_resp.UserResponse;
import in.billo.billo_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse createUser(UserRequest request) {
        UserEntity newUser = convertToEntity(request);
        newUser = userRepository.save(newUser);
        return convertToResponse(newUser);
    }

    private UserResponse convertToResponse(UserEntity newUser) {
        return UserResponse.builder().userEmail(newUser.getUserEmail()).userName(newUser.getUserName())
                .userPassword(newUser.getUserPassword()).userRole(newUser.getUserRole())
                .userId(newUser.getUserId())
                .updatedAt(newUser.getUpdatedAt())
                .createdAt(newUser.getCreatedAt())
                .build();
    }

    private UserEntity convertToEntity(UserRequest request) {
        return UserEntity.builder().userId(UUID.randomUUID().toString()).userEmail(request.getUserEmail())
                .userPassword(request.getUserPassword()).userName(request.getUserName())
                .userRole(request.getUserRole()).build();
    }

    @Override
    public String getUserRole(String email) {
        UserEntity existingUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));
        return existingUser.getUserRole();
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream().map(user -> convertToResponse(user))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(String id) {
        UserEntity existingUser = userRepository.findByUserId(id)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
        userRepository.delete(existingUser);
    }
}
