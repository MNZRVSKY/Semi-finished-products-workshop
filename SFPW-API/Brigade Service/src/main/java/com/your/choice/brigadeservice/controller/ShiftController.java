package com.your.choice.brigadeservice.controller;

import com.your.choice.brigadeservice.model.request.CreateShiftRequest;
import com.your.choice.brigadeservice.model.response.ShiftResponse;
import com.your.choice.brigadeservice.service.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/shift")
public class ShiftController {

    private ShiftService shiftService;

    @Autowired
    public ShiftController(ShiftService shiftService) {
        this.shiftService = shiftService;
    }

    @PostMapping("")
    public ShiftResponse createShift(@RequestBody CreateShiftRequest request) {
        return shiftService.createShift(request);
    }

    @GetMapping("/{id}")
    public ShiftResponse findShiftById(@PathVariable("id") String id) {
        return shiftService.findShiftById(id);
    }

    @GetMapping("/all")
    public List<ShiftResponse> findAllShift() {
        return shiftService.findAllShift();
    }

    @PatchMapping("/{id}")
    public ShiftResponse updateShift(@PathVariable("id") String id, @RequestBody CreateShiftRequest request) {
        return shiftService.updateShift(id, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteShift(@PathVariable("id") String id) {
        shiftService.deleteShift(id);
    }

}
