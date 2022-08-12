package com.your.choice.brigadeservice.model.response;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class WorkerResponse {
    private String id;
    private String Name;
    private String Surname;
}
