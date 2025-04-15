package in.billo.billo_api.req_resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest {
    private String categoryName;
    private String categoryDescription;
    private String bgColor;
}
