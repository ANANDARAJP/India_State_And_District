package com.StateModel.controller;

import com.StateModel.entity.State;
import com.StateModel.service.StateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateController {

    private final StateService stateService;

    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    // POST - single state
    @PostMapping
    public State saveState(@RequestBody State state) {
        return stateService.save(state);
    }

    // POST - bulk states
    @PostMapping("/bulk")
    public List<State> saveStates(@RequestBody List<State> states) {
        return stateService.saveAll(states);
    }

    // GET - all states
    @GetMapping
    public List<State> getAllStates() {
        return stateService.getAll();
    }

    // GET - by id
    @GetMapping("/{id}")
    public State getStateById(@PathVariable Long id) {
        return stateService.getById(id);
    }
//   delete by id
    @DeleteMapping("/{id}")
    public void deleteStateById(@PathVariable Long id) {
        stateService.deleteById(id);
    }
}
