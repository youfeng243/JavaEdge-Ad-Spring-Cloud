package com.fcbox.beedance.constant;

import lombok.Getter;

/**
 * @author youfeng(002934)
 * @date 2019-02-15
 */
@Getter
public enum CommonStatus {

    VALID(1, "有效状态"),
    INVALID(0, "无效状态");

    private Integer status;
    private String desc;

    CommonStatus(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }
}
