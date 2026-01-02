package com.StateModel.repository;

import com.StateModel.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictRepository extends JpaRepository<District, Long> {

    // delete all districts of a state
    void deleteByState_Id(Long stateId);

    // check duplicate code within same state
    boolean existsByState_IdAndCode(Long stateId, String code);
}
