package com.your.choice.finishedproductservise.service;

import com.your.choice.finishedproductservise.model.request.ProductTypeRequest;
import com.your.choice.finishedproductservise.model.response.ProductTypeResponse;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ProductTypeService {

    @NotNull ProductTypeResponse findProductTypeById(@NotNull Long id);

    @NotNull
    ProductTypeResponse findProductTypeByName(@NotNull String name);

    @NotNull
    List<ProductTypeResponse> findAllProductType();

    @NotNull
    ProductTypeResponse createProductType(@NotNull ProductTypeRequest request);

    @NotNull
    ProductTypeResponse updateProductType(@NotNull Long id, @NotNull ProductTypeRequest request);

    @NotNull
    void deleteProductType(@NotNull Long id);

}
