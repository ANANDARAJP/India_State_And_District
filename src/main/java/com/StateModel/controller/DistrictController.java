package com.StateModel.controller;

import com.StateModel.entity.District;
import com.StateModel.service.DistrictService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/districts")
public class DistrictController {

    private final DistrictService districtService;

    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }

    // ================= CREATE =================

    // 🔹 Bulk save districts
    @PostMapping
    public List<District> saveAll(@RequestBody List<District> districts) {
        return districtService.saveAll(districts);
    }

    // ================= READ =================

    // 🔹 Get all districts
    @GetMapping
    public List<District> getAll() {
        return districtService.getAll();
    }

    // ================= DELETE =================

    // 🔹 Delete district by id
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        districtService.deleteById(id);
    }

    // 🔹 Delete all districts by stateId
    @DeleteMapping("/state/{stateId}")
    public void deleteByStateId(@PathVariable Long stateId) {
        districtService.deleteByStateId(stateId);
    }
}
