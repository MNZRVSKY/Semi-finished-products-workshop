package com.your.choice.brigadeservice.service;

import com.your.choice.brigadeservice.model.request.CreateWorkerRequest;
import com.your.choice.brigadeservice.model.response.WorkerResponse;
import org.jetbrains.annotations.NotNull;

import java.util.List;


public interface WorkerService {
    @NotNull
    WorkerResponse findWorkerById(@NotNull String id);
    @NotNull
    List<WorkerResponse> findAllWorkers();
    @NotNull
    WorkerResponse createWorker(@NotNull CreateWorkerRequest request);
    @NotNull
    WorkerResponse updateWorker(@NotNull String id, @NotNull CreateWorkerRequest request);

    void deleteWorker(@NotNull String id);
}
