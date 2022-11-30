package com.your.choice.finishedproductservise.model.request;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductTypeRequest {
    private Long id;
    private String name;
    private float boxWeight;
}
