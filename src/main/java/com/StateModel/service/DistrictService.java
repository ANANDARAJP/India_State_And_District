package com.StateModel.service;

import com.StateModel.entity.District;
import com.StateModel.repository.DistrictRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {

    private final DistrictRepository districtRepository;

    public DistrictService(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    // ✅ Save all districts with state-wise unique code check
    public List<District> saveAll(List<District> districts) {

        for (District district : districts) {

            Long stateId = district.getState().getId();
            String code = district.getCode();

            if (districtRepository.existsByState_IdAndCode(stateId, code)) {
                throw new RuntimeException(
                        "Duplicate district code '" + code +
                                "' for stateId " + stateId
                );
            }
        }

        return districtRepository.saveAll(districts);
    }

    // ✅ Get all districts
    public List<District> getAll() {
        return districtRepository.findAll();
    }

    // ✅ Delete district by id
    public void deleteById(Long id) {
        districtRepository.deleteById(id);
    }

    // ✅ Delete all districts by stateId
    public void deleteByStateId(Long stateId) {
        districtRepository.deleteByState_Id(stateId);
    }
}


