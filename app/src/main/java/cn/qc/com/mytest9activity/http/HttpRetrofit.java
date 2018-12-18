package cn.qc.com.mytest9activity.http;


import android.os.Environment;

import java.io.File;
import java.io.IOException;

import cn.qc.com.mytest9activity.BuildConfig;
import cn.qc.com.mytest9activity.bee.Content;
import cn.qc.com.mytest9activity.bee.Information;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ASUS on 2018/12/17.
 */

public class HttpRetrofit {
    private static HttpRetrofit retrofit=new HttpRetrofit();
    private final OkHttpClient client;

    private HttpRetrofit(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.cache( new Cache( new File( Environment.getExternalStorageDirectory(), "blood" ), 1024 * 1024 ) );//增加缓存
        if (BuildConfig.DEBUG) {//debug模式的时候才加载日志拦截器
            builder.addInterceptor( new LoggingInterceptor() ).build();
        }
        client = builder.build();

    }
    public static HttpRetrofit getInstace(){
        return retrofit;
    }
    public class LoggingInterceptor implements Interceptor {

        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            Request request = chain.request();//得到请求前的Request
            System.out.println( "请求到的url！！！！！" + request.url() );
            okhttp3.Response response = chain.proceed( request );//request请求的对象，response返回的对象

            return response;
        }
    }
    public void doRequestRetrofit(final RequestCallBack<Content> requestCallBack){
        Retrofit retrofit = new Retrofit.Builder().client( client )
                .baseUrl( Config.base_url )
                .addConverterFactory( GsonConverterFactory.create())
                .addCallAdapterFactory( RxJavaCallAdapterFactory.create() )
                .build();
        Interface anInterface = retrofit.create( Interface.class );
        anInterface.getMsg()
                .subscribeOn( Schedulers.io() )
                .observeOn( AndroidSchedulers.mainThread() )
                .subscribe( new Subscriber<Content>() {
                    @Override
                    public void onCompleted() {
                        requestCallBack.complemete();
                    }

                    @Override
                    public void onError(Throwable e) {
                          requestCallBack.fail( e );
                    }

                    @Override
                    public void onNext(Content content) {
                        requestCallBack.sucess( content );
                    }
                } );
    }
    public void doRequestRetrofit1(final RequestCallBack<Information> requestCallBack){
        Retrofit retrofit = new Retrofit.Builder().client( client )
                .baseUrl( Config.base_url )
                .addConverterFactory( GsonConverterFactory.create())
                .addCallAdapterFactory( RxJavaCallAdapterFactory.create() )
                .build();
        Interface anInterface = retrofit.create( Interface.class );
        anInterface.getMsg1()
                .subscribeOn( Schedulers.io() )
                .observeOn( AndroidSchedulers.mainThread() )
                .subscribe( new Subscriber<Information>() {
                    @Override
                    public void onCompleted() {
                        requestCallBack.complemete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        requestCallBack.fail( e );
                    }

                    @Override
                    public void onNext(Information information) {
                        requestCallBack.sucess( information );
                    }
                } );
    }
}
