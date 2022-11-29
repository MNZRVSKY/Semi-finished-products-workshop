package com.your.choice.finishedproductservise.controller;

import com.your.choice.finishedproductservise.model.request.ProductTypeRequest;
import com.your.choice.finishedproductservise.model.response.ProductTypeResponse;
import com.your.choice.finishedproductservise.service.ProductTypeService;
import io.swagger.v3.oas.annotations.Operation;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/productstype")
public class ProductTypeController {

    private ProductTypeService productTypeService;

    @Autowired
    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @Operation(summary = "Create ProductType")
    @PostMapping("")
    public ProductTypeResponse createProductType(@RequestBody ProductTypeRequest request) {
        return productTypeService.createProductType(request);
    }

    @Operation(summary = "Find product by id")
    @GetMapping("/{id}")
    ProductTypeResponse findProductTypeById(@PathVariable("id") Long id){
        return productTypeService.findProductTypeById(id);
    }

    @Operation(summary = "Find product by name")
    @GetMapping("/findbyname/{name}")
    public ProductTypeResponse findProductTypeByName(@PathVariable("name") String name){
        return productTypeService.findProductTypeByName(name);
    }

    @Operation(summary = "Find all products")
    @GetMapping("/all")
    public List<ProductTypeResponse> findAllProductType() {
        return productTypeService.findAllProductType();
    }

    @Operation(summary = "Update product by id")
    @PatchMapping("/{id}")
    ProductTypeResponse updateProductType(@PathVariable("id") Long id, @RequestBody ProductTypeRequest request){
        return productTypeService.updateProductType(id, request);
    }

    @Operation(summary = "Update product by id")
    @DeleteMapping("/{id}")
    void deleteProductType(@NotNull Long id){
        productTypeService.deleteProductType(id);
    }
}
