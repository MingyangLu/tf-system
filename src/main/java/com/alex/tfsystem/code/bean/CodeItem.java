package com.alex.tfsystem.code.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
public class CodeItem  implements Serializable {
    private static final long serialVersionUID = 1L;
    private String index;
    private String label;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
