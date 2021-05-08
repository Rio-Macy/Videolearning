package com.duyi.video.dao;

import com.duyi.video.entity.ToolsType;

import java.util.HashMap;
import java.util.List;

/**
 * @author sujuntao
 */
public interface ToolsTypeDao {

    /**
     *  插入工具类别
     * @param toolsType
     * @return
     */
    int insertToolsType(ToolsType toolsType);

    /**
     *  查找工具类别
     * @param map
     * @return
     */
    List<ToolsType> findToolsTypeByCondition(HashMap<String, Object> map);
}
