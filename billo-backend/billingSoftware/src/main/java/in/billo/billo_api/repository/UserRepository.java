package in.billo.billo_api.repository;

import in.billo.billo_api.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUserId(Long id);
    Optional<UserEntity> findByEmail(String email);
}
