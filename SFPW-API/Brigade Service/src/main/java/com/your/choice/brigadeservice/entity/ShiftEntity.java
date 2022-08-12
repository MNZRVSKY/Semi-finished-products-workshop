package com.your.choice.brigadeservice.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
@Document(indexName = "workshop_3")
public class ShiftEntity {
    @Id
    private String id;
    private ShiftType shiftType;
    private WorkerEntity head;
    private WorkerEntity duty;
    private List<WorkerEntity> workers;
}
