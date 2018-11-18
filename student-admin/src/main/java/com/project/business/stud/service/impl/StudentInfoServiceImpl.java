package com.project.business.stud.service.impl;

import com.project.business.stud.entity.StudentInfo;
import com.project.business.stud.entity.StudentInfoVo;
import com.project.business.stud.mapper.StudentInfoMapper;
import com.project.business.stud.service.IStudentInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.project.business.sys.entity.SysMenu;
import com.project.business.sys.mapper.SysMenuMapper;
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
public class StudentInfoServiceImpl extends ServiceImpl<StudentInfoMapper, StudentInfo> implements IStudentInfoService {

    @Autowired
    private StudentInfoMapper mapper;

    /**
     * 获取菜单
     * @param stud
     * @return
     */
    public List selectBy(StudentInfoVo stud){
        List r = mapper.selectBy(stud);

        return r ;
    }

}
