package com.project.business.stud.mapper;

import com.project.business.stud.entity.StudReview;
import com.project.business.stud.entity.StudReviewVo;
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
public interface StudReviewMapper extends BaseMapper<StudReview> {

    public List selectBy(StudReviewVo vo);
}
