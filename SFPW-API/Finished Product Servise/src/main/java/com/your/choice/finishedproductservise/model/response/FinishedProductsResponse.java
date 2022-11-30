package com.your.choice.finishedproductservise.model.response;

import com.your.choice.finishedproductservise.entity.ProductStatus;
import com.your.choice.finishedproductservise.entity.ProductType;
import com.your.choice.finishedproductservise.entity.ShiftType;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FinishedProductsResponse {
    private Long id;
    private ProductType productType;
    private ProductStatus productStatus;
    private ShiftType shiftType;
    private Date date;
    private int brigadeNumber;
}
