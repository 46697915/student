package com.project.business.stud.web;


import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.business.stud.entity.StudentInfoVo;
import com.project.business.stud.service.IStudentInfoService;
import com.project.business.sys.entity.SysMenu;
import com.project.business.sys.service.ISysMenuService;
import com.project.comment.PageElementUI;
import com.project.comment.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Mht
 * @since 2018-11-17
 */
@RestController
@RequestMapping("/studentInfo")
public class StudentInfoController {

    @Autowired
    private IStudentInfoService service;

    /**
     * 查询列表数据
     * @param sysMenu
     * @return
     */
    @RequestMapping("/list")
    public ResponseResult list(StudentInfoVo StudentInfoVo){
        List r = service.selectBy(StudentInfoVo);
        ResponseResult rr = ResponseResult.getResponseResult();
        rr.setResult(r);
        return rr ;
    }
    /**
     * 菜单列表分页
     * @param
     * @return
     */
    @RequestMapping("/listForPage")
    public ResponseResult listForPage(PageElementUI pe, StudentInfoVo StudentInfoVo){
        PageHelper.startPage(pe.getPageNO(),pe.getPageSize());
        List r = service.selectBy(StudentInfoVo);

        //获取分页信息
        PageInfo<StudentInfoVo> pi = new PageInfo<StudentInfoVo>(r);

        Map<String, Object> rMap = new HashMap<String,Object>();
        rMap.put("total",pi.getTotal());
        rMap.put("list",pi.getList());

        ResponseResult rr = ResponseResult.getResponseResult();
        rr.setResult(rMap);
        return rr;
    }

    @RequestMapping("/add")
    public ResponseResult add(StudentInfoVo StudentInfoVo){
        boolean r = service.insert(StudentInfoVo);
        ResponseResult rr = ResponseResult.getResponseResult();
        rr.setResult(r);
        return rr ;
    }
    @RequestMapping("/edit")
    public ResponseResult edit(StudentInfoVo StudentInfoVo){
        boolean r = service.updateById(StudentInfoVo);
        ResponseResult rr = ResponseResult.getResponseResult();
        rr.setResult(r);
        return rr ;
    }

    @RequestMapping("delete")
    public ResponseResult delete(HttpServletRequest request,
                                 String id) {
        boolean r = service.deleteById(id);

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
