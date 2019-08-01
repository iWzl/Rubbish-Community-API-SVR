package com.rubbish.community.rubbish_community.controller;

import com.rubbish.community.rubbish_community.bean.vo.common.ServiceResponseMessage;
import com.rubbish.community.rubbish_community.utils.basic.ResultCodeEnum;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.ServletRequest;


/**
 * @author Leo Wang
 * @version 1.0
 * @date 2019/7/29 21:43
 */

@RestController
@ApiIgnore
public class ErrorRequestController implements ErrorController{

    @GetMapping("/error/401")
    public ServiceResponseMessage errorRequest401(ServletRequest req){
        return ServiceResponseMessage.createByFailCodeMessage(ResultCodeEnum.UNAUTHORIZED,req.getAttribute("error").toString());
    }

    @GetMapping("/error")
    public ServiceResponseMessage errorRequest404(){
        return ServiceResponseMessage.createByFailCodeMessage(ResultCodeEnum.NOT_FOUND,"API NOT FOUND");
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
