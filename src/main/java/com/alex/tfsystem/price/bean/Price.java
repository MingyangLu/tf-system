package com.alex.tfsystem.price.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Component
@ApiModel("价格实体类")
public class Price implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "作业类型", required = true)
    private String jobtype;

    @ApiModelProperty(value = "是否紧急", required = true)
    private String isurgent;

    @ApiModelProperty(value = "年级", required = true)
    private String grade;

    @ApiModelProperty(value = "目标分数", required = true)
    private String target;

    @ApiModelProperty(value = "价格（人民币）")
    private String price_cny;

    @ApiModelProperty(value = "价格（英镑）")
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
