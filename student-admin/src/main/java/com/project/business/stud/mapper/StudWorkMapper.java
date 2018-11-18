package com.project.business.stud.mapper;

import com.project.business.stud.entity.StudWork;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.project.business.stud.entity.StudWorkVo;
import com.project.business.stud.entity.StudentInfoVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Mht
 * @since 2018-11-17
 */
public interface StudWorkMapper extends BaseMapper<StudWork> {

    public List selectBy(StudWorkVo vo);
}
