package com.example.winter_vacation_checkin.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 
 * @TableName la_award
 */
@TableName(value ="la_award")
@Data
public class LaAward {
    /**
     * 
     */
    @TableId
    private Long id;

    /**
     * 奖品名称
     */
    private String name;

    /**
     * 图片
     */
    private String photo;

    /**
     * 奖品类型：1勋章2奖品3会员
     */
    private String type;

    /**
     * 权益名称
     */
    private String rightsName;
    /**
     * 数量
     */
    private Integer num;

    /**
     * 是否限制人数：0限制1不限制
     */
    private Integer isLimit;

    /**
     * 状态：1启用2禁用
     */
    private Integer status;

    /**
     * 活动id
     */
    private Long activityId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 更新人
     */
    private Long updateUser;

    /**
     * 是否删除：0未删除 1已删除
     */
    private Integer isDelete;

    /**
     * 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 奖品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 奖品名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 图片
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * 图片
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * 奖品类型：1勋章2奖品3会员
     */
    public String getType() {
        return type;
    }

    /**
     * 奖品类型：1勋章2奖品3会员
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 数量
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 数量
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 是否限制人数：0限制1不限制
     */
    public Integer getIsLimit() {
        return isLimit;
    }

    /**
     * 是否限制人数：0限制1不限制
     */
    public void setIsLimit(Integer isLimit) {
        this.isLimit = isLimit;
    }

    /**
     * 状态：1启用2禁用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态：1启用2禁用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 活动id
     */
    public Long getActivityId() {
        return activityId;
    }

    /**
     * 活动id
     */
    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 创建人
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * 创建人
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * 更新人
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * 更新人
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 是否删除：0未删除 1已删除
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 是否删除：0未删除 1已删除
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        LaAward other = (LaAward) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPhoto() == null ? other.getPhoto() == null : this.getPhoto().equals(other.getPhoto()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
            && (this.getIsLimit() == null ? other.getIsLimit() == null : this.getIsLimit().equals(other.getIsLimit()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getActivityId() == null ? other.getActivityId() == null : this.getActivityId().equals(other.getActivityId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPhoto() == null) ? 0 : getPhoto().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        result = prime * result + ((getIsLimit() == null) ? 0 : getIsLimit().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getActivityId() == null) ? 0 : getActivityId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", photo=").append(photo);
        sb.append(", type=").append(type);
        sb.append(", num=").append(num);
        sb.append(", isLimit=").append(isLimit);
        sb.append(", status=").append(status);
        sb.append(", activityId=").append(activityId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", isDelete=").append(isDelete);
        sb.append("]");
        return sb.toString();
    }
}