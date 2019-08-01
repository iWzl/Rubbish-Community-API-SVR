package com.rubbish.community.rubbish_community.bean.po;


import lombok.Data;

import java.util.Date;

@Data
public class RbcLike {

  private long id;
  private long publishId;
  private long uid;
  private long type;
  private Date time;
}
