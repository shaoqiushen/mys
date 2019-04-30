package com.shanyuan.bgbirdadmin.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.bgbirdadmin.service.OmsProductCommentService;
import com.shanyuan.domain.CommonResult;
import com.shanyuan.model.OmsProductComment;
import com.shanyuan.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-28 14:47
 * <p>
 * desc
 **/
@Api(value="OmsProductCommentController",description="商品评价管理")
@RequestMapping("/comment")
@RestController
public class OmsProductCommentController {

    @Autowired
    OmsProductCommentService omsProductCommentService;

    @ApiOperation( "分页查询商品评价列表" )
    @PostMapping("/listCommentByParams")
    public CommonResult listCommentByParams(@RequestParam(defaultValue="")String productName){
        List <OmsProductComment> omsProductComments=omsProductCommentService.listCommentByParams( productName );
        PageInfo<OmsProductComment> productCommentPageInfo = new PageInfo <>( omsProductComments );
        return new CommonResult().pageSuccess( productCommentPageInfo );
    }

    @ApiOperation( "修改评价是否展示" )
    @PostMapping("updateComment/{id}")
    @ApiImplicitParam(name="showStatus",value="是否显示在手机端:0->否,1->是",required=true)
    public CommonResult updateComment(@PathVariable Integer id,@RequestParam("showStatus") Integer showStatus){
        int count=omsProductCommentService.updateComment( id, showStatus );
        return ResultUtil.result( count );
    }

    @ApiOperation( "创建评价回复内容" )
    @PostMapping("createCommentReply/{commentId}")
    @ApiImplicitParam(name="replyContent",value="回复内容",required=true,example="谢谢您的惠顾,我们会努力做的更好")
    public CommonResult createCommentReply(@PathVariable Integer commentId,@RequestParam(defaultValue="谢谢您的惠顾,我们会努力做的更好")String replyContent){
        int count=omsProductCommentService.createCommentReply( commentId, replyContent );
        return ResultUtil.result( count );
    }
}
