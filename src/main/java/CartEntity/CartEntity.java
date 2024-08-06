package CartEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kibuti.onlinestores.EcommerceMNG.CartMNG.Payload.CartStatus;
import com.kibuti.onlinestores.UserMNG.Entity.UserManger;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


@Entity
@Table(name = "carts_table")
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @JsonIgnore
    @OneToOne
    private UserManger cartOwner;

    @JsonManagedReference
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartItems> cartItems = new ArrayList<>();

//    @Column(name = "total_items")
//    private int itemsNumber;

//    @Column(name = "total_price")
//    private BigDecimal totalPrice;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "last_updated_date")
    private LocalDateTime lastUpdatedDate;

    @Enumerated(EnumType.STRING)
    private CartStatus status;

}
