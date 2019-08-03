package com.rubbish.community.rubbish_community.controller;

import com.rubbish.community.rubbish_community.bean.vo.common.ServiceResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/find")
@Api(value = "发现模块",tags = "社区投票模块")
public class VoteController {

    @GetMapping("vote/{page}/list")
    @ApiOperation(value = "根据页码问题内容",notes = "传输需要分页信息")
    @ApiImplicitParam(name = "page",value = "页码数",required = true,example = "6")
    public ServiceResponseMessage getVoteList(@PathVariable("page")Integer page){
        return null;
    }
}
