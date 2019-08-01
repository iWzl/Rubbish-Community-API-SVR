package com.rubbish.community.rubbish_community.service.impl;

import com.rubbish.community.rubbish_community.bean.vo.resp.SimpleProfileResp;
import com.rubbish.community.rubbish_community.dao.ProfileDao;
import com.rubbish.community.rubbish_community.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Leo Wang
 * @version 1.0
 * @date 2019/7/31 21:28
 */
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    ProfileDao profileDao;

    @Override
    public SimpleProfileResp getSimpleProfileByUserId(String id) {
        profileDao.getProfileInfoByUserId(id);
        return null;
    }
}
