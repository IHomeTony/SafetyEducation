package com.itony.safetyedu.microservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itony.safetyedu.microservice.entity.EduTeacher;
import com.itony.safetyedu.microservice.entity.query.TeacherQuery;
import com.itony.safetyedu.microservice.mapper.EduTeacherMapper;
import com.itony.safetyedu.microservice.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author Miracle
 * @since 2021-03-19
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    @Override
    public void getTeacherByQueryCondition(Page<EduTeacher> teacherPage, TeacherQuery teacherQuery) {

        if(teacherQuery==null)
        {
            baseMapper.selectPage(teacherPage,null);
            return;
        }
        //如果queryTeacher不为空
        //从queryTeacher对象里面获取出条件值
        String name = teacherQuery.getName();
        String level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(name)) {
            //拼接条件
            wrapper.like("name",name);
        }
        if(!StringUtils.isEmpty(level)) {
            wrapper.eq("level",level);
        }
        if(!StringUtils.isEmpty(begin)) {
            wrapper.ge("gmt_create",begin);
        }
        if(!StringUtils.isEmpty(end)) {
            wrapper.le("gmt_create",end);
        }
        //条件查询带分页
        baseMapper.selectPage(teacherPage,wrapper);
    }
}
