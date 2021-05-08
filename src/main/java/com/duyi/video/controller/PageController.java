package com.duyi.video.controller;

import com.duyi.video.entity.CourseTopic;
import com.duyi.video.entity.CourseType;
import com.duyi.video.service.CourseTopicService;
import com.duyi.video.service.CourseTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author sujuntao
 */
@Controller
public class PageController {

    @Autowired
    CourseTopicService courseTopicService;

    @Autowired
    CourseTypeService courseTypeService;

    /**
     *  访问到首页
     * @return
     */
    @RequestMapping(value = "/")
    public String indexPage(Model model) {

        System.out.println("===============================");
        System.out.println("访问到index页面");
        System.out.println("===============================");

        // 首页 常用框架 1
        PageHelper.startPage(1, 4);
        PageInfo<CourseTopic> pageType1 = courseTopicService.getCourseTopicList(1);
        // 首页 数据库 3
        PageHelper.startPage(1, 4);
        PageInfo<CourseTopic> pageType3 = courseTopicService.getCourseTopicList(3);

        model.addAttribute("pageType1", pageType1);
        model.addAttribute("pageType3", pageType3);

        model.addAttribute("clickNav", 1);

        return "index";
    }

    /**
     * 忘记密码
     * @return
     */
    @RequestMapping(value = "/forgetPage")
    public String forgetPage(){

        return "forget";
    }

    @RequestMapping("/topicList")
    public String topicList(Model model) {

        // 获取专题数据显示
        // 获取所有专题数据(不指定类型)
        PageHelper.startPage(1, 16);
        PageInfo<CourseTopic> topicList = courseTopicService.getCourseTopicList();

        List<CourseType> courseTypeList = courseTypeService.getAllType();

        model.addAttribute("topicList", topicList);
        model.addAttribute("courseTypeList", courseTypeList);

        // 全部
        model.addAttribute("clickType", 0);
        // 课程 2
        model.addAttribute("clickNav", 2);

        return "topic_list";
    }

}
