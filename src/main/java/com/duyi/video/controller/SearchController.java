package com.duyi.video.controller;

import com.duyi.video.entity.CourseTopic;
import com.duyi.video.service.CourseTopicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author sujuntao
 */
@Controller
public class SearchController {

    @Autowired
    CourseTopicService courseTopicService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(String keyword, Model model, Integer pageNum) {

        if (pageNum == null || pageNum <= 0) {
            pageNum = 1;
        }

        PageHelper.startPage(pageNum, 16);
        PageInfo<CourseTopic> pageInfo = courseTopicService.searchCourseTopic(keyword);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("keyword", keyword);

        return "search_list";
    }
}
