package com.project.business.stud.service;

import com.project.business.stud.entity.StudWork;
import com.baomidou.mybatisplus.service.IService;
import com.project.business.stud.entity.StudWorkVo;
import com.project.business.stud.entity.StudentInfoVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Mht
 * @since 2018-11-17
 */
public interface IStudWorkService extends IService<StudWork> {

    public List selectBy(StudWorkVo vo);
}
