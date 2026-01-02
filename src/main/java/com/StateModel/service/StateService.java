package com.StateModel.service;

import com.StateModel.entity.State;
import com.StateModel.repository.DistrictRepository;
import com.StateModel.repository.StateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    private final StateRepository stateRepository;
    private final DistrictRepository districtRepository;

    // ✅ ONLY ONE constructor (Spring will autowire this)
    public StateService(StateRepository stateRepository,
                        DistrictRepository districtRepository) {
        this.stateRepository = stateRepository;
        this.districtRepository = districtRepository;
    }

    // Save single state
    public State save(State state) {
        return stateRepository.save(state);
    }

    // Save multiple states
    public List<State> saveAll(List<State> states) {
        return stateRepository.saveAll(states);
    }

    // Get all states
    public List<State> getAll() {
        return stateRepository.findAll();
    }

    // Get state by id
    public State getById(Long id) {
        return stateRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("State not found with id : " + id));
    }

    // Delete state safely
    public void deleteById(Long id) {
        // delete districts first (FK safety)
        districtRepository.deleteByState_Id(id);

        // then delete state
        stateRepository.deleteById(id);
    }
}
