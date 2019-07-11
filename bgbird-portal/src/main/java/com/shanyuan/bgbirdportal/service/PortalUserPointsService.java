package com.shanyuan.bgbirdportal.service;

import com.shanyuan.bgbirdportal.dto.PortalPointsResult;
import com.shanyuan.domain.CommonResult;
import com.shanyuan.model.UmsUserMember;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-09 17:55
 * <p>
 * desc
 **/
public interface PortalUserPointsService {
    UmsUserMember getUserPointsInfo(String userId);
    List<PortalPointsResult> getUserPointsRecord(String userId);

    //修改会员卡积分
    @Transactional
    CommonResult updateIntegration(String cardCode, int consumeMoney);
}
