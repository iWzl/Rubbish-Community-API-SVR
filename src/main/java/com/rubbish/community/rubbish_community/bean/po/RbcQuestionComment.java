package com.rubbish.community.rubbish_community.bean.po;


import lombok.Data;

import java.util.Date;

@Data
public class RbcQuestionComment {

  private long id;
  private long questionId;
  private long to;
  private String content;
  private Date time;
  private long status;
}
