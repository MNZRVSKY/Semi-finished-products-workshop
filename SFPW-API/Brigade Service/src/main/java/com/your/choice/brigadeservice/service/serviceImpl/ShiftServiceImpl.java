package com.your.choice.brigadeservice.service.serviceImpl;

import com.your.choice.brigadeservice.entity.ShiftEntity;
import com.your.choice.brigadeservice.exception.ShiftNotFoundException;
import com.your.choice.brigadeservice.model.request.CreateShiftRequest;
import com.your.choice.brigadeservice.model.response.ShiftResponse;
import com.your.choice.brigadeservice.repository.ShiftRepository;
import com.your.choice.brigadeservice.service.ShiftService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Service
public class ShiftServiceImpl implements ShiftService {

    private ShiftRepository shiftRepository;

    @Autowired
    public ShiftServiceImpl(ShiftRepository shiftRepository) {
        this.shiftRepository = shiftRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public @NotNull ShiftResponse findShiftById(@NotNull String id) {
        return shiftRepository.findById(id)
                .map(this::buildShiftResponse)
                .orElseThrow(() -> new ShiftNotFoundException("Shift " + id + " is not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public @NotNull List<ShiftResponse> findAllShift() {
        return shiftRepository.findAll()
                .stream()
                .map(this::buildShiftResponse)
                .collect(Collectors.toList());
    }

    @Override
    public @NotNull ShiftResponse createShift(@NotNull CreateShiftRequest request) {
        ShiftEntity shift = buildShiftEntity(request);
        return buildShiftResponse(shiftRepository.save(shift));
    }

    @Override
    public @NotNull ShiftResponse updateShift(@NotNull String id, @NotNull CreateShiftRequest request) {
        ShiftEntity shift = shiftRepository.findById(id)
                .orElseThrow(() -> new ShiftNotFoundException("Shift " + id + " is not found"));
        update(shift, request);

        return buildShiftResponse(shiftRepository.save(shift));
    }

    @Override
    public void deleteShift(@NotNull String id) {
        shiftRepository.deleteById(id);
    }

    @NotNull
    private ShiftResponse buildShiftResponse(@NotNull ShiftEntity shift) {
        return new ShiftResponse()
                .setId(shift.getId())
                .setShiftType(shift.getShiftType())
                .setHead(shift.getHead())
                .setDuty(shift.getDuty())
                .setWorkers(shift.getWorkers());
    }

    @NotNull
    private ShiftEntity buildShiftEntity(@NotNull CreateShiftRequest request) {
        return new ShiftEntity()
                .setShiftType(request.getShiftType())
                .setHead(request.getHead())
                .setDuty(request.getDuty())
                .setWorkers(request.getWorkers());
    }

    private void update(@NotNull ShiftEntity shift, @NotNull CreateShiftRequest request) {
        ofNullable(request.getShiftType()).map(shift::setShiftType);
        ofNullable(request.getHead()).map(shift::setHead);
        ofNullable(request.getDuty()).map(shift::setDuty);
        ofNullable(request.getWorkers()).map(shift::setWorkers);
    }
}
