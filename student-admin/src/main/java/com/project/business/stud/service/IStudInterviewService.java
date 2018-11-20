package com.project.business.stud.service;

import com.project.business.stud.entity.StudInterview;
import com.project.business.stud.entity.StudInterviewVo;
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
public interface IStudInterviewService extends IService<StudInterview> {

    public List selectBy(StudInterviewVo vo);
}
