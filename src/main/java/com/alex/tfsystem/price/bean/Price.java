package com.alex.tfsystem.price.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Component
public class Price implements Serializable {
    private static final long serialVersionUID = 1L;
    private String jobtype;
    private String isurgent;
    private String grade;
    private String target;
    private String price_cny;
    private String price_gbd;

    public String getJobtype() {
        return jobtype;
    }

    public void setJobtype(String jobtype) {
        this.jobtype = jobtype;
    }

    public String getIsurgent() {
        return isurgent;
    }

    public void setIsurgent(String isurgent) {
        this.isurgent = isurgent;
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

    public String getPrice_cny() {
        return price_cny;
    }

    public void setPrice_cny(String price_cny) {
        this.price_cny = price_cny;
    }

    public String getPrice_gbd() {
        return price_gbd;
    }

    public void setPrice_gbd(String price_gbd) {
        this.price_gbd = price_gbd;
    }
}
