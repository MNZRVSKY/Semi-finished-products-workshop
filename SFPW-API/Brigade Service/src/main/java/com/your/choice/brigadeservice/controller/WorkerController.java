package com.your.choice.brigadeservice.controller;

import com.your.choice.brigadeservice.model.request.CreateWorkerRequest;
import com.your.choice.brigadeservice.model.response.WorkerResponse;
import com.your.choice.brigadeservice.service.WorkerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Create worker")
    @PostMapping("")
    public WorkerResponse createWorker(@RequestBody CreateWorkerRequest request) {
        return workerService.createWorker(request);
    }

    @Operation(summary = "Find worker by id")
    @GetMapping("/{id}")
    public WorkerResponse findWorkerById(@PathVariable("id") String id) {
        return workerService.findWorkerById(id);
    }

    @Operation(summary = "Find all workers")
    @GetMapping("/all")
    public List<WorkerResponse> findAllWorkers() {
        return workerService.findAllWorkers();
    }

    @Operation(summary = "Update worker by id")
    @PatchMapping("/{id}")
    public WorkerResponse updateWorker(@PathVariable("id") String id, @RequestBody CreateWorkerRequest request) {
        return workerService.updateWorker(id, request);
    }

    @Operation(summary = "Delete worker by id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteWorker(@PathVariable("id") String id) {
        workerService.deleteWorker(id);
    }
}
