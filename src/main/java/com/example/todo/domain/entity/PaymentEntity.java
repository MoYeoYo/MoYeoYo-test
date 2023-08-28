package com.example.todo.domain.entity;

import com.example.todo.domain.entity.enums.PayMethod;
import com.example.todo.domain.entity.enums.PayStatus;
import com.example.todo.domain.entity.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@Table(name = "Payment")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String impUid;

    private BigDecimal amount;
    private String merchantUid;

    private String payStatus;

    private String payMethod;

    private LocalDateTime paymentDate;

    @ManyToOne
    private User user;

    @OneToOne
    private TeamSubscriptionEntity teamSubscription;


    @Builder
    public PaymentEntity(Long id, String impUid, BigDecimal amount, String merchantUid, String payStatus, String payMethod, LocalDateTime paymentDate, User user, TeamSubscriptionEntity teamSubscription) {
        this.id = id;
        this.impUid = impUid;
        this.amount = amount;
        this.merchantUid = merchantUid;
        this.payStatus = payStatus;
        this.payMethod = payMethod;
        this.paymentDate = paymentDate;
        this.user = user;
        this.teamSubscription = teamSubscription;
    }
}
