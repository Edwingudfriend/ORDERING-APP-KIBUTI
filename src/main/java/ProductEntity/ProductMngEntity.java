package ProductEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.kibuti.onlinestores.PosMNG.Category.Entity.CategoryEntity;
import com.kibuti.onlinestores.PosMNG.Products.Payload.MapToJsonConverter;
import com.kibuti.onlinestores.PosMNG.Shop.Entity.ShopEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "product_table")
public class ProductMngEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "shop_Id")
    private ShopEntity shop;
    private String name;
    private BigDecimal price;
    private BigDecimal discount;
    private String packs;
    private Boolean isInStock;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Convert(converter = MapToJsonConverter.class)
    @Column(name = "prduct_images", columnDefinition = "jsonb")
    private Map<String, String> images;

    private Boolean isDeleted;

}

