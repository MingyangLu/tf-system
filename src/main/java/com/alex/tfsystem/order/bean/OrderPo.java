package com.alex.tfsystem.order.bean;

import com.alex.tfsystem.common.BaseBean;
import com.alex.tfsystem.common.BasePo;

import java.util.List;

public class OrderPo extends BasePo {

    private static final long serialVersionUID = 1L;
    // 订单流水号
    private Integer busino;
    // 用户姓名
    private String custname;
    // 订单状态 00-订单已关闭 01-订单已保存 02-订单已提交 03-订单进行中
    private String procstate;
    // 紧急程度
    private String isurgent;
    private String email;
    private String wechatno;
    private String jobtype;
    private String grade;
    private String target;
    private String deadline;
    private List<String> deadlineRange;
    private String deadlineRangeStart;
    private String deadlineRangeEnd;
    private Integer wordcount;
    private Integer wordCountRangeStart;
    private Integer wordCountRangeEnd;
    public Integer getBusino() {
        return busino;
    }

    public void setBusino(Integer busino) {
        this.busino = busino;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getProcstate() {
        return procstate;
    }

    public void setProcstate(String procstate) {
        this.procstate = procstate;
    }

    public String getIsurgent() {
        return isurgent;
    }

    public void setIsurgent(String isurgent) {
        this.isurgent = isurgent;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWechatno() {
        return wechatno;
    }

    public void setWechatno(String wechatno) {
        this.wechatno = wechatno;
    }

    public String getJobtype() {
        return jobtype;
    }

    public void setJobtype(String jobtype) {
        this.jobtype = jobtype;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public List<String> getDeadlineRange() {
        return deadlineRange;
    }

    public void setDeadlineRange(List<String> deadlineRange) {
        this.deadlineRange = deadlineRange;
    }

    public String getDeadlineRangeStart() {
        return deadlineRangeStart;
    }

    public void setDeadlineRangeStart(String deadlineRangeStart) {
        this.deadlineRangeStart = deadlineRangeStart;
    }

    public String getDeadlineRangeEnd() {
        return deadlineRangeEnd;
    }

    public void setDeadlineRangeEnd(String deadlineRangeEnd) {
        this.deadlineRangeEnd = deadlineRangeEnd;
    }

    public Integer getWordcount() {
        return wordcount;
    }

    public void setWordcount(Integer wordcount) {
        this.wordcount = wordcount;
    }

    public Integer getWordCountRangeStart() {
        return wordCountRangeStart;
    }

    public void setWordCountRangeStart(Integer wordCountRangeStart) {
        this.wordCountRangeStart = wordCountRangeStart;
    }

    public Integer getWordCountRangeEnd() {
        return wordCountRangeEnd;
    }

    public void setWordCountRangeEnd(Integer wordCountRangeEnd) {
        this.wordCountRangeEnd = wordCountRangeEnd;
    }

}
