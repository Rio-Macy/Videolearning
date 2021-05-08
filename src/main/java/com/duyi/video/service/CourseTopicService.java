package com.duyi.video.service;

import com.duyi.video.entity.CourseTopic;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;

/**
 * @author sujuntao
 */
public interface CourseTopicService {

    // 根据课程分类获取专题视频
    // List<CourseTopic> getCourseTopicList(int typeId);
    // 分页插件

    /**
     *  根据type_id（课程专题id）查询,相应的课程
     * @param typeId
     * @return
     */
    PageInfo<CourseTopic> getCourseTopicList(int typeId);

    /**
     *  查询所用课程
     * @return
     */
    PageInfo<CourseTopic> getCourseTopicList();

    /**
     *  根据topicId获取相应的课程
     * @param topicId
     * @return
     */
    CourseTopic getCourseTopic(int topicId);

    /**
     *  根据关键字查找课程
     * @param keyword
     * @return
     */
    PageInfo<CourseTopic> searchCourseTopic(String keyword);

}
