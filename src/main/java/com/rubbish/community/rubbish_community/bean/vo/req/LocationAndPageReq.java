package com.rubbish.community.rubbish_community.bean.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Leo Wang
 * @version 1.0
 * @date 2019/8/1 20:35
 */
@Data
@ApiModel(description = "位置和页码数")
public class LocationAndPageReq {
    @ApiModelProperty(value = "页面数",required = true,example = "1")
    private Integer page;
    @ApiModelProperty(value = "街道",required = true,example = "天才大道")
    private String street;
    @ApiModelProperty(value = "县/区",required = true,example = "高新区")
    private String district;
    @ApiModelProperty(value = "城市",required = true,example = "成都")
    private String city;
    @ApiModelProperty(value = "省份",required = true,example = "四川")
    private String province;
    @ApiModelProperty(value = "国家",required = true,example = "中国")
    private String country;
}
