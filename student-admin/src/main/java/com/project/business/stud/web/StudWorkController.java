package com.project.business.stud.web;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.business.stud.entity.StudWork;
import com.project.business.stud.entity.StudWorkVo;
import com.project.business.stud.entity.StudentInfoVo;
import com.project.business.stud.service.IStudWorkService;
import com.project.business.stud.service.IStudentInfoService;
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
@RequestMapping("/studWork")
public class StudWorkController {

    @Autowired
    private IStudWorkService service;

    /**
     * 查询列表数据
     * @param vo
     * @return
     */
    @RequestMapping("/list")
    public ResponseResult list(StudWorkVo vo){
        List r = service.selectBy(vo);
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
    public ResponseResult listForPage(PageElementUI pe, StudWorkVo vo){
        PageHelper.startPage(pe.getPageNO(),pe.getPageSize());
        List r = service.selectBy(vo);

        //获取分页信息
        PageInfo<StudWorkVo> pi = new PageInfo<StudWorkVo>(r);

        Map<String, Object> rMap = new HashMap<String,Object>();
        rMap.put("total",pi.getTotal());
        rMap.put("list",pi.getList());

        ResponseResult rr = ResponseResult.getResponseResult();
        rr.setResult(rMap);
        return rr;
    }

    @RequestMapping("/add")
    public ResponseResult add(StudWorkVo vo){
        boolean r = service.insert(vo);
        ResponseResult rr = ResponseResult.getResponseResult();
        rr.setResult(r);
        return rr ;
    }
    @RequestMapping("/edit")
    public ResponseResult edit(StudWorkVo studWorkVo){
        boolean r = service.updateById(studWorkVo);
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
