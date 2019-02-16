package com.fcbox.beedance.constant;

/**
 * @author youfeng(002934)
 * @date 2019-02-15
 */
public enum CreativeMaterialType {

    JPG(1, "jpg"),
    BMP(2, "bmp"),

    MP4(3, "mp4"),
    AVI(4, "avi"),

    TXY(5, "txt");


    private int type;
    private String desc;

    CreativeMaterialType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}

