package com.project.business.stud.service;

import com.project.business.stud.entity.StudLearn;
import com.project.business.stud.entity.StudLearnVo;
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
public interface IStudLearnService extends IService<StudLearn> {

    public List selectBy(StudLearnVo vo);
}
