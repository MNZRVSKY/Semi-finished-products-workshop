package com.your.choice.finishedproductservise.model.request;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Column;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductStatusRequest {
    private Long id;
    private String status;
}
