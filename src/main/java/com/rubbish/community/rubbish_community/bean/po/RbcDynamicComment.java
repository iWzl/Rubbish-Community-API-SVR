package com.rubbish.community.rubbish_community.bean.po;


import lombok.Data;

import java.util.Date;

@Data
public class RbcDynamicComment {
  private long id;
  private long publishId;
  private long to;
  private String content;
  private Date time;
  private long status;
}
