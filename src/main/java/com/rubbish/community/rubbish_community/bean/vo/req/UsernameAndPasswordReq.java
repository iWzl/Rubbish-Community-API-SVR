package com.rubbish.community.rubbish_community.bean.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Leo Wang
 * @version 1.0
 * @date 2019/7/30 20:03
 */
@Data
@ApiModel(value = "UserAndPassword",description = "用户名和密码")
public class UsernameAndPasswordReq {
    @ApiModelProperty(value = "用户输入账户名",required = true,example = "LeoWong")
    private String userName;
    @ApiModelProperty(value = "用户密码",required = true,example = "123456")
    private String password;
    @ApiModelProperty(value = "设备信息",required = true)
    private DeviceReq equipmentInfo;
}
