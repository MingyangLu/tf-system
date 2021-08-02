package com.alex.tfsystem.code.service.impl;


import com.alex.tfsystem.code.bean.Code;
import com.alex.tfsystem.code.bean.CodeItem;
import com.alex.tfsystem.code.dao.CodeDAO;
import com.alex.tfsystem.code.service.ICodeService;
import com.alex.tfsystem.common.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Transactional
@Service("codeService")
public class CodeServiceImpl implements ICodeService {

    @Resource
    private CodeDAO codeDAO;

    @Resource
    private RedisUtil redisUtil;

    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    @Transactional(readOnly = true)
    @Override
    public List<CodeItem> getCodeListWithLock(Code code) {
        List<CodeItem> codeList = null;
        //开启读锁，从redis缓存中读取codeList
        readWriteLock.readLock().lock();
        try{
            if(redisUtil.hasKey(code.getCodeName())){
                codeList = (List<CodeItem>) redisUtil.get(code.getCodeName());
            }else {
                //释放读锁，以免写入redis的线程被阻塞造成死锁
                readWriteLock.readLock().unlock();
                //开启写锁，从数据库中读取数据
                readWriteLock.writeLock().lock();
                //防止其他线程已写入的情况下重复处理
                try{
                    if(redisUtil.hasKey(code.getCodeName())){
                        codeList = (List<CodeItem>) redisUtil.get(code.getCodeName());
                    } else {
                        codeList = codeDAO.getCodeList(code);
                        redisUtil.set(code.getCodeName(),codeList,60);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    //判断写锁是否存在，对不存在的锁解锁会造成异常
                    if(readWriteLock.writeLock().isHeldByCurrentThread())
                        readWriteLock.writeLock().unlock();
                    //写完Redis缓存后，恢复读锁状态
                    readWriteLock.readLock().lock();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();
        }
        return codeList;
    }

    @Transactional(readOnly = true)
    @Override
    public List<CodeItem> getCodeList(Code code) {
        List<CodeItem> codeList = null;
        if(redisUtil.hasKey(code.getCodeName())){
            codeList = (List<CodeItem>) redisUtil.get(code.getCodeName());
        } else {
            codeList = codeDAO.getCodeList(code);
            redisUtil.set(code.getCodeName(),codeList,60);
        }
        return codeList;
    }
}
