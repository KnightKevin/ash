package com.ash.cloud.modules.product.vo.spu;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Bounds {

    private BigDecimal buyBounds;
    private BigDecimal growBounds;
}