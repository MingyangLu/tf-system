package com.alex.tfsystem.code.service;

import com.alex.tfsystem.code.bean.Code;
import com.alex.tfsystem.code.bean.CodeItem;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface ICodeService {

    List<CodeItem> getCodeListWithLock(Code code);

    List<CodeItem> getCodeList(Code code);
}
