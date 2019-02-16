package com.fcbox.beedance.constant;

/**
 * @author youfeng(002934)
 * @date 2019-02-15
 */
public enum CreativeType {

    IMAGE(1, "图片"),
    VIDEO(2, "视频"),
    TEXT(3, "文本");

    private int type;
    private String desc;

    CreativeType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
