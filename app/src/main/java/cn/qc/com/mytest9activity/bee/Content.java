package cn.qc.com.mytest9activity.bee;

/**
 * Created by ASUS on 2018/12/17.
 */

public class Content {
       private int  error_code;
       private String reason;
       private Result result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
