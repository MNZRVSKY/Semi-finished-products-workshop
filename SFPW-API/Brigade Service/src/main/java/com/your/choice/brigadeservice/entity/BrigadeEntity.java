package com.your.choice.brigadeservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(indexName = "workshop_2")
@Accessors(chain = true)
public class BrigadeEntity {
    @Id
    private String id;
    private String headWorkerId;
}
