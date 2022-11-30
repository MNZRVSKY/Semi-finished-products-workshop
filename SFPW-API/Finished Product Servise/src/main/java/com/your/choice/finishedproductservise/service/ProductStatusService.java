package com.your.choice.finishedproductservise.service;

import com.your.choice.finishedproductservise.model.request.ProductStatusRequest;
import com.your.choice.finishedproductservise.model.response.ProductStatusResponse;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ProductStatusService {
    @NotNull
    ProductStatusResponse findProductStatusById(@NotNull Long id);

    @NotNull
    ProductStatusResponse findProductStatusByStatus(@NotNull String status);

    @NotNull
    List<ProductStatusResponse> findAllProductStatus();

    @NotNull
    ProductStatusResponse createProductStatus(@NotNull ProductStatusRequest request);

    @NotNull
    ProductStatusResponse updateSProductStatus(@NotNull Long id, @NotNull ProductStatusRequest request);

    @NotNull
    void deleteProductStatus(@NotNull Long id);
}
