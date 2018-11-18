package com.project.business.stud.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Mht
 * @since 2018-11-17
 */
@TableName("student_info")
public class StudentInfo extends Model<StudentInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String code;

    private String name;

    private String ic;

    private String sex;

    private String birthday;

    private String xueli;

    private String email;

    private String hunfou;

    private String address;

    private String inschool;

    private String shichangbu;

    private String remarks;

    private String operator;

    private Date operatedate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getXueli() {
        return xueli;
    }

    public void setXueli(String xueli) {
        this.xueli = xueli;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getHunfou() {
        return hunfou;
    }

    public void setHunfou(String hunfou) {
        this.hunfou = hunfou;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getInschool() {
        return inschool;
    }

    public void setInschool(String inschool) {
        this.inschool = inschool;
    }
    public String getShichangbu() {
        return shichangbu;
    }

    public void setShichangbu(String shichangbu) {
        this.shichangbu = shichangbu;
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
    public Date getOperatedate() {
        return operatedate;
    }

    public void setOperatedate(Date operatedate) {
        this.operatedate = operatedate;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
        "id=" + id +
        ", code=" + code +
        ", name=" + name +
        ", ic=" + ic +
        ", sex=" + sex +
        ", xueli=" + xueli +
        ", email=" + email +
        ", hunfou=" + hunfou +
        ", address=" + address +
        ", inschool=" + inschool +
        ", shichangbu=" + shichangbu +
        ", remarks=" + remarks +
        ", operator=" + operator +
        ", operatedate=" + operatedate +
        "}";
    }
}
