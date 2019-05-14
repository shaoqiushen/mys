package com.shanyuan.bgbirdadmin.dto;

import com.shanyuan.model.PmsProductExchange;
import lombok.Data;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-09 16:41
 * <p>
 * desc
 **/
@Data
public class PmsProductExchangeResult {
    private List<PmsProductExchange> boomList;
    private List<PmsProductExchange> allPointsList;
    private List<PmsProductExchange> pointCashList;
}
