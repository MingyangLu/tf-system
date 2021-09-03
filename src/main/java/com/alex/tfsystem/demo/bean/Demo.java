package com.alex.tfsystem.demo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@ApiModel("demo")
public class Demo implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "demo", required = true)
    String properties;

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }
}
