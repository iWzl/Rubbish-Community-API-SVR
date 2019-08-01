package com.rubbish.community.rubbish_community.bean.po;

import lombok.Data;

import java.util.Date;

@Data
public class RbcRole {

  private long id;
  private String roleName;
  private String roleCode;
  private long updateBy;
  private Date updateTime;
  private long createBy;
  private java.sql.Timestamp createTime;
}
