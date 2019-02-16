package com.fcbox.beedance.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 返回给广告主的响应
 *
 * @author youfeng(002934)
 * @date 2019-02-15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserResponse {

    private Long userId;

    private String username;

    private String token;

    private Date createTime;

    private Date updateTime;

}
