package com.itony.safetyedu.microservice.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itony.safetyedu.ctools.R;
import com.itony.safetyedu.microservice.entity.EduTeacher;
import com.itony.safetyedu.microservice.entity.query.TeacherQuery;
import com.itony.safetyedu.microservice.service.EduTeacherService;
import com.itony.safetyedu.microservice.serviceconfig.EduException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author Miracle
 * @since 2021-03-19
 */
@RestController
@RequestMapping("/microservice/edu-teacher")
public class EduTeacherController {
    @Autowired
    EduTeacherService eduTeacherService;

    @GetMapping
    public R getTeacherList()
    {
        final List<EduTeacher> list = eduTeacherService.list(null);

        return R.ok().data("items",list);
    }

    @DeleteMapping("{id}")
    public boolean DeleteById(@PathVariable String id)
    {
        return eduTeacherService.removeById(id);
    }

    //分布查询 page:表示页数 limit：表示每页记录数
    @GetMapping("pagelist/{page}/{limit}")
    public R getPageTeacherList(@PathVariable Integer page,@PathVariable Integer limit)
    {
        try {
            int x=9/0;
        }catch (Exception e)
        {
            throw new EduException(2000,"自定义异常");
        }
       /* finally {*/
            Page<EduTeacher> teacherPage=new Page<>(page,limit);
            eduTeacherService.page(teacherPage, null);
            final List<EduTeacher> records = teacherPage.getRecords();
            final long total = teacherPage.getTotal();
            return R.ok().data("total",total).data("items",records);
       /* }*/

    }

    //多条件组合查询并分页
    @PostMapping("multiConditionQuery/{page}/{limit}")
    public R getMultiConditionPageList(@PathVariable Integer page, @PathVariable Integer limit,
                                       @RequestBody(required = false) TeacherQuery teacherQuery)
    {
        Page<EduTeacher> teacherPage=new Page<>(page,limit);
        eduTeacherService.getTeacherByQueryCondition(teacherPage,teacherQuery);
        final List<EduTeacher> records = teacherPage.getRecords();
        final long total = teacherPage.getTotal();
        return R.ok().data("total",total).data("items",records);
    }

    @PostMapping("addTeacher")
    public R addTeacherInfo(@RequestBody EduTeacher eduTeacher)
    {
        final boolean save = eduTeacherService.save(eduTeacher);
        if (save)
        {
            return R.ok();
        }
        else
            return R.error();
    }
    @GetMapping("getInfo/{id}")
    public R getTeacherByID(@PathVariable String id)
    {
        final EduTeacher eduTeacher = eduTeacherService.getById(id);

        return R.ok().data("eduteach",eduTeacher);
    }

    @PostMapping("updateInfo/{id}")
    public R updateTeacherInfo(@PathVariable String id,@RequestBody EduTeacher teacher)
    {
        teacher.setId(id);
        final boolean b = eduTeacherService.updateById(teacher);
        if(!b)
            return R.error();
        return R.ok();
    }

}

