package com.zoucai.zucai.util;

import java.util.Date;

public class test {

    public static void main(String[] args) {
        String strIdCardNo = "131124199002091610";
        System.out.println(strIdCardNo.replace(strIdCardNo.substring(14,18), "****"));
    }
}
