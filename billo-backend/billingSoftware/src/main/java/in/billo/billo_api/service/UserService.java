package in.billo.billo_api.service;

import in.billo.billo_api.req_resp.UserRequest;
import in.billo.billo_api.req_resp.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserRequest request);

    String getUserRole(String email);

    List<UserResponse> getAllUsers();

    void deleteUser(String id);
}
