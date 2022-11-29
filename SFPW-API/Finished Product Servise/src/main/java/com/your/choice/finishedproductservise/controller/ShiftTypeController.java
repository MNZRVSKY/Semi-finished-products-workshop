package com.your.choice.finishedproductservise.controller;

import com.your.choice.finishedproductservise.model.request.ShiftTypeRequest;
import com.your.choice.finishedproductservise.model.response.ShiftTypeResponse;
import com.your.choice.finishedproductservise.service.ShiftTypeService;
import io.swagger.v3.oas.annotations.Operation;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/shifttype")
public class ShiftTypeController {

    private ShiftTypeService shiftTypeService;


    @Autowired
    public ShiftTypeController(ShiftTypeService shiftTypeService) {
        this.shiftTypeService = shiftTypeService;
    }

    @Operation(summary = "Find shift type by id")
    @GetMapping("/{id}")
    public ShiftTypeResponse findShiftTypeById(@PathVariable Long id){
        return shiftTypeService.findShiftTypeById(id);
    }

    @Operation(summary = "Find shift type by type")
    @GetMapping("/findbytype/{type}")
    public ShiftTypeResponse findShiftTypeByType(@NotNull String type){
        return shiftTypeService.findShiftTypeByType(type);
    }

    @Operation(summary = "Find all shift type")
    @GetMapping("/all")
    public List<ShiftTypeResponse> findAllShiftTypes(){
        return shiftTypeService.findAllShiftTypes();
    }

    @Operation(summary = "Create shift type")
    @PostMapping("")
    public ShiftTypeResponse createShiftType(@RequestBody ShiftTypeRequest request){
        return shiftTypeService.createShiftType(request);
    }

    @Operation(summary = "Update shift type")
    @PatchMapping("/{id}")
    public ShiftTypeResponse updateShiftType(@PathVariable("id") Long id, @RequestBody ShiftTypeRequest request){
        return shiftTypeService.updateShiftType(id, request);
    }

    @Operation(summary = "Delete shift type by id")
    @DeleteMapping("/{id}")
    public void deleteShiftType(@NotNull Long id){
        shiftTypeService.deleteShiftType(id);
    }
}
