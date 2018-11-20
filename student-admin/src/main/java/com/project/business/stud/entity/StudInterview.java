package com.project.business.stud.entity;

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
@TableName("stud_interview")
public class StudInterview extends Model<StudInterview> {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @TableField("stud_id")
    private Integer studId;

    @TableField("stud_name")
    private String studName;

    @TableField("com_name")
    private String comName;

    @TableField("com_xz")
    private String comXz;

    @TableField("com_adress")
    private String comAdress;

    @TableField("interview_gw")
    private String interviewGw;

    @TableField("com_gm")
    private String comGm;

    @TableField("zp_gm")
    private String zpGm;

    @TableField("interview_date")
    private String interviewDate;

    @TableField("interview_lc")
    private String interviewLc;

    @TableField("interview_comment")
    private String interviewComment;

    @TableField("link_mail")
    private String linkMail;

    @TableField("link_phone")
    private String linkPhone;

    @TableField("is_channel")
    private String isChannel;

    @TableField("channel_manager")
    private String channelManager;

    private String resume;

    @TableField("passing_difficulty")
    private String passingDifficulty;

    @TableField("is_recommend")
    private String isRecommend;

    @TableField("is_written")
    private String isWritten;

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
    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }
    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }
    public String getComXz() {
        return comXz;
    }

    public void setComXz(String comXz) {
        this.comXz = comXz;
    }
    public String getComAdress() {
        return comAdress;
    }

    public void setComAdress(String comAdress) {
        this.comAdress = comAdress;
    }
    public String getInterviewGw() {
        return interviewGw;
    }

    public void setInterviewGw(String interviewGw) {
        this.interviewGw = interviewGw;
    }
    public String getComGm() {
        return comGm;
    }

    public void setComGm(String comGm) {
        this.comGm = comGm;
    }
    public String getZpGm() {
        return zpGm;
    }

    public void setZpGm(String zpGm) {
        this.zpGm = zpGm;
    }
    public String getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(String interviewDate) {
        this.interviewDate = interviewDate;
    }
    public String getInterviewLc() {
        return interviewLc;
    }

    public void setInterviewLc(String interviewLc) {
        this.interviewLc = interviewLc;
    }
    public String getInterviewComment() {
        return interviewComment;
    }

    public void setInterviewComment(String interviewComment) {
        this.interviewComment = interviewComment;
    }
    public String getLinkMail() {
        return linkMail;
    }

    public void setLinkMail(String linkMail) {
        this.linkMail = linkMail;
    }
    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }
    public String getIsChannel() {
        return isChannel;
    }

    public void setIsChannel(String isChannel) {
        this.isChannel = isChannel;
    }
    public String getChannelManager() {
        return channelManager;
    }

    public void setChannelManager(String channelManager) {
        this.channelManager = channelManager;
    }
    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
    public String getPassingDifficulty() {
        return passingDifficulty;
    }

    public void setPassingDifficulty(String passingDifficulty) {
        this.passingDifficulty = passingDifficulty;
    }
    public String getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(String isRecommend) {
        this.isRecommend = isRecommend;
    }
    public String getIsWritten() {
        return isWritten;
    }

    public void setIsWritten(String isWritten) {
        this.isWritten = isWritten;
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
        return "StudInterview{" +
        "id=" + id +
        ", studId=" + studId +
        ", studName=" + studName +
        ", comName=" + comName +
        ", comXz=" + comXz +
        ", comAdress=" + comAdress +
        ", interviewGw=" + interviewGw +
        ", comGm=" + comGm +
        ", zpGm=" + zpGm +
        ", interviewDate=" + interviewDate +
        ", interviewLc=" + interviewLc +
        ", interviewComment=" + interviewComment +
        ", linkMail=" + linkMail +
        ", linkPhone=" + linkPhone +
        ", isChannel=" + isChannel +
        ", channelManager=" + channelManager +
        ", resume=" + resume +
        ", passingDifficulty=" + passingDifficulty +
        ", isRecommend=" + isRecommend +
        ", isWritten=" + isWritten +
        ", remark=" + remark +
        "}";
    }
}
