package com.project.business.stud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.project.business.stud.entity.StudReview;
import com.project.business.stud.entity.StudReviewVo;
import com.project.business.stud.mapper.StudReviewMapper;
import com.project.business.stud.service.IStudReviewService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Mht
 * @since 2018-11-20
 */
@Service
public class StudReviewServiceImpl extends ServiceImpl<StudReviewMapper, StudReview> implements IStudReviewService {

    @Autowired
    private StudReviewMapper mapper;

    /**
    *
    * @param vo
    * @return
    */
    public List selectBy(StudReviewVo vo){
        List r = mapper.selectBy(vo);

        return r ;
    }

}
