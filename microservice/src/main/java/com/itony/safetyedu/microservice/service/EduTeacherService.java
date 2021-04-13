package com.itony.safetyedu.microservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itony.safetyedu.microservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itony.safetyedu.microservice.entity.query.TeacherQuery;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author Miracle
 * @since 2021-03-19
 */
public interface EduTeacherService extends IService<EduTeacher> {

    void getTeacherByQueryCondition(Page<EduTeacher> teacherPage, TeacherQuery teacherQuery);
}
