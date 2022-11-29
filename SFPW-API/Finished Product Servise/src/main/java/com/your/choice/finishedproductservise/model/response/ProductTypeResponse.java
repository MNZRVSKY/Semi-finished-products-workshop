package com.your.choice.finishedproductservise.model.response;


import lombok.*;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductTypeResponse {
    private Long id;
    private String name;
    private float boxWeight;
}
