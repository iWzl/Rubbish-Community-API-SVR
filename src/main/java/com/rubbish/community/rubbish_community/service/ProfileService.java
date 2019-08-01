package com.rubbish.community.rubbish_community.service;

import com.rubbish.community.rubbish_community.bean.vo.resp.SimpleProfileResp;

/**
 * @author Leo Wang
 * @version 1.0
 * @date 2019/7/25 22:00
 */
public interface ProfileService {
    public SimpleProfileResp getSimpleProfileByUserId(String id);
}
