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
@Document(indexName = "workshop")
@Accessors(chain = true)
public class WorkerEntity {
    @Id
    private String id;
    private String name;
    private String surname;

    public WorkerEntity(String id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public WorkerEntity(String name, String surname) {
        id = "";
        this.name = name;
        this.surname = surname;
    }
}
