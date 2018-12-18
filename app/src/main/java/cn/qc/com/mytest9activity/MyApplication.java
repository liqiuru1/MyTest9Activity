package cn.qc.com.mytest9activity;

import android.app.Application;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Created by ASUS on 2018/11/18.
 */

public class MyApplication extends Application {

    public   static UMShareAPI umShareAPI;

    @Override
    public void onCreate() {
        super.onCreate();
        UMConfigure.setLogEnabled( true );
        UMConfigure.init(this,"5a12384aa40fa3551f0001d1","umeng", UMConfigure.DEVICE_TYPE_PHONE,"");//58edcfeb310c93091c000be2 5965ee00734be40b580001a0
        umShareAPI = UMShareAPI.get( this );
        PlatformConfig.setQQZone( "100424468", "c7394704798a158208a74ab60104f0ba" );
    }
}
