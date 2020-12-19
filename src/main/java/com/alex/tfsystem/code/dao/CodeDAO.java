package com.alex.tfsystem.code.dao;


import com.alex.tfsystem.code.bean.Code;

import java.util.List;
import java.util.Map;

import com.alex.tfsystem.code.bean.CodeItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Mapper
public interface CodeDAO {

    List<CodeItem> getCodeList(Code code);
}
