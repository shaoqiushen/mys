package com.shanyuan.bgbirdportal.dto;

import com.shanyuan.model.PmsProductAttributeValue;
import lombok.Data;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-29 10:53
 * <p>
 * desc
 **/
@Data
public class PortalProductAttributeResult {
    private String name;
    private Integer id;
    private List<PmsProductAttributeValue> valueList;
}
