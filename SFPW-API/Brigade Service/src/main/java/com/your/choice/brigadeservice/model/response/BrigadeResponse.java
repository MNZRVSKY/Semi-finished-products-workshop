package com.your.choice.brigadeservice.model.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BrigadeResponse {
    private String id;
    private String headWorkerId;
}
