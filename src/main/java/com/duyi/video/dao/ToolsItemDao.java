package com.duyi.video.dao;

import com.duyi.video.entity.ToolsItem;

import java.util.HashMap;
import java.util.List;

/**
 * @author sujuntao
 */
public interface ToolsItemDao {

    /**
     *  插入工具类
     * @param toolsItem
     * @return
     */
    int insertToolsItem(ToolsItem toolsItem);

    /**
     *  查找工具栏
     * @param map
     * @return
     */
    List<ToolsItem> findToolsItemByCondition(HashMap<String, Object> map);
}
