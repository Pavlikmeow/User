package com.shop.user.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(schema = "users", name = "notifications")
@DynamicUpdate
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "message")
    private String message;

    @Column(name = "date", updatable = false, nullable = false)
    private Date date = Date.valueOf(LocalDate.now());

    @Column(name = "user_id", insertable = false, updatable = false, nullable = false)
    private UUID userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

}
