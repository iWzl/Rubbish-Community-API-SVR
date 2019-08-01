package com.rubbish.community.rubbish_community.bean.vo.req;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("新增用户添加")
public class NewProfileReq {

  @ApiModelProperty(value = "邮箱验证码",required = true,example = "XAF26A")
  private String code;
  @ApiModelProperty(value = "用户登录名称",required = true,example = "TestAccount")
  private String id;
  @ApiModelProperty(value = "账户密码",required = true,example = "Password")
  private String password;
  @ApiModelProperty(value = "用户头像名",required = true,example = "dsads265ds44fF64A.jpg")
  private String portrait;
  @ApiModelProperty(value = "用户名",required = true,example = "张天霸")
  private String name;
  @ApiModelProperty(value = "城市",example = "成都")
  private String city;
  @ApiModelProperty(value = "工作",example = "Java程序员")
  private String work;
  @ApiModelProperty(value = "年龄",example = "21")
  private Integer age;
  @ApiModelProperty(value = "分类宣言",example = "我的命,我说了算")
  private String content;
  @ApiModelProperty(value = "性别",notes = "数字编码 0-女 1-男",example = "0")
  private Integer gender;


}
