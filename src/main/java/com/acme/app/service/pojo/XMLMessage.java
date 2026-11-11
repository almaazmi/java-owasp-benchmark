
















package com.acme.app.service.pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "message")
public class XMLMessage {
    private String msg;

    public XMLMessage() {}

    public XMLMessage(String msg) {
        
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    @XmlElement
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
