package test.json;

import java.io.Serializable;
import java.util.Map;

class ResultDomain implements Serializable {

    private static final long   serialVersionUID = 18776646463774784L;

    public static final String  DATA_KEY         = "data";      

    private int                 code;

    private String              msg;

    private Map<String, Object> data;

    private String              viewType;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public String getViewType() {
        return viewType;
    }

    public void setViewType(String viewType) {
        this.viewType = viewType;
    }

    public static String getDataKey() {
        return DATA_KEY;
    }
    
}
