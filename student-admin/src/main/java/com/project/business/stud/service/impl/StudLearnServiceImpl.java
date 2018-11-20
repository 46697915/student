package com.project.business.stud.service.impl;

import com.project.business.stud.entity.StudLearn;
import com.project.business.stud.entity.StudLearnVo;
import com.project.business.stud.mapper.StudLearnMapper;
import com.project.business.stud.service.IStudLearnService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class StudLearnServiceImpl extends ServiceImpl<StudLearnMapper, StudLearn> implements IStudLearnService {

    @Autowired
    private StudLearnMapper mapper;

    /**
    *
    * @param vo
    * @return
    */
    public List selectBy(StudLearnVo vo){
        List r = mapper.selectBy(vo);

        return r ;
    }

}
