package com.project.business.stud.service.impl;

import com.project.business.stud.entity.StudWork;
import com.project.business.stud.entity.StudWorkVo;
import com.project.business.stud.entity.StudentInfoVo;
import com.project.business.stud.mapper.StudWorkMapper;
import com.project.business.stud.mapper.StudentInfoMapper;
import com.project.business.stud.service.IStudWorkService;
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
 * @since 2018-11-17
 */
@Service
public class StudWorkServiceImpl extends ServiceImpl<StudWorkMapper, StudWork> implements IStudWorkService {

    @Autowired
    private StudWorkMapper mapper;

    /**
     * 获取菜单
     * @param vo
     * @return
     */
    public List selectBy(StudWorkVo vo){
        List r = mapper.selectBy(vo);

        return r ;
    }

}
