package com.javaedge.ad.service;

import com.javaedge.ad.vo.CreativeRequest;
import com.javaedge.ad.vo.CreativeResponse;

/**
 * @author sss
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
