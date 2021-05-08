package com.duyi.video.service;

import com.duyi.video.entity.CourseType;

import java.util.List;

/**
 * @author sujuntao
 */
public interface CourseTypeService {

    /**
     *  查询所有的此课程专题
     * @return
     */
    List<CourseType> getAllType();
}
