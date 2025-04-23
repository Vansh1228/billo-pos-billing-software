package in.billo.billo_api.req_resp;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private String userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userRole;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
