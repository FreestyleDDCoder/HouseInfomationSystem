package utils;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * Created by liangzhan on 18-3-14.
 * 这是json相关的工具类
 * 采用的是阿里巴巴的FastJson框架
 */
public class JsonHandle {
    //主要是封装json格式解析和一些生成相关准备工作

    /**
     * 这是解析单个对象的方法
     *
     * @param json  json格式字符串
     * @param clazz 解析对应的JavaBean类文件
     * @return 返回 Object对象
     */
    public Object goParseJsonObject(String json, Class clazz) {
        return JSON.parseObject(json, clazz);
    }

    /**
     * 这是解析对象数组的方法
     *
     * @param json  json格式字符串
     * @param clazz 解析对应的JavaBean类文件
     * @return 返回 Object对象列表
     */
    public List goParseJsonArray(String json, Class clazz) {

        return JSON.parseArray(json, clazz);
    }

    /**
     * 这是生成对象对应的json字符串
     *
     * @param o 对象
     * @return String Json格式的字符串
     */
    public String toJson(Object o) {
        return JSON.toJSONString(o);
    }

    /**
     * 这是生成对象列表对应的json字符串
     *
     * @param list 对象列表
     * @return String Json格式的字符串
     */
    public String toJson(List list) {
        return JSON.toJSONString(list);
    }
}
