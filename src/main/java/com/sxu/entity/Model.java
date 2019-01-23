package com.sxu.entity;

import java.io.Serializable;
import org.msgpack.annotation.Message;
/**
 * 消息类型分离器
 * @author Administrator
 *
 */
@Message
public class Model implements Serializable{

    private static final long serialVersionUID = 1L;

    //类型
    private int type;

    //内容
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Model [type=" + type + ", body=" + body + "]";
    }
}