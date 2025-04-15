package in.billo.billo_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "category")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String categoryId;
    @Column(unique = true)
    private String categoryName;
    private String categoryDescription;
    private String bgColor;
    private String imgUrl;
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
