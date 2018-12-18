package cn.qc.com.mytest9activity.http;


/**
 * Created by ASUS on 2018/11/7.
 */

public interface RequestCallBack<T>{
    /**
     * 请求成功是的回调
     */

    void  complemete();
     void sucess( T t);
     void fail( Throwable e);
}
