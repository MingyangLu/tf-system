package com.alex.tfsystem.common;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Optional;

public class BaseBean {

    private Date createtime;

    private Date updatetime;

    private Integer pageNum;

    private Integer pageSize;

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    //如果入参pageNum为空，赋默认值1
    public Integer getPageNum() {
        final int defaultPageNum = Optional.ofNullable(this.pageNum).orElse(1);
        return defaultPageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = Optional.ofNullable(pageNum).orElse(1);
    }

    //如果入参pageSize为空，赋默认值10
    public Integer getPageSize() {
        final int defaultPageSize = Optional.ofNullable(this.pageSize).orElse(10);
        return defaultPageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = Optional.ofNullable(pageSize).orElse(10);
    }
}
