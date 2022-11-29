package com.your.choice.brigadeservice.service.serviceImpl;

import com.your.choice.brigadeservice.entity.BrigadeEntity;
import com.your.choice.brigadeservice.exception.BrigadeNotFoundException;
import com.your.choice.brigadeservice.model.request.CreateBrigadeRequest;
import com.your.choice.brigadeservice.model.response.BrigadeResponse;
import com.your.choice.brigadeservice.repository.BrigadeRepository;
import com.your.choice.brigadeservice.service.BrigadeService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Service
public class BrigadeServiceImpl implements BrigadeService {

    private BrigadeRepository brigadeRepository;

    @Autowired
    public BrigadeServiceImpl(BrigadeRepository brigadeRepository) {
        this.brigadeRepository = brigadeRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public @NotNull BrigadeResponse findBrigadeById(@NotNull String id) {
        return brigadeRepository.findById(id)
                .map(this::buildBrigadeResponse)
                .orElseThrow(() -> new BrigadeNotFoundException("Brigade " + id + " is not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public @NotNull List<BrigadeResponse> findAllBrigades() {
        return brigadeRepository.findAll()
                .stream()
                .map(this::buildBrigadeResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public @NotNull BrigadeResponse createBrigade(@NotNull CreateBrigadeRequest request) {
        BrigadeEntity brigade = buildBrigadeEntity(request);
        return buildBrigadeResponse(brigadeRepository.save(brigade));
    }

    @Override
    @Transactional
    public @NotNull BrigadeResponse updateBrigade(@NotNull String id, @NotNull CreateBrigadeRequest request) {

        BrigadeEntity brigade = brigadeRepository.findById(id)
                .orElseThrow(() -> new BrigadeNotFoundException("Brigade " + id + " is not found"));

        update(brigade, request);

        return buildBrigadeResponse(brigadeRepository.save(brigade));
    }

    @Override
    @Transactional
    public void deleteBrigade(@NotNull String id) {
        brigadeRepository.deleteById(id);
    }

    @NotNull
    private BrigadeResponse buildBrigadeResponse(@NotNull BrigadeEntity brigade) {
        return new BrigadeResponse()
                .setId(brigade.getId())
                .setHeadWorkerId(brigade.getHeadWorkerId());
    }

    @NotNull
    private BrigadeEntity buildBrigadeEntity(@NotNull CreateBrigadeRequest request) {
        return new BrigadeEntity()
                .setHeadWorkerId(request.getHeadWorkerId());
    }

    private void update(@NotNull BrigadeEntity brigade, @NotNull CreateBrigadeRequest request) {
        ofNullable(request.getHeadWorkerId()).map(brigade::setHeadWorkerId);
    }
}
