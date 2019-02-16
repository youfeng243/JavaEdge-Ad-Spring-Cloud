package com.fcbox.beedance.client;

import com.fcbox.beedance.client.vo.AdPlan;
import com.fcbox.beedance.vo.CommonResponse;
import com.fcbox.beedance.client.vo.AdPlanGetRequest;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author youfeng(002934)
 * @date 2019-02-11
 */
@Component
public class SponsorClientHystrix implements SponsorClient {

    @Override
    public CommonResponse<List<AdPlan>> getAdPlans(AdPlanGetRequest request) {
        return new CommonResponse<>(-1, "fcbox-beedance-service-sponsor error");
    }
}
