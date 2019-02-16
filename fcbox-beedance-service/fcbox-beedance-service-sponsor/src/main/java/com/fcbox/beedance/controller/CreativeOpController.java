package com.fcbox.beedance.controller;

import com.alibaba.fastjson.JSON;
import com.fcbox.beedance.service.ICreativeService;
import com.fcbox.beedance.vo.CreativeRequest;
import com.fcbox.beedance.vo.CreativeResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author youfeng(002934)
 * @date 2019-02-11
 */
@Slf4j
@RestController
public class CreativeOpController {

    private final ICreativeService creativeService;

    @Autowired
    public CreativeOpController(ICreativeService creativeService) {
        this.creativeService = creativeService;
    }

    @PostMapping("/create/creative")
    public CreativeResponse createCreative(@RequestBody CreativeRequest request) {
        log.info("ad-sponsor: createCreative -> {}", JSON.toJSONString(request));
        return creativeService.createCreative(request);
    }
}

