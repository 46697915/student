package com.project.business.stud.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Mht
 * @since 2018-11-17
 */
@TableName("stud_work")
public class StudWork extends Model<StudWork> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("com_name")
    private String comName;

    @TableField("com_address")
    private String comAddress;

    @TableField("work_content")
    private String workContent;

    @TableField("in_date")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date inDate;

    @TableField("out_date")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date outDate;

    @TableField("link_man")
    private String linkMan;

    @TableField("com_city")
    private String comCity;

    @TableField("work_xz")
    private String workXz;

    @TableField("work_sshy")
    private String workSshy;

    private String remarks;

    private String operator;

    private Date operatedate;

    @TableField("stud_id")
    private Integer studId;

    @TableField("stud_name")
    private String studName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }
    public String getComAddress() {
        return comAddress;
    }

    public void setComAddress(String comAddress) {
        this.comAddress = comAddress;
    }
    public String getWorkContent() {
        return workContent;
    }

    public void setWorkContent(String workContent) {
        this.workContent = workContent;
    }
    @JsonFormat(pattern="yyyy-MM-dd")
    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }
    @JsonFormat(pattern="yyyy-MM-dd")
    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }
    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }
    public String getComCity() {
        return comCity;
    }

    public void setComCity(String comCity) {
        this.comCity = comCity;
    }
    public String getWorkXz() {
        return workXz;
    }

    public void setWorkXz(String workXz) {
        this.workXz = workXz;
    }
    public String getWorkSshy() {
        return workSshy;
    }

    public void setWorkSshy(String workSshy) {
        this.workSshy = workSshy;
    }
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getOperatedate() {
        return operatedate;
    }

    public void setOperatedate(Date operatedate) {
        this.operatedate = operatedate;
    }
    public Integer getStudId() {
        return studId;
    }

    public void setStudId(Integer studId) {
        this.studId = studId;
    }
    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "StudWork{" +
        "id=" + id +
        ", comName=" + comName +
        ", comAddress=" + comAddress +
        ", workContent=" + workContent +
        ", inDate=" + inDate +
        ", outDate=" + outDate +
        ", linkMan=" + linkMan +
        ", comCity=" + comCity +
        ", workXz=" + workXz +
        ", workSshy=" + workSshy +
        ", remarks=" + remarks +
        ", operator=" + operator +
        ", operatedate=" + operatedate +
        ", studId=" + studId +
        ", studName=" + studName +
        "}";
    }
}
