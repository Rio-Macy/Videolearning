package com.duyi.video.dao;

import com.duyi.video.entity.Banner;

import java.util.List;
import java.util.Map;


/**
 * @author sujuntao
 */
public interface BannerDao {

    /**
     *  添加Banner
     * @param banner
     * @return
     */
    int insertBanner(Banner banner);

    /**
     *  查找广告位
     * @param map
     * @return
     */
    List<Banner> findBannerByCondition(Map<String, Object> map);
}
