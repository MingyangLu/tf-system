package com.alex.tfsystem.common;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.alex.tfsystem.code.bean.Code;
import com.alex.tfsystem.code.bean.CodeItem;
import com.alex.tfsystem.code.service.ICodeService;
import com.alex.tfsystem.code.service.impl.CodeServiceImpl;
import com.alex.tfsystem.order.bean.Order;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
@Component
public class MsgFactory {


    @Autowired
    private ICodeService codeService;

    public static MsgFactory msgFactory;

    @PostConstruct
    public void init() {
        msgFactory = this;
        msgFactory.codeService = this.codeService;
    }

    public String sendMsgToStaff(Order order) throws IOException {

        //获取作业类型码值表
        Code code = new Code();
        code.setCodeName("jobtype");
        List<CodeItem> jobtypeList = msgFactory.codeService.getCodeList(code);
        String jobtype = "未知";
        for (CodeItem codeItem : jobtypeList){
            if(codeItem.getIndex().equals(order.getJobtype())){
                jobtype = codeItem.getLabel();
                break;
            }
        }
        //短信内容初始化
        SimpleDateFormat sformat = new SimpleDateFormat("yyyy-MM-dd");
        String msgTemplate = "您好，您有新的订单，"+
                "客户微信号："+order.getWechatno()+
                "，客户邮箱："+order.getEmail()+
                "，作业类型："+jobtype+
                "，截止日期："+sformat.format(order.getDeadline())+
                "，请工作人员尽快处理，谢谢";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://gbk.api.smschinese.cn");
        httpPost.addHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");
        msgTemplate=new String(msgTemplate.getBytes("GB2312"),"8859_1");
        ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("Uid", "lu137079431"));
        params.add(new BasicNameValuePair("Key", "d41d8cd98f00b204e980"));
        params.add(new BasicNameValuePair("smsMob", "13596465641,18566211527")); //,13596465641,18566211527
        params.add(new BasicNameValuePair(
                "smsText",
                msgTemplate
        ));
        httpPost.setEntity(new UrlEncodedFormEntity(params));
        CloseableHttpResponse response = null
                ;
        try {
            response = httpClient.execute(httpPost);
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            System.out.println("返回体："+EntityUtils.toString(entity));
            EntityUtils.consume(entity);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            response.close();
        }
        return null;
    }
}
