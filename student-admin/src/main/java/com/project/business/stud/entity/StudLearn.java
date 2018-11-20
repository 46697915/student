package com.project.business.stud.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Mht
 * @since 2018-11-20
 */
@TableName("stud_learn")
public class StudLearn extends Model<StudLearn> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("stud_id")
    private Integer studId;

    @TableField("stud_code")
    private String studCode;

    @TableField("stud_name")
    private String studName;

    @TableField("course_id")
    private Integer courseId;

    @TableField("course_name")
    private String courseName;

    @TableField("teacher_id")
    private Integer teacherId;

    @TableField("teacher_name")
    private String teacherName;

    @TableField("teacher2_id")
    private Integer teacher2Id;

    @TableField("teacher2_name")
    private String teacher2Name;

    @TableField("teacher3_id")
    private Integer teacher3Id;

    @TableField("teacher3_name")
    private String teacher3Name;

    @TableField("course_begin")
    private String courseBegin;

    @TableField("course_end")
    private String courseEnd;

    @TableField("ll_course")
    private String llCourse;

    @TableField("jn_course")
    private String jnCourse;

    @TableField("mb_conut")
    private String mbConut;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getStudId() {
        return studId;
    }

    public void setStudId(Integer studId) {
        this.studId = studId;
    }
    public String getStudCode() {
        return studCode;
    }

    public void setStudCode(String studCode) {
        this.studCode = studCode;
    }
    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    public Integer getTeacher2Id() {
        return teacher2Id;
    }

    public void setTeacher2Id(Integer teacher2Id) {
        this.teacher2Id = teacher2Id;
    }
    public String getTeacher2Name() {
        return teacher2Name;
    }

    public void setTeacher2Name(String teacher2Name) {
        this.teacher2Name = teacher2Name;
    }
    public Integer getTeacher3Id() {
        return teacher3Id;
    }

    public void setTeacher3Id(Integer teacher3Id) {
        this.teacher3Id = teacher3Id;
    }
    public String getTeacher3Name() {
        return teacher3Name;
    }

    public void setTeacher3Name(String teacher3Name) {
        this.teacher3Name = teacher3Name;
    }
    public String getCourseBegin() {
        return courseBegin;
    }

    public void setCourseBegin(String courseBegin) {
        this.courseBegin = courseBegin;
    }
    public String getCourseEnd() {
        return courseEnd;
    }

    public void setCourseEnd(String courseEnd) {
        this.courseEnd = courseEnd;
    }
    public String getLlCourse() {
        return llCourse;
    }

    public void setLlCourse(String llCourse) {
        this.llCourse = llCourse;
    }
    public String getJnCourse() {
        return jnCourse;
    }

    public void setJnCourse(String jnCourse) {
        this.jnCourse = jnCourse;
    }
    public String getMbConut() {
        return mbConut;
    }

    public void setMbConut(String mbConut) {
        this.mbConut = mbConut;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "StudLearn{" +
        "id=" + id +
        ", studId=" + studId +
        ", studCode=" + studCode +
        ", studName=" + studName +
        ", courseId=" + courseId +
        ", courseName=" + courseName +
        ", teacherId=" + teacherId +
        ", teacherName=" + teacherName +
        ", teacher2Id=" + teacher2Id +
        ", teacher2Name=" + teacher2Name +
        ", teacher3Id=" + teacher3Id +
        ", teacher3Name=" + teacher3Name +
        ", courseBegin=" + courseBegin +
        ", courseEnd=" + courseEnd +
        ", llCourse=" + llCourse +
        ", jnCourse=" + jnCourse +
        ", mbConut=" + mbConut +
        ", remark=" + remark +
        "}";
    }
}
