package com.yodata.core.message;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

import java.io.IOException;
import java.io.Serializable;

/**
 * Created by zheng.liu@baifendian on 2015-07-14.
 */
public class MessageEntity implements Serializable{
    private static ObjectMapper mapper=new ObjectMapper();
    private String code;
    private String message;
    private String result;

    public MessageEntity(String code, String message) {
        this.code = code;
        this.message = message;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String toJson(){
        ObjectNode jsonNodes=mapper.createObjectNode();
        jsonNodes.put("code",this.code);
        jsonNodes.put("message",this.message);
        jsonNodes.put("result",this.result);
        return jsonNodes.toString();
    }
}
