package com.fcbox.beedance.controller;

import com.alibaba.fastjson.JSON;
import com.fcbox.beedance.entity.AdPlan;
import com.fcbox.beedance.exception.AdException;
import com.fcbox.beedance.service.IAdPlanService;
import com.fcbox.beedance.vo.AdPlanGetRequest;
import com.fcbox.beedance.vo.AdPlanRequest;
import com.fcbox.beedance.vo.AdPlanResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author youfeng(002934)
 * @date 2019-02-11
 */
@Slf4j
@RestController
public class AdPlanOpController {

    private final IAdPlanService adPlanService;

    @Autowired
    public AdPlanOpController(IAdPlanService adPlanService) {
        this.adPlanService = adPlanService;
    }

    @PostMapping("/create/adPlan")
    public AdPlanResponse createAdPlan(@RequestBody AdPlanRequest request) throws AdException {
        log.info("ad-sponsor: createAdPlan -> {}", JSON.toJSONString(request));
        return adPlanService.createAdPlan(request);
    }

    @PostMapping("/get/adPlan")
    public List<AdPlan> getAdPlanByIds(@RequestBody AdPlanGetRequest request) throws AdException {
        log.info("ad-sponsor: getAdPlanByIds -> {}", JSON.toJSONString(request));
        return adPlanService.getAdPlanByIds(request);
    }

    @PutMapping("/update/adPlan")
    public AdPlanResponse updateAdPlan(@RequestBody AdPlanRequest request) throws AdException {
        log.info("ad-sponsor: updateAdPlan -> {}", JSON.toJSONString(request));
        return adPlanService.updateAdPlan(request);
    }

    @DeleteMapping("/delete/adPlan")
    public void deleteAdPlan(@RequestBody AdPlanRequest request) throws AdException {
        log.info("ad-sponsor: deleteAdPlan -> {}", JSON.toJSONString(request));
        adPlanService.deleteAdPlan(request);
    }
}

