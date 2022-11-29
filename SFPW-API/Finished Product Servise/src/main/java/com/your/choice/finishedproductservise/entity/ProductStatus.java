package com.your.choice.finishedproductservise.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_status")
@DynamicUpdate
@Accessors(chain = true)
@Getter
@Setter
public class ProductStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "productStatus", cascade = CascadeType.ALL)
    List<FinishedProducts> finishedProducts;

}
