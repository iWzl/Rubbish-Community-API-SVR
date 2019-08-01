package com.rubbish.community.rubbish_community.bean.po;

import lombok.Data;

@Data
public class RbcAnswer {
  private long id;
  private long questionId;
  private long uid;
  private long choose;
  private long status;
}
