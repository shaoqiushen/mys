package com.shanyuan.bgbirdportal.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.shanyuan.bgbirdportal.domain.HttpRequestResponse;
import com.shanyuan.bgbirdportal.domain.IntegrationDto;
import com.shanyuan.bgbirdportal.dto.PortalPointsResult;
import com.shanyuan.bgbirdportal.service.PortalUserPointsService;
import com.shanyuan.domain.CommonResult;
import com.shanyuan.mapper.UmsUserMemberMapper;
import com.shanyuan.mapper.UmsUserPointsRecordMapper;
import com.shanyuan.model.UmsUserMember;
import com.shanyuan.model.UmsUserMemberExample;
import com.shanyuan.model.UmsUserPointsRecord;
import com.shanyuan.model.UmsUserPointsRecordExample;
import com.shanyuan.utils.HttpUtils;
import com.shanyuan.utils.MathUtils;
import com.shanyuan.utils.MyDateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-09 17:55
 * <p>
 * desc
 **/
@Service
@Slf4j
public class PortalUserPointsServiceImpl implements PortalUserPointsService {

    @Autowired
    UmsUserPointsRecordMapper umsUserPointsRecordMapper;

    @Autowired
    UmsUserMemberMapper umsUserMemberMapper;

    @Autowired
    MathUtils mathUtils;

    @Value( "${integration-server-addr}" )
    private  String INTEGRATION_SERVER_ADDR;

    @Override
    public UmsUserMember getUserPointsInfo(String userId) {
        UmsUserMemberExample example = new UmsUserMemberExample();
        example.createCriteria().andUserIdEqualTo( userId );
        return umsUserMemberMapper.selectByExample( example ).get( 0 );
    }

    @Override
    public List<PortalPointsResult> getUserPointsRecord(String userId) {
        UmsUserPointsRecordExample example = new UmsUserPointsRecordExample();
        example.setOrderByClause( "create_time desc" );
        example.createCriteria().andUserIdEqualTo( userId );
        List<UmsUserPointsRecord> dataList = new ArrayList <>(  );
        List<PortalPointsResult> portalPointsResultList = new ArrayList <>(  );
        PortalPointsResult portalPointsResult = new PortalPointsResult();
        Map<String,List> map = new HashMap <>(  );
        List <UmsUserPointsRecord> umsUserPointsRecords=umsUserPointsRecordMapper.selectByExample( example );
        if(umsUserPointsRecords.size() > 0){
            for(UmsUserPointsRecord umsUserPointsRecord : umsUserPointsRecords){
                String time=MyDateUtil.parseDateToTime( umsUserPointsRecord.getCreateTime() );
                if(map.get( time ) == null){
                    dataList = new ArrayList <>(  );
                    portalPointsResult = new PortalPointsResult();
                    portalPointsResult.setMonth( time );
                    dataList.add( umsUserPointsRecord );
                    map.put( time,dataList );
                    portalPointsResult.setDataList( dataList );
                    portalPointsResultList.add( portalPointsResult );
                }else{
                    map.get( time ).add( umsUserPointsRecord );
                }

            }

        }
        return portalPointsResultList;
    }

    /**
     * descrition: TODO
     * create_user: shenshaoqiu
     * create_date: 2019/7/10
     * create_time: 10:25
     * param: cardCode会员卡code,consumeMoney消费金额,单位分
     * return:
     **/
    @Override
    public CommonResult updateIntegration(String cardCode, int consumeMoney) {
        int count = 0;
        UmsUserMemberExample example = new UmsUserMemberExample();
        example.createCriteria().andCardCodeEqualTo( cardCode );
        List <UmsUserMember> umsUserMembers=umsUserMemberMapper.selectByExample( example );
        if( umsUserMembers.size()>0 ){

            //修改积分
            UmsUserMember umsUserMember = umsUserMembers.get( 0 );
            int integration = (int)consumeMoney/100;//目前暂定1元1积分
            int bonus = umsUserMember.getIntegration()+integration;
            umsUserMember.setIntegration( bonus );
            count=umsUserMemberMapper.updateByExampleSelective( umsUserMember,example );

            //积分变动记录入库
            UmsUserPointsRecord record = new UmsUserPointsRecord();
            record.setChangeReason( "消费积分增加" );
            record.setChangeType( 1 );
            record.setCreateTime( new Date(  ) );
            record.setPointsChange( integration );
            record.setUserId( umsUserMember.getUserId() );
            record.setCardCode( cardCode );
            count = umsUserPointsRecordMapper.insertSelective( record );

            //调用服务增加积分
            StringBuffer sb = new StringBuffer(  );
            sb.append( "add_bonus="+integration )
                    .append( "app="+77904001 )
                    .append( "app_name="+"book coffee" )
                    .append( "bonus="+bonus )
                    .append( "card_id="+"pNEQk1Uq6j7U7vz3Wu5FsMLrYqbk" )
                    .append( "code="+cardCode )
                    .append( "record_bonus="+"消费"+mathUtils.getTwoBitValue( consumeMoney/100 )+"元"+",获取"+integration+"积分" );
            String response=HttpUtils.getResponse( INTEGRATION_SERVER_ADDR, sb.toString() );

            if(StringUtils.isEmpty( record )){
                return new CommonResult().failed( "增加会员卡积分失败" );
            }else {
                HttpRequestResponse<IntegrationDto> httpRequestResponse=JSONObject.parseObject( response, HttpRequestResponse.class );
                if(httpRequestResponse.getStatus() == 1){
                    return new CommonResult().success( "增加会员卡积分成功" );
                }else {
                    log.info( "updateIntegration info{}",JSONObject.toJSONString( response ) );
                    return new CommonResult().failed( "增加会员卡积分失败" );
                }
            }
        }

        return new CommonResult().failed( "增加会员卡积分失败" );
    }
}
