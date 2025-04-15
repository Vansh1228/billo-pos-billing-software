package in.billo.billo_api.service;

import in.billo.billo_api.req_resp.CategoryRequest;
import in.billo.billo_api.req_resp.CategoryResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CategoryService {
    CategoryResponse add(CategoryRequest request, MultipartFile file);
    List<CategoryResponse> getCategories();
    void delete(String categoryId);
    CategoryResponse update(String categoryId);
}

