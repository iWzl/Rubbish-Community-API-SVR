package com.rubbish.community.rubbish_community.controller;

import com.rubbish.community.rubbish_community.bean.po.RbcProfile;
import com.rubbish.community.rubbish_community.bean.vo.req.*;
import com.rubbish.community.rubbish_community.bean.vo.common.ServiceResponseMessage;
import com.rubbish.community.rubbish_community.bean.vo.resp.SimpleProfileResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author Leo Wang
 * @version 1.0
 * @date 2019/7/30 20:22
 */
@RestController
@RequestMapping("/api/account")
@Api(value = "账户模块",tags = "账户相关模块")
public class AccountController {

    @ApiOperation(value = "用户登录接口")
    @ApiParam(name = "usernameAndPassword",required = true,value = "用户登录信息，同时包含用户的设备信息")
    @PostMapping(value = "/login",consumes =  MediaType.APPLICATION_JSON_UTF8_VALUE,produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ServiceResponseMessage login(@RequestBody UsernameAndPasswordReq usernameAndPassword){
        return ServiceResponseMessage.createBySuccessCodeMessage();
    }

    @ApiOperation(value = "用户注销接口")
    @ApiParam(value = "用户注销登录")
    @PostMapping(value = "/logout",produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ServiceResponseMessage logout(){
        return ServiceResponseMessage.createBySuccessCodeMessage();
    }

    @ApiOperation(value = "根据用户uid获取用户信息")
    @ApiParam(name = "uid",required = true,value = "用户UID")
    @GetMapping(value = "/info/{uid}/get",produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ServiceResponseMessage getSimpleProfileWithUid(@PathVariable("uid") String uid) {
        return ServiceResponseMessage.createBySuccessCodeMessage(new SimpleProfileResp());
    }

    @ApiOperation(value = "根据用户uid获取详细用户信息")
    @ApiParam(name = "uid",required = true,value = "用户UID")
    @GetMapping(value = "/profile/{uid}/get",produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ServiceResponseMessage getProfileWithUid(@PathVariable("uid") String uid){
        return ServiceResponseMessage.createBySuccessCodeMessage(new RbcProfile());
    }

    @ApiOperation(value = "修改用户信息")
    @ApiParam(name = "ProfileModifyReq",required = true,value = "用户待修改的信息组")
    @PutMapping(value = "/profile/modify",consumes =  MediaType.APPLICATION_JSON_UTF8_VALUE,produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ServiceResponseMessage modifyProfile(@RequestBody ProfileModifyReq modifyReq){
        return ServiceResponseMessage.createBySuccessCodeMessage("修改成功");
    }

    @ApiOperation(value = "修改用户密码")
    @ApiParam(name = "ProfileModifyReq",required = true,value = "用户修改密码组")
    @PutMapping(value = "/password/modify",consumes =  MediaType.APPLICATION_JSON_UTF8_VALUE,produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ServiceResponseMessage resetPassword(@RequestBody PasswordReq passwordReq){
        return ServiceResponseMessage.createBySuccessCodeMessage("修改成功");
    }

    @ApiOperation(value = "忘记用户密码")
    @ApiParam(name = "ProfileModifyReq",required = true,value = "用户忘记密码组")
    @PutMapping(value = "/password/forget",consumes =  MediaType.APPLICATION_JSON_UTF8_VALUE,produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ServiceResponseMessage forgetPassword(@RequestBody PasscodeReq passcodeReq){
        return ServiceResponseMessage.createBySuccessCodeMessage("重置成功");
    }

    @ApiOperation(value = "注册新用户")
    @ApiParam(name = "ProfileModifyReq",required = true,value = "注册用户信息")
    @PostMapping(value = "/profile/new",consumes =  MediaType.APPLICATION_JSON_UTF8_VALUE,produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ServiceResponseMessage createNewProfile(@RequestBody NewProfileReq profileReq){
        return ServiceResponseMessage.createBySuccessCodeMessage(new RbcProfile());
    }
















}
