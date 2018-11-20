package com.project.business.stud.mapper;

import com.project.business.stud.entity.StudLearn;
import com.project.business.stud.entity.StudLearnVo;
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
public interface StudLearnMapper extends BaseMapper<StudLearn> {

    public List selectBy(StudLearnVo vo);
}
