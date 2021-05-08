package com.duyi.video.dao;

import com.duyi.video.entity.CourseVideo;

import java.util.HashMap;
import java.util.List;

/**
 * @author sujuntao
 */
public interface CourseVideoDao {

    /**
     *  添加课程视频
     * @param courseVideo
     * @return
     */
    int insertCourseVideo(CourseVideo courseVideo);

    /**
     *  查找视频课程
     * @param map
     * @return
     */
    List<CourseVideo> findCourseVideoByCondition(HashMap<String, Object> map);
}
