package com.project.business.stud.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

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
@TableName("student_info")
public class StudentInfoVo extends StudentInfo {

    private String inschoolbegin ;

    private String inschoolend;

    public String getInschoolbegin() {
        return inschoolbegin;
    }

    public void setInschoolbegin(String inschoolbegin) {
        this.inschoolbegin = inschoolbegin;
    }

    public String getInschoolend() {
        return inschoolend;
    }

    public void setInschoolend(String inschoolend) {
        this.inschoolend = inschoolend;
    }

    @Override
    public String toString() {
        return "StudentInfoVo{" +
                "inschoolbegin='" + inschoolbegin + '\'' +
                ", inschoolend='" + inschoolend + '\'' +
                '}';
    }
}
