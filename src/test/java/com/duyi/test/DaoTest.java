package com.duyi.test;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.duyi.video.dao.*;
import com.duyi.video.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.management.ObjectName;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Handler;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/*.xml"})
public class DaoTest {

    @Autowired
    UserDao userDao;
    @Autowired
    BannerDao bannerDao;
    @Autowired
    CourseTypeDao courseTypeDao;
    @Autowired
    CourseTopicDao courseTopicDao;
    @Autowired
    CourseVideoDao courseVideoDao;

    @Autowired
    ToolsItemDao toolsItemDao;

    @Autowired
    ToolsTypeDao toolsTypeDao;

    @Test
    public void test1() {

        User user = new User();
        user.setCreateTime(new Date());
        user.setEmail("email");
        user.setPassword("1231");
        user.setVipFlag(0);

        int code = userDao.insertUser(user);
        System.out.println(code);
    }

    @Test
    public void test(){

        Map<String, Object> map = new HashMap<>(2);
        map.put("email", "email");
//        map.put("vip_flag", 1);

        List<User> userList = userDao.findUserByCondition(map);
        User user = userList.get(0);
        System.out.println(user.toString());

        System.out.println(userList.get(0).toString());
    }
//    Error:(63, 36) java: 无法访问java.time.temporal.TemporalAccessor
//    找不到java.time.temporal.TemporalAccessor的类文件
    @Test
    public void test2() {

        Map<String, Object> map = new HashMap<>(2);
        map.put("id", 1);
        map.put("password", "@#$awerq13");

        int code = userDao.updateUser(map);
        System.out.println("code:" + code);
    }

    @Test
    public void test4() {

        Banner banner = new Banner();
        banner.setFlag(1);
        banner.setCreateTime(new Date());
        banner.setTargetUrl("target");
        banner.setType(1);

        int code = bannerDao.insertBanner(banner);
        System.out.println(code);
    }

    @Test
    public void test5(){

        Map<String, Object> map = new HashMap<>(6);

        map.put("flag", 1);

        List<Banner> bannerList = bannerDao.findBannerByCondition(map);
        System.out.println(bannerList.toString());
    }

    @Test
    public void test7() {

        CourseType courseType = new CourseType();
        courseType.setName("Java");

        int code = courseTypeDao.insertCourseType(courseType);
        System.out.println(code);
    }

    @Test
    public void test8(){

        Map<String, Object> map = new HashMap<>(6);

        map.put("name", "java");

        List<CourseType> courseTypeList = courseTypeDao.findCourseTypeByCondition(map);
        System.out.println(courseTypeList.get(0).toString());
    }

    @Test
    public void test9() {
        CourseTopic courseTopic = new CourseTopic();
        courseTopic.setTopicName("tntntntnt");

        int code = courseTopicDao.insertCourseTopic(courseTopic);
        System.out.println(code);
    }
    @Test
    public void t9() {

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id", "1");

        System.out.println(courseTopicDao.findCourseTopicByCondition(map));
    }

    @Test
    public void test10() {
        CourseVideo courseVideo = new CourseVideo();
        courseVideo.setVideoName("vnvnvnnv");

        int code = courseVideoDao.insertCourseVideo(courseVideo);
        System.out.println(code);
    }

    @Test
    public void t11() {

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id", "1");

        System.out.println(courseVideoDao.findCourseVideoByCondition(map));
    }

    @Test
    public void test12() {
        ToolsItem toolsItem = new ToolsItem();
        toolsItem.setName("itittitititit");

        int code = toolsItemDao.insertToolsItem(toolsItem);
        System.out.println(code);
    }

    @Test
    public void t13() {

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id", "1");

        System.out.println(toolsItemDao.findToolsItemByCondition(map));
    }
    @Test
    public void test14() {
        ToolsType toolsType = new ToolsType();
        toolsType.setName("ttttittitititsdfsdf");

        int code = toolsTypeDao.insertToolsType(toolsType);
        System.out.println(code);
    }

    @Test
    public void t15() {

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id", "1");

        System.out.println(toolsTypeDao.findToolsTypeByCondition(map));
    }

    @Test
    public void test_md5() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("as");
        stringBuilder.append(13);

        System.out.println(stringBuilder.toString());
    }


    @Test
    public void showHashMap() {

        HashMap<String, Object> map = new HashMap<>();
        AtomicInteger ai = new AtomicInteger(0);
        System.out.println(ai.get());
        ai.getAndDecrement();
//        System.out.println(map.get());

        map.put("show1", "show1Value");
        map.put("show2", "show2Value");
        map.put("show3", "show3Value");
        map.put("show4", "show4Value");
        map.put("show5", "show5Value");

        ConcurrentHashMap<String, Object> concurrentMap = new ConcurrentHashMap<>(1);

        concurrentMap.put("show6", "show6Value");
        for (Map.Entry<String, Object> entry: map.entrySet()) {

            System.out.println(entry + ":" + entry.getValue());
        }
    }

    @Test
    public void HashMapDead(){


        for (int i = 100; i < 199; i++) {

            if (i%3==1&i%4==2&i%5==2) {

                System.out.println(i);
            }
        }

        System.out.println(142 / 3);

    }

    @Test
    public void MD5(){

        System.out.println(DigestUtil.md5Hex("123123"));
    }

    @Test
    public void ArrayList() {

        String[] strings = new String[3];

        strings[0] = "one";
        strings[1] = "twe";
        strings[2] = "three";

        List<String> stringList = Arrays.asList(strings);
        System.out.println(stringList);

        List<Object> objects = new java.util.ArrayList < Object > (Arrays.asList(strings));
        System.out.println(objects);
        objects.add("five");
        System.out.println(objects);

        Integer[] integers = new Integer[2];
        integers[0] = 12;
        integers[1] = 23;

        // 数组转集合
        List<Integer> integerList = new java.util.ArrayList<Integer>(Arrays.asList(integers));
        integerList.add(34);
        System.out.println(integerList);
        // ------------------------------
        List<Double> list = new ArrayList<>(3);
        list.add(123.234);
        list.add(2341.234);
        list.add(4312.324);

        Object[] array1 = list.toArray();
        System.out.println(array1[1]);

        Double[] array2 = new Double[2];
        list.toArray(array2);

        System.out.println(Arrays.asList(array2));

        // 获取集合和数组的长度，改变数组长度

        boolean[] s = new boolean[2];
        for (int i = 0; i < s.length; i++) {

            System.out.println(s[i]);
        }

        String[][] s1 = new String[2][2];

    }

}
