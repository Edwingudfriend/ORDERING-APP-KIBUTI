package CartEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import CartEntity.CartEntity;
import com.kibuti.onlinestores.PosMNG.Products.Entity.ProductMngEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "cart_items")
public class CartItems {

    @JsonProperty("itemId")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "cart_id")
    private CartEntity cart;

    private String productName;
    private String productImage;
    private UUID shopId;
    @JsonIgnore
    @ManyToOne
    private ProductMngEntity product;
    @Column(name = "product_id_ref")
    private UUID productId;
    private BigDecimal unitPrice;
    private int quantity;
    private BigDecimal shippingFee;
    private BigDecimal totalPrice;

}
