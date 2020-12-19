package com.alex.tfsystem.code.service.impl;


import com.alex.tfsystem.code.bean.Code;
import com.alex.tfsystem.code.bean.CodeItem;
import com.alex.tfsystem.code.dao.CodeDAO;
import com.alex.tfsystem.code.service.ICodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service("codeService")
public class CodeServiceImpl implements ICodeService {

    @Resource
    private CodeDAO codeDAO;

    @Transactional(readOnly = true)
    @Override
    public List<CodeItem> getCodeList(Code code) {
        try{
            List<CodeItem> codeList = codeDAO.getCodeList(code);
            return codeList;
//            return null;
        }catch (Exception e){
            throw e;
        }
    }
}
