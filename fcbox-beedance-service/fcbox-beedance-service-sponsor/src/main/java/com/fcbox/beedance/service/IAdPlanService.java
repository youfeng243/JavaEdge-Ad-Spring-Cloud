package com.fcbox.beedance.service;

import com.fcbox.beedance.exception.AdException;
import com.fcbox.beedance.vo.AdPlanGetRequest;
import com.fcbox.beedance.vo.AdPlanRequest;
import com.fcbox.beedance.vo.AdPlanResponse;
import com.fcbox.beedance.entity.AdPlan;

import java.util.List;

/**
 * @author youfeng(002934)
 * @fun 推广计划服务接口
 * @date 2019/2/6
 */
public interface IAdPlanService {

    /**
     * 创建推广计划
     *
     * @param request
     * @return
     * @throws AdException
     */
    AdPlanResponse createAdPlan(AdPlanRequest request) throws AdException;

    /**
     * 获取推广计划
     *
     * @param request
     * @return
     * @throws AdException
     */
    List<AdPlan> getAdPlanByIds(AdPlanGetRequest request) throws AdException;

    /**
     * 更新推广计划
     *
     * @param request
     * @return
     * @throws AdException
     */
    AdPlanResponse updateAdPlan(AdPlanRequest request) throws AdException;

    /**
     * 删除推广计划
     *
     * @param request
     * @throws AdException
     */
    void deleteAdPlan(AdPlanRequest request) throws AdException;

}
