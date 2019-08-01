package com.rubbish.community.rubbish_community.bean.po;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
public class RbcProfile {
  private Integer uid;
  private String id;
  @JsonIgnore
  private String password;
  private String email;
  private String portrait;
  private String name;
  private Integer status;
  private String city;
  private String work;
  private Integer age;
  private String content;
  private Date createTime;
  private Integer gender;
}
