package com.duyi.video.dao;

import com.duyi.video.entity.CourseTopic;

import java.util.HashMap;
import java.util.List;

/**
 * @author sujuntao
 */
public interface CourseTopicDao {

    /**
     *  添加课程
     * @param courseTopic
     * @return
     */
    int insertCourseTopic(CourseTopic courseTopic);

    /**
     *  查找课程
     * @param map
     * @return
     */
    List<CourseTopic> findCourseTopicByCondition(HashMap<String, Object> map);

    /**
     *  根据课程专题查找课程
     * @param idList
     * @return
     */
    List<CourseTopic> findCourseTopicByIds(List<Integer> idList);

}
