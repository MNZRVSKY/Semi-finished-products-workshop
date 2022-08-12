package com.your.choice.brigadeservice.controller;

import com.your.choice.brigadeservice.model.request.CreateBrigadeRequest;
import com.your.choice.brigadeservice.model.response.BrigadeResponse;
import com.your.choice.brigadeservice.service.BrigadeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/brigade")
public class BrigadeController {

    private BrigadeService brigadeService;

    @Autowired
    public BrigadeController(BrigadeService brigadeService) {
        this.brigadeService = brigadeService;
    }

    @Operation(summary = "Create brigade")
    @PostMapping("")
    public BrigadeResponse createBrigade(@RequestBody CreateBrigadeRequest request) {
        return brigadeService.createBrigade(request);
    }

    @Operation(summary = "Find brigade by id")
    @GetMapping("/{id}")
    public BrigadeResponse findBrigadeById(@PathVariable("id") String id) {
        return brigadeService.findBrigadeById(id);
    }

    @Operation(summary = "Create all brigades")
    @GetMapping("/all")
    public List<BrigadeResponse> findAllBrigades() {
        return brigadeService.findAllBrigades();
    }

    @Operation(summary = "Update brigade")
    @PatchMapping("/{id}")
    public BrigadeResponse updateBrigade(@PathVariable("id") String id, @RequestBody CreateBrigadeRequest request) {
        return brigadeService.updateBrigade(id, request);
    }

    @Operation(summary = "Delete brigade")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteBrigade(@PathVariable("id") String id) {
        brigadeService.deleteBrigade(id);
    }

}
