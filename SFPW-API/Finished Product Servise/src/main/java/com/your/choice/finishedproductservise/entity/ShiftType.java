package com.your.choice.finishedproductservise.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shift_type")
@DynamicUpdate
@Accessors(chain = true)
@Getter
@Setter
public class ShiftType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "shiftType", cascade = CascadeType.ALL)
    List<FinishedProducts> finishedProducts;

}
