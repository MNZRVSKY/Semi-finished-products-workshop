package com.your.choice.finishedproductservise.service.serviceImpl;

import com.your.choice.finishedproductservise.entity.FinishedProducts;
import com.your.choice.finishedproductservise.exeption.FinishedProductsNotFoundException;
import com.your.choice.finishedproductservise.model.request.FinishedProductsRequest;
import com.your.choice.finishedproductservise.model.response.FinishedProductsResponse;
import com.your.choice.finishedproductservise.repository.FinishedProductRepository;
import com.your.choice.finishedproductservise.service.FinishedProductService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Service
public class FinishedProductServiceImpl implements FinishedProductService {

    FinishedProductRepository finishedProductRepository;

    @Autowired
    public FinishedProductServiceImpl(FinishedProductRepository finishedProductRepository) {
        this.finishedProductRepository = finishedProductRepository;
    }

    @NotNull
    @Override
    @Transactional
    public FinishedProductsResponse findFinishedProductsById(@NotNull Long id) {
        return finishedProductRepository.findById(id)
                .map(this::buildFinishedProductsResponse)
                .orElseThrow(() -> new FinishedProductsNotFoundException("FinishedProducts " + id + " is not found"));
    }

    @NotNull
    @Override
    @Transactional
    public List<FinishedProductsResponse> findAllFinishedProducts() {
        return finishedProductRepository.findAll()
                .stream()
                .map(this::buildFinishedProductsResponse)
                .collect(Collectors.toList());
    }

    @NotNull
    @Override
    @Transactional
    public FinishedProductsResponse createFinishedProducts(@NotNull FinishedProductsRequest request) {
        FinishedProducts finishedProducts = buildFinishedProducts(request);
        return buildFinishedProductsResponse(finishedProductRepository.save(finishedProducts));
    }

    @NotNull
    @Override
    @Transactional
    public FinishedProductsResponse updateFinishedProducts(@NotNull Long id, @NotNull FinishedProductsRequest request) {
        FinishedProducts finishedProducts = finishedProductRepository.findById(id)
                .orElseThrow(() -> new FinishedProductsNotFoundException("ShiftType " + id + " is not found"));

        update(finishedProducts, request);

        return buildFinishedProductsResponse(finishedProductRepository.save(finishedProducts));
    }

    @Override
    @Transactional
    public void deleteFinishedProducts(@NotNull Long id) {
        finishedProductRepository.deleteById(id);
    }

    @NotNull
    private FinishedProductsResponse buildFinishedProductsResponse(@NotNull FinishedProducts finishedProducts) {
        return new FinishedProductsResponse()
                .setId(finishedProducts.getId());
    }

    @NotNull
    private FinishedProducts buildFinishedProducts(@NotNull FinishedProductsRequest request) {
        return new FinishedProducts()
                .setId(request.getId())
                //.setShiftType(request.getShiftType())
                //.setProductType(request.getProductType())
                //.setProductStatus(request.getProductStatus())
                .setBrigadeNumber(request.getBrigadeNumber())
                .setDate(request.getDate());
    }

    private void update(@NotNull FinishedProducts finishedProducts, @NotNull FinishedProductsRequest request) {
        //ofNullable(request.getShiftType()).map(finishedProducts::setShiftType);
        //ofNullable(request.getProductType()).map(finishedProducts::setProductType);
        //ofNullable(request.getProductStatus()).map(finishedProducts::setProductStatus);
        ofNullable(request.getBrigadeNumber()).map(finishedProducts::setBrigadeNumber);
        ofNullable(request.getDate()).map(finishedProducts::setDate);
    }
}
