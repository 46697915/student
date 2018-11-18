package com.project.business.sys.web;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.comment.PageElementUI;
import com.project.comment.ResponseResult;
import com.project.business.sys.entity.SysMenu;
import com.project.business.sys.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统功能表 前端控制器
 * </p>
 *
 * @author Mht
 * @since 2018-11-14
 */
@RestController
@RequestMapping("/sysMenu")
public class SysMenuController {

    @Autowired
    private ISysMenuService service;

    /**
     * 查询列表数据
     * @param sysMenu
     * @return
     */
    @RequestMapping("/list")
    public ResponseResult list(SysMenu sysMenu){
        List r = service.selectBy(sysMenu);
        ResponseResult rr = ResponseResult.getResponseResult();
        rr.setResult(r);
        return rr ;
    }
    /**
     * 菜单列表分页
     * @param request
     * @return
     */
    @RequestMapping("/listForPage")
    public ResponseResult listForPage(PageElementUI pe,SysMenu sysMenu){
        PageHelper.startPage(pe.getPageNO(),pe.getPageSize());
        List r = service.selectBy(sysMenu);

        //获取分页信息
        PageInfo<SysMenu> pi = new PageInfo<SysMenu>(r);

        Map<String, Object> rMap = new HashMap<String,Object>();
        rMap.put("total",pi.getTotal());
        rMap.put("list",pi.getList());

        ResponseResult rr = ResponseResult.getResponseResult();
        rr.setResult(rMap);
        return rr;
    }

    /**
     * 给页面左侧菜单树查询数据
     * @param sysMenu
     * @return
     */
    @RequestMapping("/listForMenu")
    public ResponseResult listForMenu(SysMenu sysMenu){
        sysMenu.setPcode("0");
        List r = service.listForMenu(sysMenu);
        ResponseResult rr = ResponseResult.getResponseResult();
        rr.setResult(r);
        return rr ;
    }

    @RequestMapping("/add")
    public ResponseResult add(SysMenu sysMenu){
        boolean r = service.insert(sysMenu);
        ResponseResult rr = ResponseResult.getResponseResult();
        rr.setResult(r);
        return rr ;
    }
    @RequestMapping("/edit")
    public ResponseResult edit(SysMenu sysMenu){
        boolean r = service.updateById(sysMenu);
        ResponseResult rr = ResponseResult.getResponseResult();
        rr.setResult(r);
        return rr ;
    }

    @RequestMapping("delete")
    public ResponseResult delete(HttpServletRequest request,
                                       String code) {
        boolean r = service.deleteById(code);

        ResponseResult rr = ResponseResult.getResponseResult();
        rr.setResult(r);
        return rr;
    }
    @RequestMapping("deleteBatch")
    public ResponseResult deleteBatch(HttpServletRequest request,
                                            String ids[]) {
        boolean r = service.deleteBatchIds(Arrays.asList(ids));

        ResponseResult rr = ResponseResult.getResponseResult();
        rr.setResult(r);
        return rr;
    }
}
