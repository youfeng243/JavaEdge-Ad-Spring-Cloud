package com.fcbox.beedance.service.impl;

import com.fcbox.beedance.dao.AdUserRepository;
import com.fcbox.beedance.exception.AdException;
import com.fcbox.beedance.utils.CommonUtils;
import com.fcbox.beedance.vo.CreateUserRequest;
import com.fcbox.beedance.vo.CreateUserResponse;
import com.fcbox.beedance.constant.Constants;
import com.fcbox.beedance.entity.AdUser;
import com.fcbox.beedance.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author youfeng(002934)
 * @date 2019-02-15
 */
@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    private final AdUserRepository userRepository;

    @Autowired
    public UserServiceImpl(AdUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public CreateUserResponse createUser(CreateUserRequest request) throws AdException {
        //校验参数
        if (!request.validate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        //判断同名用户存在
        AdUser oldUser = userRepository.findByUsername(request.getUsername());
        if (oldUser != null) {
            throw new AdException(Constants.ErrorMsg.SAME_NAME_ERROR);
        }

        // 开始创建用户
        AdUser newUser = userRepository.save(new AdUser(request.getUsername(), CommonUtils.md5(request.getUsername())
        ));

        return new CreateUserResponse(newUser.getId(), newUser.getUsername(), newUser.getToken(), newUser.getCreateTime(), newUser.getUpdateTime());

    }

}

