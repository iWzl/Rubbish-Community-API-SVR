package com.rubbish.community.rubbish_community.controller;

import com.rubbish.community.rubbish_community.bean.vo.common.ServiceResponseMessage;
import com.rubbish.community.rubbish_community.bean.vo.req.LocationAndPageReq;
import io.swagger.annotations.*;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author Leo Wang
 * @version 1.0
 * @date 2019/7/30 20:40
 */

@RestController
@RequestMapping("/api/find/dynamic")
@Api(value = "发现模块",tags = "社区动态模块")
public class DynamicController {
    @GetMapping("dynamic/{location}/{page}/list")
    @ApiOperation(value = "根据页码和分页信息获取动态推文内容",notes = "传输的信息需要包括地理位置信息,从小往大，/间隔")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "location",value = "用户地理位置",required = true,example = "高鹏大道/高新区/成都/四川/中国"),
            @ApiImplicitParam(name = "page",value = "页码数",required = true,example = "2")
    })
    public ServiceResponseMessage getDynamicList(@PathVariable("location")String location,@PathVariable("page")Integer page){
        return null;
    }

    @GetMapping("vote/{page}/list")
    @ApiOperation(value = "根据页码问题内容",notes = "传输需要分页信息")
    @ApiImplicitParam(name = "page",value = "页码数",required = true,example = "6")
    public ServiceResponseMessage getVoteList(@PathVariable("page")Integer page){
        return null;
    }


    @PostMapping("/")
    public ServiceResponseMessage addVoteList(){
        return null;
    }


}
