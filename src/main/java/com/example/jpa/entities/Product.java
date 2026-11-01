package com.example.jpa.entities;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="product_table",
        uniqueConstraints = {
        @UniqueConstraint(name="sku_unique",columnNames = {"sku"}),
                @UniqueConstraint(name="title_price_unique",columnNames = {"title_x","price"})
        },
        indexes = {@Index(name="sku_index",columnList = "sku")}
)

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String sku;
    @Column(name="title_x", nullable=false)
    private String title;
    private BigDecimal price;
    private Integer quantity;
    @CreationTimestamp
    public LocalDateTime createdAt;
    @UpdateTimestamp
    public LocalDateTime updatedAt;
}
