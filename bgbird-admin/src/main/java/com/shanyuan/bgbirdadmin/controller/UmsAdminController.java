package com.shanyuan.bgbirdadmin.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.bgbirdadmin.dto.UmsAdminLoginParams;
import com.shanyuan.bgbirdadmin.dto.UmsAdminLoginResult;
import com.shanyuan.bgbirdadmin.dto.UmsAdminParams;
import com.shanyuan.bgbirdadmin.service.UmsAdminService;
import com.shanyuan.domain.CommonResult;
import com.shanyuan.model.UmsAdmin;
import com.shanyuan.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-26 15:01
 * <p>
 * desc
 **/
@Api(value="UmsAdminController",description="后台用户管理")
@RequestMapping("/admin")
@RestController
public class UmsAdminController {

    @Autowired
    UmsAdminService umsAdminService;

    @ApiOperation( "创建后台管理员" )
    @PostMapping("/createAdmin")
    public CommonResult createAdmin(@Validated @RequestBody UmsAdminParams umsAdminParams, BindingResult bindingResult){
        int count=umsAdminService.createAdmin( umsAdminParams );
        return ResultUtil.result( count );
    }

    @ApiOperation( "修改指定的管理员" )
    @PostMapping("/updateAdmin/{id}")
    public CommonResult updateAdmin(@PathVariable Integer id,@Validated @RequestBody UmsAdminParams umsAdminParams,BindingResult bindingResult){
        int count=umsAdminService.updateAdmin( id, umsAdminParams );
        return ResultUtil.result( count );
    }

    @ApiOperation( "删除指定的管理员" )
    @PostMapping("/deleteAdmin/{id}")
    public CommonResult deleteAdmin(@PathVariable Integer id){
        int count=umsAdminService.deleteAdmin( id );
        return ResultUtil.result( count );
    }

    @ApiOperation( "分页查询管理员列表" )
    @GetMapping("/listAdmin")
    public CommonResult listAdmin(@RequestParam(defaultValue="1")Integer pageNum,
                                  @RequestParam(defaultValue="10")Integer pageSize){
        List <UmsAdmin> umsAdmins=umsAdminService.listAdmin( pageNum, pageSize );
        PageInfo<UmsAdmin> pageInfo = new PageInfo <>( umsAdmins );
        return new CommonResult().pageSuccess( pageInfo );
    }

    @ApiOperation( "登录" )
    @PostMapping("/login")
    public CommonResult login(@Validated @RequestBody UmsAdminLoginParams umsAdminLoginParams,BindingResult bindingResult){
        String account = umsAdminLoginParams.getAccount();
        String password = umsAdminLoginParams.getPassword();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(account, password);
        Subject subject = SecurityUtils.getSubject();
//        subject.getSession().setTimeout( 5000 );
        try{
            subject.login( token );
        }catch ( Exception e ){
            return new CommonResult().validateFailed( "登录失败，账号或密码不正确" );
        }
        UmsAdminLoginResult login=umsAdminService.login( account, password );
        return new CommonResult().success( "登录成功",login );
    }

    @RequestMapping("/notLogin")
    public CommonResult notLogin(){
        return new CommonResult().failed( 7777,"登录超时,请重新登录" );
    }

    @RequestMapping("/unAuth")
    public CommonResult unAuth(){
        return new CommonResult().failed( 7778,"抱歉，您没有权限访问" );
    }

}
