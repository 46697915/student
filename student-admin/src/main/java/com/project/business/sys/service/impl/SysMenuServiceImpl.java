package com.project.business.sys.service.impl;

import com.project.business.sys.entity.SysMenu;
import com.project.business.sys.service.ISysMenuService;
import com.project.business.sys.mapper.SysMenuMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统功能表 服务实现类
 * </p>
 *
 * @author Mht
 * @since 2018-11-14
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Autowired
    private SysMenuMapper mapper;

    /**
     * 获取菜单
     * @param sysMenu
     * @return
     */
    public List selectBy(SysMenu sysMenu){
        List r = mapper.selectBy(sysMenu);

        return r ;
    }

    /**
     * 给菜单获取 列表 树形的
     * @param sysMenu
     * @return
     */
    public List listForMenu(SysMenu sysMenu){
        List r = mapper.selectBy(sysMenu);

        getTree(r);
        return r ;
    }
    public void getTree(List<SysMenu> list0) {

        if (list0.size() > 0) {
            for (SysMenu menu : list0) {
                //查询下级菜单
                SysMenu m = new SysMenu();
                m.setPcode(menu.getCode());
                List<SysMenu> list2 = mapper.selectBy(m);
                if (list2.size() == 0) {
                    continue;
                } else {
                    //存进当前的菜单下边
                    menu.setChildMenu(list2);
                    //继续获取下级菜单
                    this.getTree(list2);
                }
            }
        }
    }
}
