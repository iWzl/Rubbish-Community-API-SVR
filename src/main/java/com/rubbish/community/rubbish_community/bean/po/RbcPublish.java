package com.rubbish.community.rubbish_community.bean.po;


import lombok.Data;

import java.util.Date;

@Data
public class RbcPublish {
  private long id;
  private long uid;
  private long contentId;
  private long type;
  private String locationStreet;
  private String locationDistrict;
  private String locationCity;
  private String locationProvince;
  private String locationCountry;
  private Date time;
}
