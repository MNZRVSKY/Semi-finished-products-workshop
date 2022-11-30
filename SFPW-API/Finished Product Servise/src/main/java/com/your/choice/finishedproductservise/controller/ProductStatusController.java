package com.your.choice.finishedproductservise.controller;

import com.your.choice.finishedproductservise.model.request.ProductStatusRequest;
import com.your.choice.finishedproductservise.model.response.ProductStatusResponse;
import com.your.choice.finishedproductservise.service.ProductStatusService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/productstatus")
public class ProductStatusController {

    private ProductStatusService productStatusService;

    @Autowired
    public ProductStatusController(ProductStatusService productStatusService) {
        this.productStatusService = productStatusService;
    }

    @Operation(summary = "Find product status by id")
    @GetMapping("/{id}")
    public ProductStatusResponse findProductStatusById(@PathVariable("id") Long id){
        return productStatusService.findProductStatusById(id);
    }

    @Operation(summary = "Find product status by name")
    @GetMapping("/findbyname/{name}")
    public ProductStatusResponse findProductStatusByStatus(@PathVariable("name") String name){
        return productStatusService.findProductStatusByStatus(name);
    }

    @Operation(summary = "Find all product status by name")
    @GetMapping("/all")
    public List<ProductStatusResponse> findAllProductStatus(){
        return productStatusService.findAllProductStatus();
    }

    @Operation(summary = "Create product status")
    @PostMapping("")
    public ProductStatusResponse createProductStatus(@RequestBody ProductStatusRequest request){
        return productStatusService.createProductStatus(request);
    }

    @Operation(summary = "Update product status")
    @PatchMapping("/{id}")
    ProductStatusResponse updateSProductStatus(@PathVariable("id") Long id, @RequestBody ProductStatusRequest request){
        return productStatusService.updateSProductStatus(id, request);
    }

    @Operation(summary = "Delete product status by if")
    @DeleteMapping("/{id}")
    public void deleteProductStatus(@PathVariable Long id){
         productStatusService.deleteProductStatus(id);
    }
}
