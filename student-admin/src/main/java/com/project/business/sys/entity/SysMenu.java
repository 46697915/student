package com.project.business.sys.entity;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 系统功能表
 * </p>
 *
 * @author Mht
 * @since 2018-11-14
 */
@TableName("sys_menu")
public class SysMenu extends Model<SysMenu> {

    private static final long serialVersionUID = 1L;

    /**
     * 系统功能CODE
     */
    @TableId(value = "code" )
    private String code;

    /**
     * 菜单排序号
     */
    private BigDecimal num;

    /**
     * 上级菜单code
     */
    private String pcode;

    /**
     * 上级菜单codes
     */
    private String pcodes;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单图标
     */
    private String icons;

    /**
     * url地址
     */
    private String url;

    /**
     * 菜单层级
     */
    private BigDecimal levels;

    /**
     * 是否是菜单（1：是  0：不是）
     */
    private String ismenu;

    /**
     * 菜单状态 :  1:启用   0:不启用
     */
    private String status;

    /**
     * 是否打开:    1:打开   0:不打开
     */
    private String isopen;

    /**
     * 操作人
     */
    private String handle;

    /**
     * 操作时间
     */
    @TableField("handle_date")
    private Date handleDate;

    /**
     * 备注
     */
    private String tips;

    //用来存储当前菜单的子菜单
    private List<SysMenu> childMenu;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }
    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }
    public String getPcodes() {
        return pcodes;
    }

    public void setPcodes(String pcodes) {
        this.pcodes = pcodes;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getIcons() {
        return icons;
    }

    public void setIcons(String icons) {
        this.icons = icons;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public BigDecimal getLevels() {
        return levels;
    }

    public void setLevels(BigDecimal levels) {
        this.levels = levels;
    }
    public String getIsmenu() {
        return ismenu;
    }

    public void setIsmenu(String ismenu) {
        this.ismenu = ismenu;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getIsopen() {
        return isopen;
    }

    public void setIsopen(String isopen) {
        this.isopen = isopen;
    }
    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }
    public Date getHandleDate() {
        return handleDate;
    }

    public void setHandleDate(Date handleDate) {
        this.handleDate = handleDate;
    }
    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    @Override
    protected Serializable pkVal() {
        return this.code;
    }

    public List<SysMenu> getChildMenu() {
        return childMenu;
    }

    public void setChildMenu(List<SysMenu> childMenu) {
        this.childMenu = childMenu;
    }

    @Override
    public String toString() {
        return "SysMenu{" +
        "code=" + code +
        ", num=" + num +
        ", pcode=" + pcode +
        ", pcodes=" + pcodes +
        ", name=" + name +
        ", icons=" + icons +
        ", url=" + url +
        ", levels=" + levels +
        ", ismenu=" + ismenu +
        ", status=" + status +
        ", isopen=" + isopen +
        ", handle=" + handle +
        ", handleDate=" + handleDate +
        ", tips=" + tips +
        "}";
    }
}
