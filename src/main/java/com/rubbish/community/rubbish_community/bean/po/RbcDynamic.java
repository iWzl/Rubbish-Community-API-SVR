package com.rubbish.community.rubbish_community.bean.po;


import lombok.Data;

import java.util.Date;

@Data
public class RbcDynamic {

  private long id;
  private String content;
  private String images;
  private long uid;
  private Date createTime;
  private long status;
  private long type;

}
