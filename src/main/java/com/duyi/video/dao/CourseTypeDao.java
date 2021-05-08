package com.duyi.video.dao;

import com.duyi.video.entity.CourseType;

import java.util.List;
import java.util.Map;

/**
 * @author sujuntao
 */
public interface CourseTypeDao {

    /**
     *  添加课程类别
     * @param courseType
     * @return
     */
    int insertCourseType(CourseType courseType);

    /**
     *  查找课程类别
     * @param map
     * @return
     */
    List<CourseType> findCourseTypeByCondition(Map<String, Object> map);

    /**
     *  查询所有课程专题专题
     * @return
     */
    List<CourseType> findCourseTypeAll();
}
