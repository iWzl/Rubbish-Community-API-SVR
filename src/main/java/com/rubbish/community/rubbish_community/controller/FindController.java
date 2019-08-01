package com.rubbish.community.rubbish_community.controller;

import com.rubbish.community.rubbish_community.bean.vo.common.ServiceResponseMessage;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Leo Wang
 * @version 1.0
 * @date 2019/7/30 20:40
 */

@RestController
@RequestMapping("/api/find")
@Api(value = "发现模块",tags = "社区发现模块")
public class FindController {

    @ApiOperation(value = "测试方法",notes = "多个参数，多种的查询参数类型")
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name="key",value="键值",required=true,paramType="String"),
            @ApiImplicitParam(name="value",value="值",required=true,paramType="String"),
    })
    @PostMapping("test/back")
    public ServiceResponseMessage getProfileWithId(String key, String value){
        return ServiceResponseMessage.createBySuccessCodeMessage(UUID.randomUUID());
    }

    @GetMapping("dynamic/list")
    public ServiceResponseMessage getDynamicList(){

    }

}
