package com.duyi.video.service.impl;

import com.duyi.video.dao.CourseVideoDao;
import com.duyi.video.entity.CourseVideo;
import com.duyi.video.service.CourseVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author sujuntao
 */
@Service
public class CourseVideoServiceImpl implements CourseVideoService {

    @Autowired
    CourseVideoDao courseVideoDao;

    @Override
    public List<CourseVideo> getCourseVideo(int topicId) {

        HashMap<String, Object> map = new HashMap<String, Object>(2);
        map.put("courseTopicId", topicId);
        map.put("flag", 1);

        List<CourseVideo> list = courseVideoDao.findCourseVideoByCondition(map);

        return list;
    }
}
