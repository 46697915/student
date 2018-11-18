package com.project.business.sys.mapper;

import com.project.business.sys.entity.SysMenu;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 系统功能表 Mapper 接口
 * </p>
 *
 * @author Mht
 * @since 2018-11-14
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    public List selectBy(SysMenu sysMenu);
}
