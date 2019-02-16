package com.fcbox.beedance.service.impl;

import com.fcbox.beedance.dao.AdPlanRepository;
import com.fcbox.beedance.dao.AdUserRepository;
import com.fcbox.beedance.exception.AdException;
import com.fcbox.beedance.utils.CommonUtils;
import com.fcbox.beedance.vo.AdPlanGetRequest;
import com.fcbox.beedance.vo.AdPlanRequest;
import com.fcbox.beedance.vo.AdPlanResponse;
import com.fcbox.beedance.constant.CommonStatus;
import com.fcbox.beedance.constant.Constants;
import com.fcbox.beedance.entity.AdPlan;
import com.fcbox.beedance.entity.AdUser;
import com.fcbox.beedance.service.IAdPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author youfeng(002934)
 * @fun 推广计划服务接口
 * @date 2019-02-15
 */
@Service
public class AdPlanServiceImpl implements IAdPlanService {

    private final AdUserRepository userRepository;

    private final AdPlanRepository planRepository;

    @Autowired
    public AdPlanServiceImpl(AdUserRepository userRepository, AdPlanRepository planRepository) {
        this.userRepository = userRepository;
        this.planRepository = planRepository;
    }

    /**
     * 创建推广计划
     *
     * @param request
     * @return
     * @throws AdException
     */
    @Override
    @Transactional
    public AdPlanResponse createAdPlan(AdPlanRequest request) throws AdException {
        if (!request.createValidate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        //确保关联的 User 是否存在
        Optional<AdUser> adUser = userRepository.findById(request.getUserId());

        if (!adUser.isPresent()) {
            throw new AdException(Constants.ErrorMsg.RECORD_NOT_FOUND);
        }

        AdPlan oldPlan = planRepository.findByUserIdaAndPlanName(
                request.getUserId(), request.getPlanName()
        );
        if (oldPlan != null) {
            throw new AdException(Constants.ErrorMsg.SAME_NAME__PLAN_ERROR);
        }
        AdPlan newAdPlan = planRepository.save(
                new AdPlan(
                        request.getUserId(),
                        request.getPlanName(),
                        CommonUtils.parseStringDate(request.getStartDate()),
                        CommonUtils.parseStringDate(request.getEndDate())
                )
        );

        return new AdPlanResponse(newAdPlan.getId(),
                newAdPlan.getPlanName());
    }

    /**
     * 获取推广计划
     *
     * @param request
     * @return
     * @throws AdException
     */
    @Override
    public List<AdPlan> getAdPlanByIds(AdPlanGetRequest request) throws AdException {
        if (!request.validate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        return planRepository.findAllByIdInAnAndUserId(
                request.getIds(), request.getUserId()
        );
    }

    /**
     * 更新推广计划
     *
     * @param request
     * @return
     * @throws AdException
     */
    @Override
    @Transactional
    public AdPlanResponse updateAdPlan(AdPlanRequest request) throws AdException {
        if (!request.updateValidate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);

        }

        AdPlan plan = planRepository.findByIdAndUserId(
                request.getId(), request.getUserId()
        );

        if (request.getPlanName() != null) {
            plan.setPlanName(request.getPlanName());
        }

        if (request.getStartDate() != null) {
            plan.setStartDate(CommonUtils.parseStringDate(request.getStartDate()));
        }

        if (request.getEndDate() != null) {
            plan.setEndDate(CommonUtils.parseStringDate(request.getEndDate()));
        }

        plan.setUpdateTime(new Date());
        plan = planRepository.save(plan);

        return new AdPlanResponse(plan.getId(), plan.getPlanName());
    }

    /**
     * 删除推广计划
     *
     * @param request
     * @throws AdException
     */
    @Override
    @Transactional
    public void deleteAdPlan(AdPlanRequest request) throws AdException {
        if (!request.deleteValidate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        AdPlan plan = planRepository.findByIdAndUserId(request.getId(), request.getUserId());
        if (plan == null) {
            throw new AdException(Constants.ErrorMsg.RECORD_NOT_FOUND);
        }

        plan.setPlanStatus(CommonStatus.INVALID.getStatus());
        plan.setUpdateTime(new Date());
        planRepository.save(plan);

    }

}
