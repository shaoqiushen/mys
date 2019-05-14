package com.shanyuan.bgbirdadmin.controller;

import com.shanyuan.bgbirdadmin.dto.OssCallbackResult;
import com.shanyuan.bgbirdadmin.dto.OssPolicyResult;
import com.shanyuan.bgbirdadmin.service.OssService;
import com.shanyuan.bgbirdadmin.service.impl.OssServiceImpl;
import com.shanyuan.domain.CommonResult;
import com.shanyuan.exception.BussinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-05 16:46
 * <p>
 * desc
 **/
@Api(value="OssController",description="oss文件上传管理")
@RequestMapping("/oss")
@RestController
public class OssController {

    @Autowired
    OssService ossService;

//    @ApiOperation( "上传图片" )
//    @GetMapping("/uploadImg")
//    public CommonResult policy(){
//        OssPolicyResult policy=ossService.policy();
//        return new CommonResult().success( policy );
//    }
//
//    @ApiOperation(value = "oss上传成功回调")
//    @PostMapping("/callBack")
//    public CommonResult callBack(HttpServletRequest request){
//        OssCallbackResult ossCallbackResult = ossService.callBack(request);
//        return new CommonResult().success(ossCallbackResult);
//    }

    @ApiOperation( "上传图片" )
    @PostMapping("/uploadImg")
    public CommonResult uploadImg(MultipartFile file) {
        String filePath=null;
        try {
            filePath=ossService.uploadImg( file );
            Map <String, String> resultMap=new HashMap <>();
            resultMap.put( "filePath", filePath );
            return new CommonResult().success( resultMap );
        } catch ( BussinessException e ) {
            return new CommonResult().failed( e.getMessage() );
        }

    }
}
