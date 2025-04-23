package in.billo.billo_api.req_resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@AllArgsConstructor
public class AuthResponse {
    private String email;
    private String token;
    private  String role;
}
