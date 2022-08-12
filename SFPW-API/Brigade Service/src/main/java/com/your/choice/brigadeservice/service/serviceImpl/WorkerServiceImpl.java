package com.your.choice.brigadeservice.service.serviceImpl;

import com.your.choice.brigadeservice.model.request.CreateWorkerRequest;
import com.your.choice.brigadeservice.model.response.WorkerResponse;
import com.your.choice.brigadeservice.entity.WorkerEntity;
import com.your.choice.brigadeservice.exception.UserNotFoundExcetion;
import com.your.choice.brigadeservice.repository.WorkerRepository;
import com.your.choice.brigadeservice.service.WorkerService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Service
public class WorkerServiceImpl implements WorkerService {
    private WorkerRepository workerRepository;

    @Autowired
    public WorkerServiceImpl(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @NotNull
    @Override
    @Transactional(readOnly = true)
    public WorkerResponse findWorkerById(String id) {
        return workerRepository.findById(id)
                .map(this::buildWorkerResponse)
                .orElseThrow(() -> new UserNotFoundExcetion("Worker " + id + " is not found"));
    }
    @NotNull
    @Override
    @Transactional(readOnly = true)
    public List<WorkerResponse> findAllWorkers() {
        return workerRepository.findAll()
                .stream()
                .map(this::buildWorkerResponse)
                .collect(Collectors.toList());
    }

    @NotNull
    @Override
    @Transactional
    public WorkerResponse createWorker(@NotNull CreateWorkerRequest request) {
        WorkerEntity worker = buildWorkerEntity(request);
        return buildWorkerResponse(workerRepository.save(worker));
    }

    @NotNull
    @Override
    @Transactional
    public WorkerResponse updateWorker(@NotNull String id, @NotNull CreateWorkerRequest request) {
        WorkerEntity worker =  workerRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundExcetion("User " + id + " is not found"));
        update(worker, request);

        return buildWorkerResponse(workerRepository.save(worker));
    }

    @Override
    @Transactional
    public void deleteWorker(@NotNull String id) {
        workerRepository.deleteById(id);
    }

    @NotNull
    private WorkerResponse buildWorkerResponse(@NotNull WorkerEntity worker) {
        return new WorkerResponse()
                .setId(worker.getId())
                .setName(worker.getName())
                .setSurname(worker.getSurname());
    }

    @NotNull
    private WorkerEntity buildWorkerEntity(@NotNull CreateWorkerRequest request) {
        return new WorkerEntity()
                .setName(request.getName())
                .setSurname(request.getSurname());
    }

    private void update(@NotNull WorkerEntity worker, @NotNull CreateWorkerRequest request) {
        ofNullable(request.getName()).map(worker::setName);
        ofNullable(request.getSurname()).map(worker::setSurname);
    }
}
