package in.billo.billo_api.req_resp;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class CategoryResponse {
    private String categoryId;
    private String categoryName;
    private String categoryDescription;
    private String bgColor;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String imgUrl;

}
