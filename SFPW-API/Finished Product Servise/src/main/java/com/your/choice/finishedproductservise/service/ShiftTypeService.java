package com.your.choice.finishedproductservise.service;

import com.your.choice.finishedproductservise.model.request.ShiftTypeRequest;
import com.your.choice.finishedproductservise.model.response.ShiftTypeResponse;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ShiftTypeService {
    @NotNull
    ShiftTypeResponse findShiftTypeById(@NotNull Long id);

    @NotNull
    ShiftTypeResponse findShiftTypeByType(@NotNull String type);

    @NotNull
    List<ShiftTypeResponse> findAllShiftTypes();

    @NotNull
    ShiftTypeResponse createShiftType(@NotNull ShiftTypeRequest request);

    @NotNull
    ShiftTypeResponse updateShiftType(@NotNull Long id, @NotNull ShiftTypeRequest request);

    @NotNull
    void deleteShiftType(@NotNull Long id);
}
