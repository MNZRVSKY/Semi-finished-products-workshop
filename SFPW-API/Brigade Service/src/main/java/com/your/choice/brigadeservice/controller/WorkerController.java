package com.your.choice.brigadeservice.controller;

import com.your.choice.brigadeservice.model.request.CreateWorkerRequest;
import com.your.choice.brigadeservice.model.response.WorkerResponse;
import com.your.choice.brigadeservice.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/worker")
public class WorkerController {
    private WorkerService workerService;

    @Autowired
    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @PostMapping("")
    public WorkerResponse createWorker(@RequestBody CreateWorkerRequest request) {
        return workerService.createWorker(request);
    }

    @GetMapping("/{id}")
    public WorkerResponse findWorkerById(@PathVariable("id") String id) {
        return workerService.findWorkerById(id);
    }

    @GetMapping("/all")
    public List<WorkerResponse> findAllWorkers() {
        return workerService.findAllWorkers();
    }

    @PatchMapping("/{id}")
    public WorkerResponse updateWorker(@PathVariable("id") String id, @RequestBody CreateWorkerRequest request) {
        return workerService.updateWorker(id, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteWorker(@PathVariable("id") String id) {
        workerService.deleteWorker(id);
    }
}
