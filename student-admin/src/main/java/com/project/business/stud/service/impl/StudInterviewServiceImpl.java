package com.project.business.stud.service.impl;

import com.project.business.stud.entity.StudInterview;
import com.project.business.stud.entity.StudInterviewVo;
import com.project.business.stud.mapper.StudInterviewMapper;
import com.project.business.stud.service.IStudInterviewService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

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
public class StudInterviewServiceImpl extends ServiceImpl<StudInterviewMapper, StudInterview> implements IStudInterviewService {

    @Autowired
    private StudInterviewMapper mapper;

    /**
    *
    * @param vo
    * @return
    */
    public List selectBy(StudInterviewVo vo){
        List r = mapper.selectBy(vo);

        return r ;
    }

}
