package com.project.business.stud.mapper;

import com.project.business.stud.entity.StudentInfo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.project.business.stud.entity.StudentInfoVo;
import com.project.business.sys.entity.SysMenu;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Mht
 * @since 2018-11-17
 */
public interface StudentInfoMapper extends BaseMapper<StudentInfo> {

    public List selectBy(StudentInfoVo stud);
}
