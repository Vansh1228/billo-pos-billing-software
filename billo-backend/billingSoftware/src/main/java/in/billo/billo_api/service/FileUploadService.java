package in.billo.billo_api.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    String uploadFile(MultipartFile file);
    Boolean deleteFile(String imgUrl);
}
