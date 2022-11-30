package com.your.choice.finishedproductservise.controller;

import com.your.choice.finishedproductservise.model.request.FinishedProductsRequest;
import com.your.choice.finishedproductservise.model.response.FinishedProductsResponse;
import com.your.choice.finishedproductservise.service.FinishedProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/finishedproducts")
public class FinishedProductsController {

    private FinishedProductService finishedProductService;

    @Autowired
    public FinishedProductsController(FinishedProductService finishedProductService) {
        this.finishedProductService = finishedProductService;
    }

    @Operation(summary = "Find finished product by id")
    @GetMapping("/{id}")
    public FinishedProductsResponse findFinishedProductsById(@NotNull Long id){
        return finishedProductService.findFinishedProductsById(id);
    }

    @Operation(summary = "Find all finished product")
    @GetMapping("/all")
    public List<FinishedProductsResponse> findAllFinishedProducts(){
        return finishedProductService.findAllFinishedProducts();
    }

    @Operation(summary = "Create finished product")
    @PostMapping("")
    public FinishedProductsResponse createFinishedProducts(@NotNull FinishedProductsRequest request){
        return finishedProductService.createFinishedProducts(request);
    }

    @Operation(summary = "Update finished product by id")
    @PatchMapping("/{id}")
    public FinishedProductsResponse updateFinishedProducts(@NotNull Long id, @NotNull FinishedProductsRequest request){
        return finishedProductService.updateFinishedProducts(id, request);
    }

    @Operation(summary = "Delete finished product by id")
    @DeleteMapping("/{id}")
    public void deleteFinishedProducts(@NotNull Long id){
        finishedProductService.deleteFinishedProducts(id);
    }
}
