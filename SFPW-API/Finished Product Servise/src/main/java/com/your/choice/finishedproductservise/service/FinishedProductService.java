package com.your.choice.finishedproductservise.service;

import com.your.choice.finishedproductservise.model.request.FinishedProductsRequest;
import com.your.choice.finishedproductservise.model.response.FinishedProductsResponse;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface FinishedProductService {
    @NotNull
    FinishedProductsResponse findFinishedProductsById(@NotNull Long id);

    @NotNull
    List<FinishedProductsResponse> findAllFinishedProducts();

    @NotNull
    FinishedProductsResponse createFinishedProducts(@NotNull FinishedProductsRequest request);

    @NotNull
    FinishedProductsResponse updateFinishedProducts(@NotNull Long id, @NotNull FinishedProductsRequest request);

    @NotNull
    void deleteFinishedProducts(@NotNull Long id);
}
