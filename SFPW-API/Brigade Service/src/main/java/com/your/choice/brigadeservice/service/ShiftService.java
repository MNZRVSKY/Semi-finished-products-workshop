package com.your.choice.brigadeservice.service;

import com.your.choice.brigadeservice.model.request.CreateShiftRequest;
import com.your.choice.brigadeservice.model.response.ShiftResponse;
import org.jetbrains.annotations.NotNull;

import java.util.List;


public interface ShiftService {

    @NotNull
    ShiftResponse findShiftById(@NotNull String id);

    @NotNull
    List<ShiftResponse> findAllShift();

    @NotNull
    ShiftResponse createShift(@NotNull CreateShiftRequest shift);

    @NotNull
    ShiftResponse updateShift(@NotNull String id, @NotNull CreateShiftRequest shift);

    public void deleteShift(@NotNull String id);
}
