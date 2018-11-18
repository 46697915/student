package com.project.business.sys.service;

import com.project.business.sys.entity.SysMenu;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 系统功能表 服务类
 * </p>
 *
 * @author Mht
 * @since 2018-11-14
 */
public interface ISysMenuService extends IService<SysMenu> {

    public List selectBy(SysMenu sysMenu);
    public List listForMenu(SysMenu sysMenu);
}
