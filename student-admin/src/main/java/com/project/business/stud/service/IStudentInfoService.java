package com.project.business.stud.service;

import com.project.business.stud.entity.StudentInfo;
import com.baomidou.mybatisplus.service.IService;
import com.project.business.stud.entity.StudentInfoVo;
import com.project.business.sys.entity.SysMenu;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Mht
 * @since 2018-11-17
 */
public interface IStudentInfoService extends IService<StudentInfo> {

    public List selectBy(StudentInfoVo sysMenu);
}
