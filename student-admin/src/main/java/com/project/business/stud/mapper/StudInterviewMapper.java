package com.project.business.stud.mapper;

import com.project.business.stud.entity.StudInterview;
import com.project.business.stud.entity.StudInterviewVo;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Mht
 * @since 2018-11-20
 */
public interface StudInterviewMapper extends BaseMapper<StudInterview> {

    public List selectBy(StudInterviewVo vo);
}
