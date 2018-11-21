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
 * @since 2018-11-20
 */
@TableName("stud_review")
public class StudReview extends Model<StudReview> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("teacher_name")
    private String teacherName;

    @TableField("teacher_id")
    private Integer teacherId;

    @TableField("teacher_type")
    private String teacherType;

    @TableField("stud_id")
    private Integer studId;

    @TableField("stud_name")
    private String studName;

    @TableField("course_id")
    private String courseId;

    @TableField("course_name")
    private String courseName;

    @TableField("course_begin")
    private String courseBegin;

    @TableField("course_end")
    private String courseEnd;

    @TableField("skill_level")
    private String skillLevel;

    @TableField("gt_level")
    private String gtLevel;

    @TableField("review_score")
    private String reviewScore;

    @TableField("review_content")
    private String reviewContent;

    @TableField("review_date")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date reviewDate;

    @TableField("tj_fx")
    private String tjFx;

    @TableField("tj_com")
    private String tjCom;

    @TableField("tj_gw")
    private String tjGw;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
    public String getTeacherType() {
        return teacherType;
    }

    public void setTeacherType(String teacherType) {
        this.teacherType = teacherType;
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
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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
    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }
    public String getGtLevel() {
        return gtLevel;
    }

    public void setGtLevel(String gtLevel) {
        this.gtLevel = gtLevel;
    }
    public String getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(String reviewScore) {
        this.reviewScore = reviewScore;
    }
    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }
    @JsonFormat(pattern="yyyy-MM-dd")
    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }
    public String getTjFx() {
        return tjFx;
    }

    public void setTjFx(String tjFx) {
        this.tjFx = tjFx;
    }
    public String getTjCom() {
        return tjCom;
    }

    public void setTjCom(String tjCom) {
        this.tjCom = tjCom;
    }
    public String getTjGw() {
        return tjGw;
    }

    public void setTjGw(String tjGw) {
        this.tjGw = tjGw;
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
        return "StudReview{" +
        "id=" + id +
        ", teacherName=" + teacherName +
        ", teacherId=" + teacherId +
        ", teacherType=" + teacherType +
        ", studId=" + studId +
        ", studName=" + studName +
        ", courseId=" + courseId +
        ", courseName=" + courseName +
        ", courseBegin=" + courseBegin +
        ", courseEnd=" + courseEnd +
        ", skillLevel=" + skillLevel +
        ", gtLevel=" + gtLevel +
        ", reviewScore=" + reviewScore +
        ", reviewContent=" + reviewContent +
        ", reviewDate=" + reviewDate +
        ", tjFx=" + tjFx +
        ", tjCom=" + tjCom +
        ", tjGw=" + tjGw +
        ", remark=" + remark +
        "}";
    }
}
