package com.fcbox.beedance.service;

import com.fcbox.beedance.exception.AdException;
import com.fcbox.beedance.vo.CreateUserRequest;
import com.fcbox.beedance.vo.CreateUserResponse;

/**
 * @author youfeng(002934)
 * @date 2019/2/5
 */
public interface IUserService {

    /**
     * 创建用户
     *
     * @param request
     * @return
     * @throws AdException
     */
    CreateUserResponse createUser(CreateUserRequest request) throws AdException;


}
