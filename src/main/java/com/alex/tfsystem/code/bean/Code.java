package com.alex.tfsystem.code.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
@Component
public class Code  implements Serializable {
    private static final long serialVersionUID = 1L;
    private String codeId;
    private String codeName;
    private List<Map<String,String>> codeList;

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public List<Map<String, String>> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<Map<String, String>> codeList) {
        this.codeList = codeList;
    }
}
