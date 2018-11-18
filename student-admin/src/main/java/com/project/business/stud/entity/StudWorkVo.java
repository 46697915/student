package com.project.business.stud.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Mht
 * @since 2018-11-17
 */
@TableName("stud_work")
public class StudWorkVo extends StudWork {

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date inDateBegin;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date inDateEnd;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date outDateBegin;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date outDateEnd;

    public Date getInDateBegin() {
        return inDateBegin;
    }

    public void setInDateBegin(Date inDateBegin) {
        this.inDateBegin = inDateBegin;
    }

    public Date getInDateEnd() {
        return inDateEnd;
    }

    public void setInDateEnd(Date inDateEnd) {
        this.inDateEnd = inDateEnd;
    }

    public Date getOutDateBegin() {
        return outDateBegin;
    }

    public void setOutDateBegin(Date outDateBegin) {
        this.outDateBegin = outDateBegin;
    }

    public Date getOutDateEnd() {
        return outDateEnd;
    }

    public void setOutDateEnd(Date outDateEnd) {
        this.outDateEnd = outDateEnd;
    }
}
