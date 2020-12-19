package com.alex.tfsystem.code.service;

import com.alex.tfsystem.code.bean.Code;
import com.alex.tfsystem.code.bean.CodeItem;

import java.util.List;
import java.util.Map;

public interface ICodeService {

    List<CodeItem> getCodeList(Code code);
}
