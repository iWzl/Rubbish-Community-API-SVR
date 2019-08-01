package com.rubbish.community.rubbish_community.dao;

import com.rubbish.community.rubbish_community.bean.po.RbcProfile;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Leo Wang
 * @version 1.0
 * @date 2019/7/25 22:02
 */

@Repository
public interface ProfileDao {
    public RbcProfile getProfileInfoByUserId(@Param("id") String id);
}
