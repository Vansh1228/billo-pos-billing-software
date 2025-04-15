package in.billo.billo_api.repository;

import in.billo.billo_api.entity.CategoryEntity;
import in.billo.billo_api.req_resp.CategoryRequest;
import in.billo.billo_api.req_resp.CategoryResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findByCategoryId(String id);
}
