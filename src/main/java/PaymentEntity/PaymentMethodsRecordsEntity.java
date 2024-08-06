package PaymentEntity;

import com.kibuti.onlinestores.PaymentMNG.PaymentRecordMNG.Payloads.PayChannels;
import com.kibuti.onlinestores.UserMNG.Entity.UserManger;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "pay_methods_records_table")
public class PaymentMethodsRecordsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID recordId;

    private String accountName;
    private String provider;
    private String accountNumber;
    private Boolean isDefault;

    @Enumerated(EnumType.STRING)
    private PayChannels payChannels;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserManger userManger;

    private Boolean isDeleted;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", updatable = false)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date")
    private Date updatedDate;

}
