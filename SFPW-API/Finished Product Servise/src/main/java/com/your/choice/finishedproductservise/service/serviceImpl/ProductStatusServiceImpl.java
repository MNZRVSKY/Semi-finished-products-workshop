package com.your.choice.finishedproductservise.service.serviceImpl;

import com.your.choice.finishedproductservise.entity.ProductStatus;
import com.your.choice.finishedproductservise.exeption.ProductStatusNotFoundException;
import com.your.choice.finishedproductservise.model.request.ProductStatusRequest;
import com.your.choice.finishedproductservise.model.response.ProductStatusResponse;
import com.your.choice.finishedproductservise.repository.ProductStatusRepository;
import com.your.choice.finishedproductservise.service.ProductStatusService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Service
public class ProductStatusServiceImpl implements ProductStatusService {

    ProductStatusRepository productStatusRepository;

    @Autowired
    public ProductStatusServiceImpl(ProductStatusRepository productStatusRepository) {
        this.productStatusRepository = productStatusRepository;
    }

    @NotNull
    @Override
    @Transactional
    public ProductStatusResponse findProductStatusById(@NotNull Long id) {
        return productStatusRepository.findById(id)
                .map(this::buildProductStatusResponse)
                .orElseThrow(() -> new ProductStatusNotFoundException("ProductStatus " + id + " is not found"));
    }

    @NotNull
    @Override
    @Transactional
    public ProductStatusResponse findProductStatusByStatus(@NotNull String status) {
        return productStatusRepository.findAll()
                .stream().filter(s -> s.getStatus().equals(status))
                .map(this::buildProductStatusResponse)
                .findFirst()
                .orElseThrow(() -> new ProductStatusNotFoundException("ProductStatus " + status + " is not found"));
    }

    @NotNull
    @Override
    @Transactional
    public List<ProductStatusResponse> findAllProductStatus() {
        return productStatusRepository.findAll()
                .stream()
                .map(this::buildProductStatusResponse)
                .collect(Collectors.toList());
    }

    @NotNull
    @Override
    @Transactional
    public  ProductStatusResponse createProductStatus(@NotNull ProductStatusRequest request) {
        ProductStatus productStatus = buildProductStatus(request);
        return buildProductStatusResponse(productStatusRepository.save(productStatus));
    }

    @NotNull
    @Override
    @Transactional
    public ProductStatusResponse updateSProductStatus(@NotNull Long id, @NotNull ProductStatusRequest request) {
        ProductStatus productStatus = productStatusRepository.findById(id)
                .orElseThrow(() -> new ProductStatusNotFoundException("ProductStatus " + id + " is not found"));

        update(productStatus, request);

        return buildProductStatusResponse(productStatusRepository.save(productStatus));
    }

    @NotNull
    @Override
    @Transactional
    public void deleteProductStatus(@NotNull Long id) {
        productStatusRepository.deleteById(id);
    }

    @NotNull
    private ProductStatusResponse buildProductStatusResponse(@NotNull ProductStatus productStatus) {
        return new ProductStatusResponse()
                .setId(productStatus.getId())
                .setStatus(productStatus.getStatus());
    }

    @NotNull
    private ProductStatus buildProductStatus(@NotNull ProductStatusRequest request) {
        return new ProductStatus()
                .setId(request.getId())
                .setStatus(request.getStatus());
    }

    private void update(@NotNull ProductStatus productStatus, @NotNull ProductStatusRequest request) {
        ofNullable(request.getStatus()).map(productStatus::setStatus);
    }
}
