package com.rubbish.community.rubbish_community.bean.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.models.auth.In;
import lombok.Data;

/**
 *
 * @author Leo Wang
 * @version 1.0
 * @date 2019/7/31 20:14
 */
@ApiModel("基本用户信息返回")
@Data
public class SimpleProfileResp {
    private Integer uid;
    private String id;
    private String name;
    private String portrait;
    private String city;
    private String content;
    private Integer age;
}

