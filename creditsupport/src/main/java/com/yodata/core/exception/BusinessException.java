package com.yodata.core.exception;

import com.yodata.core.message.MessageEntity;

/**
 * Created by zheng.liu@baifendian on 2015-07-14.
 */
public class BusinessException extends RuntimeException {
    private MessageEntity message;

    public BusinessException(MessageEntity message){
        super(message.getMessage());
        this.message=message;
    }
}
