package com.duyi.video.service.impl;

import com.duyi.video.dao.CourseTopicDao;
import com.duyi.video.entity.CourseTopic;
import com.duyi.video.service.CourseTopicService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author sujuntao
 */
@Service
public class CourseTopicServiceImpl implements CourseTopicService {

    @Autowired
    CourseTopicDao courseTopicDao;

    @Override
    public PageInfo<CourseTopic> getCourseTopicList(int typeId) {

        HashMap<String, Object> map = new HashMap<>(2);
        map.put("courseTypeId", typeId);
        map.put("flag", 1);

        List<CourseTopic> dbList = courseTopicDao.findCourseTopicByCondition(map);
        PageInfo<CourseTopic> pageInfo = new PageInfo<CourseTopic>(dbList);

        return pageInfo;
    }

    @Override
    public PageInfo<CourseTopic> getCourseTopicList() {

        HashMap<String, Object> map = new HashMap<String, Object>(1);
        map.put("flag", 1);

        List<CourseTopic> dbList = courseTopicDao.findCourseTopicByCondition(map);

        PageInfo<CourseTopic> pageInfo = new PageInfo<CourseTopic>(dbList);

        return pageInfo;
    }

    @Override
    public CourseTopic getCourseTopic(int topicId) {

        List<Integer> idList = new ArrayList<Integer>();
        idList.add(topicId);

        List<CourseTopic> list = courseTopicDao.findCourseTopicByIds(idList);

        return list.get(0);
    }

    @Override
    public PageInfo<CourseTopic> searchCourseTopic(String keyword) {

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("topicName", keyword);
        map.put("flag", 1);

        List<CourseTopic> list = courseTopicDao.findCourseTopicByCondition(map);

        PageInfo<CourseTopic> pageInfo = new PageInfo<CourseTopic>(list);

        return pageInfo;
    }

}
