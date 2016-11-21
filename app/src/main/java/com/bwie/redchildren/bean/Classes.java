package com.bwie.redchildren.bean;

import java.util.List;

/**
 * Created by zjj on 2016/11/11.
 */
public class Classes {

    private String message;
    private int status;
    private List<RsBean> rs;

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public List<RsBean> getRs() {
        return rs;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setRs(List<RsBean> rs) {
        this.rs = rs;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", rs=" + rs +
                '}';
    }
}
