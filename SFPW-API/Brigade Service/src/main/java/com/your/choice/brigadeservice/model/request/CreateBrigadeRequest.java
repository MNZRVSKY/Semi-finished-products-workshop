package com.your.choice.brigadeservice.model.request;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CreateBrigadeRequest {
    private String headWorkerId;
}
