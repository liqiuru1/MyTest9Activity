package cn.qc.com.mytest9activity.http;


import cn.qc.com.mytest9activity.bee.Content;
import cn.qc.com.mytest9activity.bee.Information;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by ASUS on 2018/12/13.
 */

public interface Interface {
    @GET("今日推荐.json")
    Observable<Content> getMsg();
    @GET("亲子模块.json")
    Observable<Information> getMsg1();


}
