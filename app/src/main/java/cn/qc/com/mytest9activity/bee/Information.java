package cn.qc.com.mytest9activity.bee;

/**
 * Created by ASUS on 2018/12/17.
 */

public class Information {
//    "error_code": 0,
//            "reason": "成功的返回",
//            "result": {
//        "data": [
//        {
    private int  error_code;
    private String reason;
    private Result2 result;

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

    public Result2 getResult() {
        return result;
    }

    public void setResult(Result2 result) {
        this.result = result;
    }
}
