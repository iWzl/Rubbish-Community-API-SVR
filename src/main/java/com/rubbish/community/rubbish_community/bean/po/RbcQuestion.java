package com.rubbish.community.rubbish_community.bean.po;


import lombok.Data;

import java.util.Date;

@Data
public class RbcQuestion {

  private long id;
  private Date time;
  private String content;
  private long uid;
  private long status;
}
