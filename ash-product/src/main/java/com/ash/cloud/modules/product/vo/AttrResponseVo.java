package com.ash.cloud.modules.product.vo;

import lombok.Data;

@Data
public class AttrResponseVo extends AttrVo{

    private String groupName;

    private String catelogName;

    private Long[] catelogPath;
}
