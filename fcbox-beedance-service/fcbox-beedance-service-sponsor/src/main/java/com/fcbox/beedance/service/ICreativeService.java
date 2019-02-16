package com.fcbox.beedance.service;

import com.fcbox.beedance.vo.CreativeRequest;
import com.fcbox.beedance.vo.CreativeResponse;

/**
 * @author youfeng(002934)
 * @date 2019/2/9
 */
public interface ICreativeService {

    /**
     * 创建创意
     *
     * @param request
     * @return
     */
    CreativeResponse createCreative(CreativeRequest request);
}
