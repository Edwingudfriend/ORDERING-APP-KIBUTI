package OrderEntity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kibuti.onlinestores.EcommerceMNG.CartMNG.Entity.CartEntity;
import com.kibuti.onlinestores.OrderMNG.Payload.OrderStatus;
import com.kibuti.onlinestores.OrderMNG.Payload.PaymentStatus;
import com.kibuti.onlinestores.PaymentMNG.PaymentRecordMNG.Entity.PaymentMethodsRecordsEntity;
import com.kibuti.onlinestores.PosMNG.Products.Entity.ProductMngEntity;
import com.kibuti.onlinestores.PosMNG.Shop.Entity.ShopEntity;
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
@Table(name = "orders_table")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID orderId;

    private String orderNumber;

    private String trackingNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id")
    private UserManger buyer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private ShopEntity shop;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<OrderItem> orderItems = new ArrayList<>();

    private BigDecimal orderTotalPrice;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_records_id")
    private PaymentMethodsRecordsEntity paymentMethodsRecords;


    private boolean viewedByShopOwner;

    private boolean acknowledgedByBuyer;

}
