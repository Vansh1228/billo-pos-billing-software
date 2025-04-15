package in.billo.billo_api.service.implementation;

import in.billo.billo_api.entity.CategoryEntity;
import in.billo.billo_api.req_resp.CategoryRequest;
import in.billo.billo_api.req_resp.CategoryResponse;
import in.billo.billo_api.repository.CategoryRepository;
import in.billo.billo_api.service.CategoryService;
import in.billo.billo_api.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final FileUploadService fileUploadService;

    @Override
    public CategoryResponse add(CategoryRequest request, MultipartFile file) {
        String imgUrl = fileUploadService.uploadFile(file);
        CategoryEntity newCategory = convertToEntity(request);
        newCategory.setImgUrl(imgUrl);
        newCategory = categoryRepository.save(newCategory);
        return convertToResponse(newCategory);
    }

    @Override
    public List<CategoryResponse> getCategories() {
        return categoryRepository.findAll().stream().map(cat -> convertToResponse(cat)).collect(Collectors.toList());
    }

    @Override
    public void delete(String categoryId) {
        CategoryEntity existingCategory =  categoryRepository.findByCategoryId(categoryId).orElseThrow(()-> new RuntimeException("Category Not Found "+ categoryId));
        fileUploadService.deleteFile(existingCategory.getImgUrl());
        categoryRepository.delete(existingCategory);
    }

    @Override
    public CategoryResponse update(String categoryId) {
        return null;
    }

    private CategoryResponse convertToResponse(CategoryEntity newCategory) {
        return CategoryResponse.builder().categoryId(newCategory.getCategoryId())
                .categoryName(newCategory.getCategoryName()).categoryDescription(newCategory.getCategoryDescription())
                .bgColor(newCategory.getBgColor()).imgUrl(newCategory.getImgUrl()).createdAt(newCategory.getCreatedAt())
                .updatedAt(newCategory.getUpdatedAt()).build();
    }

    private CategoryEntity convertToEntity(CategoryRequest request) {
        return CategoryEntity.builder().categoryId(UUID.randomUUID().toString()).categoryName(request.getCategoryName())
                .categoryDescription(request.getCategoryDescription()).bgColor(request.getBgColor()).build();
    }
}
