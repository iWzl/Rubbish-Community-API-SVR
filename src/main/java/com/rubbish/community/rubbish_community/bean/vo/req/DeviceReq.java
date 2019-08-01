package com.rubbish.community.rubbish_community.bean.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Leo Wang
 * @version 1.0
 * @date 2019/7/30 20:08
 */
@Data
@ApiModel(value = "DeviceReq",description = "登录设备信息")
public class DeviceReq {
    @ApiModelProperty(value = "设备型号",required = true,example = "HuaweiMate20pro")
    private String systemModel;
    @ApiModelProperty(value = "系统版本",required = true,example = "Android 7.1.1")
    private String OSVersion;
    @ApiModelProperty(value = "APP版本信息",required = true,example = "V1.0.0")
    private String appVersion;
}
