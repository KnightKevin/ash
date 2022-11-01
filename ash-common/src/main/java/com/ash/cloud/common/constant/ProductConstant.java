package com.ash.cloud.common.constant;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ProductConstant {

    @AllArgsConstructor
    public enum AttrEnum {
        ATTR_TYPE_BASE(1, "基本属性"),
        ATTR_TYPE_SALE(0, "销售属性");
        private final int code;

        private final String msg;

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }

    }
}
