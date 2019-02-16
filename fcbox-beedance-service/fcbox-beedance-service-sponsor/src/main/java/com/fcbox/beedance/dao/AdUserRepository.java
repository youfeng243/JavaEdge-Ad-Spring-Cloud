package com.fcbox.beedance.dao;

import com.fcbox.beedance.entity.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author youfeng(002934)
 * @date 2019-02-15
 */
public interface AdUserRepository extends JpaRepository<AdUser, Long> {

    /**
     * 根据用户名查找用户记录
     *
     * @param username
     * @return
     */
    AdUser findByUsername(String username);


}
