package com.project.business.stud.service;

import com.project.business.stud.entity.StudReview;
import com.project.business.stud.entity.StudReviewVo;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Mht
 * @since 2018-11-20
 */
public interface IStudReviewService extends IService<StudReview> {

    public List selectBy(StudReviewVo vo);
}
