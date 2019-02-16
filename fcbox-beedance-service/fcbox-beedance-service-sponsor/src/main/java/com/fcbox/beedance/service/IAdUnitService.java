package com.fcbox.beedance.service;

import com.fcbox.beedance.exception.AdException;
import com.fcbox.beedance.vo.*;

/**
 * @author sss
 * @fun 推广单元接口
 * @date 2019/2/6
 */
public interface IAdUnitService {

    /**
     * @param request
     * @return
     * @throws AdException
     */
    AdUnitResponse createUnit(AdUnitRequest request) throws AdException;

    /**
     * @param request
     * @return
     * @throws AdException
     */
    AdUnitKeywordResponse createUnitKeyword(AdUnitKeywordRequest request)
            throws AdException;

    AdUnitItResponse createUnitIt(AdUnitItRequest request)
            throws AdException;

    AdUnitDistrictResponse createUnitDistrict(AdUnitDistrictRequest request)
            throws AdException;

    CreativeUnitResponse createCreativeUnit(CreativeUnitRequest request)
            throws AdException;

}