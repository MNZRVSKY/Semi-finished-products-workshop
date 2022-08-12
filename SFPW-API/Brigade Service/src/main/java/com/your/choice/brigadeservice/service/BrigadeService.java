package com.your.choice.brigadeservice.service;

import com.your.choice.brigadeservice.model.request.CreateBrigadeRequest;
import com.your.choice.brigadeservice.model.response.BrigadeResponse;
import org.jetbrains.annotations.NotNull;

import java.util.List;


public interface BrigadeService {

    @NotNull
    BrigadeResponse findBrigadeById(@NotNull String id);

    @NotNull
    List<BrigadeResponse> findAllBrigades();
    
    @NotNull
    BrigadeResponse createBrigade(@NotNull CreateBrigadeRequest request);

    @NotNull
    BrigadeResponse updateBrigade(@NotNull String id, @NotNull CreateBrigadeRequest request);

    void deleteBrigade(@NotNull String id);
}
