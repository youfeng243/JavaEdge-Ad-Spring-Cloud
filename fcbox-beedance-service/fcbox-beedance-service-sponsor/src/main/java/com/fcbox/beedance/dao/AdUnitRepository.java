package com.fcbox.beedance.dao;

import com.fcbox.beedance.entity.unitcondition.AdUnit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author youfeng(002934)
 * @date 2019/2/4
 */
public interface AdUnitRepository extends JpaRepository<AdUnit, Long> {

    /**
     * @param planId
     * @param unitName
     * @return
     */
    AdUnit findByPlanIdAndUnitName(Long planId, String unitName);

    /**
     * @param unitStatus
     * @return
     */
    List<AdUnit> findAllByUnitStatus(Integer unitStatus);
}

