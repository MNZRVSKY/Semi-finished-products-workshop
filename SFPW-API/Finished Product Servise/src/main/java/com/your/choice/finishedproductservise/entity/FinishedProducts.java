package com.your.choice.finishedproductservise.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "finished_products")
@DynamicUpdate
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FinishedProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

    @ManyToOne
    @JoinColumn(name = "product_status_id")
    private ProductStatus productStatus;

    @ManyToOne
    @JoinColumn(name = "shift_type_id")
    private ShiftType shiftType;

    @Column(name = "date")
    private Date date;

    @Column(name = "brigade_number")
    private int brigadeNumber;

}
