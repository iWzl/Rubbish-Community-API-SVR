package com.rubbish.community.rubbish_community.bean.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Leo Wang
 * @version 1.0
 * @date 2019/7/31 21:03
 */
@Data
@ApiModel("用户忘记密码携带参数")
public class PasscodeReq {
    @ApiModelProperty(value = "邮箱验证吗",required = true,example = "EDS8TA")
    private String code;
    @ApiModelProperty(value = "用户ID",required = true,example = "TestAccount")
    private String id;
    @ApiModelProperty(value = "新密码",required = true,example = "PASSCODE")
    private String passcode;
}
