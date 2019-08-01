package com.rubbish.community.rubbish_community.controller;

import com.rubbish.community.rubbish_community.bean.vo.common.ServiceResponseMessage;
import com.rubbish.community.rubbish_community.utils.basic.ResultCodeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Leo Wang
 * @version 1.0
 * @date 2019/7/30 20:44
 */
@RestController
@RequestMapping("/api/search")
@Api(value = "搜索模块",tags = "用户搜索")
public class SearchController {



    @ApiImplicitParam(paramType = "query",name= "id" ,value = "用户登录ID",dataType = "string")
    @ApiOperation(value = "方法的用途、作用", notes="方法的备注说明")
    @GetMapping("test/getProfile")
    public ServiceResponseMessage getProfileWithId(String id){
        return ServiceResponseMessage.createBySuccessCodeMessage(ResultCodeEnum.SUCCESS_CREATED);
    }
}
