package com.your.choice.finishedproductservise.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_type")
@DynamicUpdate
@Accessors(chain = true)
@Getter
@Setter
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "box_weight")
    private float boxWeight;

    @OneToMany(mappedBy = "productType", cascade = CascadeType.ALL)
    List<FinishedProducts> finishedProducts;

}
