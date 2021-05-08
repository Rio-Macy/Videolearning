package com.duyi.video.service;

import com.duyi.video.entity.CourseVideo;

import java.util.List;

/**
 * @author sujuntao
 */
public interface CourseVideoService {

    /**
     *  根据专题ID 获取所有视频
     * @param topicId
     * @return
     */
    List<CourseVideo> getCourseVideo(int topicId);

}
