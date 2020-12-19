package com.alex.tfsystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.*;

@SpringBootTest
class TfSystemApplicationTests {

    @Test
    void contextLoads(){
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> list = groupAnagrams(strs);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resultList = new ArrayList<List<String>>();
        if(strs.length == 0){
            return resultList;
        }
        for(int i=0; i<strs.length; i++){
            addStrToList(resultList,strs[i]);
        }
        return resultList;
    }
    public static void addStrToList(List<List<String>> resultList, String str){
        if(resultList.size() == 0){
            List<String> subList = new ArrayList<String>();
            subList.add(str);
            resultList.add(subList);
            return;
        }
        for(List<String> listTemp : resultList){
            if(compareStr(str,listTemp.get(0))) {
                listTemp.add(str);
                return;
            }
        }
        List<String> subList = new ArrayList<String>();
        subList.add(str);
        resultList.add(subList);
        return;


    }

    public static boolean compareStr(String str, String str1){
        if(str.length() == 0 ){
            return false;
        }
        int temp = 0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0; i < str.length(); i++){
            if(!map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),1);
            }else{
                temp = map.get(str.charAt(i));
                map.remove(str.charAt(i));
                map.put(str.charAt(i),temp+1);
            }
        }

        Map<Character,Integer> map1 = new HashMap<Character,Integer>();
        for(int i = 0; i < str1.length(); i++){
            if(map1.get(str1.charAt(i)) == null){
                temp = 0;
                map1.put(str1.charAt(i),temp+1);
            }else{
                temp = map1.get(str1.charAt(i));
                map1.remove(str1.charAt(i));
                map1.put(str1.charAt(i),temp+1);
            }
        }
        if(!map.equals(map1)){
            return false;
        }
        return true;
    }


}
