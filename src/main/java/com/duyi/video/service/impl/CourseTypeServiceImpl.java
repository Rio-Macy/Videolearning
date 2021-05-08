package com.duyi.video.service.impl;

import com.duyi.video.dao.CourseTypeDao;
import com.duyi.video.entity.CourseTopic;
import com.duyi.video.entity.CourseType;
import com.duyi.video.service.CourseTopicService;
import com.duyi.video.service.CourseTypeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sujuntao
 */
@Service
public class CourseTypeServiceImpl implements CourseTypeService {

    @Autowired
    CourseTypeDao courseTypeDao;

    @Override
    public List<CourseType> getAllType() {

        List<CourseType> list = courseTypeDao.findCourseTypeAll();

        return list;
    }
}
