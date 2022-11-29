package com.your.choice.finishedproductservise.service.serviceImpl;

import com.your.choice.finishedproductservise.entity.ProductType;
import com.your.choice.finishedproductservise.exeption.ProductTypeNotFoundException;
import com.your.choice.finishedproductservise.exeption.ShiftTypeNotFoundException;
import com.your.choice.finishedproductservise.model.request.ProductTypeRequest;
import com.your.choice.finishedproductservise.model.response.ProductTypeResponse;
import com.your.choice.finishedproductservise.repository.ProductTypeRepository;
import com.your.choice.finishedproductservise.service.ProductTypeService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    private ProductTypeRepository productTypeRepository;

    @Autowired
    public ProductTypeServiceImpl(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    @NotNull
    @Override
    @Transactional
    public ProductTypeResponse findProductTypeById(@NotNull Long id) {
        return productTypeRepository.findById(id)
                .map(this::buildProductTypeResponse)
                .orElseThrow(() -> new ProductTypeNotFoundException("ProductType " + id + " is not found"));
    }

    @NotNull
    @Override
    @Transactional
    public ProductTypeResponse findProductTypeByName(@NotNull String name) {
        return productTypeRepository.findAll()
                .stream().filter(s -> s.getName().equals(name))
                .map(this::buildProductTypeResponse)
                .findFirst()
                .orElseThrow(() -> new ShiftTypeNotFoundException("ProductType " + name + " is not found"));
    }

    @NotNull
    @Override
    @Transactional
    public List<ProductTypeResponse> findAllProductType() {
        return productTypeRepository.findAll()
                .stream()
                .map(this::buildProductTypeResponse)
                .collect(Collectors.toList());
    }

    @NotNull
    @Override
    @Transactional
    public ProductTypeResponse createProductType(@NotNull ProductTypeRequest request) {
        ProductType productType = buildProductType(request);
        return buildProductTypeResponse(productTypeRepository.save(productType));
    }

    @NotNull
    @Override
    @Transactional
    public ProductTypeResponse updateProductType(@NotNull Long id, @NotNull ProductTypeRequest request) {
        ProductType productType = productTypeRepository.findById(id)
                .orElseThrow(() -> new ShiftTypeNotFoundException("ProductType " + id + " is not found"));

        update(productType, request);

        return buildProductTypeResponse(productTypeRepository.save(productType));
    }

    @NotNull
    @Override
    @Transactional
    public void deleteProductType(@NotNull Long id) {
        productTypeRepository.deleteById(id);
    }

    private ProductTypeResponse buildProductTypeResponse(@NotNull ProductType productType) {
        return new ProductTypeResponse()
                .setId(productType.getId())
                .setName(productType.getName())
                .setBoxWeight(productType.getBoxWeight());
    }

    private ProductType buildProductType(@NotNull ProductTypeRequest request) {
        return new ProductType()
                .setId(request.getId())
                .setName(request.getName())
                .setBoxWeight(request.getBoxWeight());
    }

    private void update(@NotNull ProductType productType, @NotNull ProductTypeRequest request) {
        ofNullable(request.getName()).map(productType::setName);
        ofNullable(request.getBoxWeight()).map(productType::setBoxWeight);
    }
}
