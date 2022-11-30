package com.your.choice.finishedproductservise.service.serviceImpl;

import com.your.choice.finishedproductservise.entity.ShiftType;
import com.your.choice.finishedproductservise.exeption.ShiftTypeNotFoundException;
import com.your.choice.finishedproductservise.model.request.ShiftTypeRequest;
import com.your.choice.finishedproductservise.model.response.ShiftTypeResponse;
import com.your.choice.finishedproductservise.repository.ShiftTypeRepository;
import com.your.choice.finishedproductservise.service.ShiftTypeService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Service
public class ShiftTypeServiceImpl implements ShiftTypeService {

    private ShiftTypeRepository shiftTypeRepository;

    @Autowired
    public ShiftTypeServiceImpl(ShiftTypeRepository shiftTypeRepository) {
        this.shiftTypeRepository = shiftTypeRepository;
    }

    @NotNull
    @Override
    @Transactional
    public ShiftTypeResponse findShiftTypeById(@NotNull Long id) {
        return shiftTypeRepository.findById(id)
                .map(this::buildShiftTypeResponse)
                .orElseThrow(() -> new ShiftTypeNotFoundException("ShiftType " + id + " is not found"));
    }

    @Override
    public @NotNull ShiftTypeResponse findShiftTypeByType(@NotNull String type) {
        return shiftTypeRepository.findAll()
                .stream().filter(s -> s.getType().equals(type))
                .map(this::buildShiftTypeResponse)
                .findFirst()
                .orElseThrow(() -> new ShiftTypeNotFoundException("ShiftType " + type + " is not found"));
    }

    @NotNull
    @Override
    @Transactional
    public List<ShiftTypeResponse> findAllShiftTypes() {
        return shiftTypeRepository.findAll()
                .stream()
                .map(this::buildShiftTypeResponse)
                .collect(Collectors.toList());
    }

    @NotNull
    @Override
    @Transactional
    public  ShiftTypeResponse createShiftType(@NotNull ShiftTypeRequest request) {
        ShiftType shiftType = buildShiftType(request);
        return buildShiftTypeResponse(shiftTypeRepository.save(shiftType));
    }

    @NotNull
    @Override
    @Transactional
    public  ShiftTypeResponse updateShiftType(@NotNull Long id, @NotNull ShiftTypeRequest request) {
        ShiftType shiftType = shiftTypeRepository.findById(request.getId())
                .orElseThrow(() -> new ShiftTypeNotFoundException("ShiftType " + request.getId() + " is not found"));

        update(shiftType, request);

        return buildShiftTypeResponse(shiftTypeRepository.save(shiftType));
    }

    @NotNull
    @Override
    @Transactional
    public void deleteShiftType(@NotNull Long id) {
        shiftTypeRepository.deleteById(id);
    }

    @NotNull
    private ShiftTypeResponse buildShiftTypeResponse(@NotNull ShiftType shiftType) {
        return new ShiftTypeResponse()
                .setId(shiftType.getId())
                .setType(shiftType.getType());
    }

    @NotNull
    private ShiftType buildShiftType(@NotNull ShiftTypeRequest request) {
        return new ShiftType()
                .setId(request.getId())
                .setType(request.getType());
    }

    private void update(@NotNull ShiftType shiftType, @NotNull ShiftTypeRequest request) {
        ofNullable(request.getType()).map(shiftType::setType);
    }
}
