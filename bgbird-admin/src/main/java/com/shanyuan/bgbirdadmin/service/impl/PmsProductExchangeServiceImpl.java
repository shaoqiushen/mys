package com.shanyuan.bgbirdadmin.service.impl;

import com.shanyuan.bgbirdadmin.dto.PmsProductExchangeParams;
import com.shanyuan.bgbirdadmin.dto.PmsProductExchangeResult;
import com.shanyuan.bgbirdadmin.service.PmsProductExchangeService;
import com.shanyuan.mapper.PmsProductExchangeMapper;
import com.shanyuan.model.PmsProductExchange;
import com.shanyuan.model.PmsProductExchangeExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-09 16:03
 * <p>
 * desc
 **/
@Service
public class PmsProductExchangeServiceImpl implements PmsProductExchangeService {

    @Autowired
    PmsProductExchangeMapper pmsProductExchangeMapper;

    @Override
    public int createProductExchange(PmsProductExchangeParams pmsProductExchangeParams) {
        PmsProductExchange pmsProductExchange = new PmsProductExchange();
        BeanUtils.copyProperties( pmsProductExchangeParams,pmsProductExchange );
        pmsProductExchange.setCreateTime( new Date(  ) );
        pmsProductExchange.setDeleteStatus( 0 );
        return pmsProductExchangeMapper.insert( pmsProductExchange );
    }

    @Override
    public int updateProductExchangeDeleteStatus(Integer itemId, Integer deleteStatus) {
        PmsProductExchangeExample exchangeExample = new PmsProductExchangeExample();
        exchangeExample.createCriteria().andItemIdEqualTo( itemId );
        PmsProductExchange pmsProductExchange = new PmsProductExchange();
        pmsProductExchange.setDeleteStatus( deleteStatus );
        return pmsProductExchangeMapper.updateByExampleSelective( pmsProductExchange,exchangeExample );
    }

    @Override
    public int updateProductExchange(Integer itemId,PmsProductExchangeParams pmsProductExchangeParams) {
        PmsProductExchange pmsProductExchange = new PmsProductExchange();
        BeanUtils.copyProperties( pmsProductExchangeParams,pmsProductExchange );

        PmsProductExchangeExample exchangeExample = new PmsProductExchangeExample();
        exchangeExample.createCriteria().andItemIdEqualTo( itemId );
        return pmsProductExchangeMapper.updateByExampleSelective( pmsProductExchange,exchangeExample );
    }

    @Override
    public PmsProductExchangeResult listProductExchange() {
        PmsProductExchangeExample exchangeExample = new PmsProductExchangeExample();
        exchangeExample.createCriteria().andDeleteStatusEqualTo( 0 )
                .andPublishStatusEqualTo( 1 );
        exchangeExample.setOrderByClause( "id" );
        List <PmsProductExchange> pmsProductExchanges=pmsProductExchangeMapper.selectByExample( exchangeExample );

        PmsProductExchangeResult pmsProductExchangeResult = new PmsProductExchangeResult();
        List<PmsProductExchange> boomList = new ArrayList <>(  );
        List<PmsProductExchange> allPointsList = new ArrayList <>(  );
        List<PmsProductExchange> pointCashList = new ArrayList <>(  );
        if(pmsProductExchanges.size()>0) {
            for (PmsProductExchange pmsProductExchange : pmsProductExchanges) {
                if (pmsProductExchange.getBoomType() == 1) {
                    //爆款推荐
                    boomList.add( pmsProductExchange );
                }
                if (pmsProductExchange.getExchangeType() == 0) {
                    //全积分兑换
                    allPointsList.add( pmsProductExchange );
                }
                if (pmsProductExchange.getExchangeType() == 1) {
                    //积分+钱兑换
                    pointCashList.add( pmsProductExchange );
                }
            }
        }
        pmsProductExchangeResult.setAllPointsList( allPointsList );
        pmsProductExchangeResult.setBoomList( boomList );
        pmsProductExchangeResult.setPointCashList( pointCashList );
        return pmsProductExchangeResult;
    }
}
