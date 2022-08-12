package com.your.choice.brigadeservice.model.request;

import com.your.choice.brigadeservice.entity.ShiftType;
import com.your.choice.brigadeservice.entity.WorkerEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class CreateShiftRequest {
    private ShiftType shiftType;
    private WorkerEntity head;
    private WorkerEntity duty;
    private List<WorkerEntity> workers;
}
