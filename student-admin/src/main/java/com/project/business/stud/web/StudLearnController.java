package com.project.business.stud.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.project.business.stud.service.IStudLearnService;
import com.project.business.stud.entity.StudLearnVo;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.comment.PageElementUI;
import com.project.comment.ResponseResult;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Mht
 * @since 2018-11-20
 */
@RestController
@RequestMapping("/studLearn")
public class StudLearnController {

    @Autowired
    private IStudLearnService service;

    /**
    * 查询列表数据
    * @param vo
    * @return
    */
    @RequestMapping("/list")
    public ResponseResult list(StudLearnVo vo){
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
    public ResponseResult listForPage(PageElementUI pe, StudLearnVo vo){
        PageHelper.startPage(pe.getPageNO(),pe.getPageSize());
        List r = service.selectBy(vo);

        //获取分页信息
        PageInfo<StudLearnVo> pi = new PageInfo<StudLearnVo>(r);

        Map<String, Object> rMap = new HashMap<String,Object>();
        rMap.put("total",pi.getTotal());
        rMap.put("list",pi.getList());

        ResponseResult rr = ResponseResult.getResponseResult();
        rr.setResult(rMap);
        return rr;
    }

    @RequestMapping("/add")
    public ResponseResult add(StudLearnVo vo){
        boolean r = service.insert(vo);
        ResponseResult rr = ResponseResult.getResponseResult();
        rr.setResult(r);
        return rr ;
    }
    @RequestMapping("/edit")
    public ResponseResult edit(StudLearnVo vo){
        boolean r = service.updateById(vo);
        ResponseResult rr = ResponseResult.getResponseResult();
        rr.setResult(r);
        return rr ;
    }

    @RequestMapping("delete")
    public ResponseResult delete(HttpServletRequest request, String id) {
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
