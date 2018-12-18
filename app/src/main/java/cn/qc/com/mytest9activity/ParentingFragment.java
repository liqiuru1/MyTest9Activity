package cn.qc.com.mytest9activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import java.util.ArrayList;
import java.util.List;

import cn.qc.com.mytest9activity.adapter.MyListViewAdapter;
import cn.qc.com.mytest9activity.adapter.MyParentingAdapter;
import cn.qc.com.mytest9activity.bee.Data2;
import cn.qc.com.mytest9activity.bee.Information;
import cn.qc.com.mytest9activity.http.HttpRetrofit;
import cn.qc.com.mytest9activity.http.RequestCallBack;

/**
 * Created by ASUS on 2018/12/17.
 */

public class ParentingFragment extends Fragment {

    private List<Data2> data;
    private ViewPager vp_p;
    private ListView lv;

    private List<String> mlist=new ArrayList<>(  );

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_parenting, null );
        vp_p = view.findViewById( R.id.vp_p );
        lv = view.findViewById( R.id.lv );

        HttpRetrofit.getInstace().doRequestRetrofit1( new RequestCallBack<Information>() {
            @Override
            public void complemete() {

            }

            @Override
            public void sucess(Information information) {
                data = information.getResult().getData();
                final List<View> list = new ArrayList<>();
                ImageView imageView1 = new ImageView( getActivity() );
                Glide.with( getActivity() ).load( data.get( 0 ).getThumbnail_pic_s() ).into( imageView1 );
                 mlist.add( data.get( 0 ).getThumbnail_pic_s() );

                imageView1.setScaleType( ImageView.ScaleType.CENTER_CROP );
                list.add( imageView1 );

                ImageView imageView2 = new ImageView( getActivity() );
                Glide.with( getActivity() ).load( data.get( 0 ).getThumbnail_pic_s02() ).into( imageView2 );
                mlist.add( data.get( 0 ).getThumbnail_pic_s02() );
                imageView2.setScaleType( ImageView.ScaleType.CENTER_CROP );
                list.add( imageView2 );

                ImageView imageView3 = new ImageView( getActivity() );
                Glide.with( getActivity() ).load( data.get( 0 ).getThumbnail_pic_s03() ).into( imageView3 );
                mlist.add( data.get( 0 ).getThumbnail_pic_s03() );
                imageView3.setScaleType( ImageView.ScaleType.CENTER_CROP );
                list.add( imageView3 );

                ImageView imageView4 = new ImageView( getActivity() );
                Glide.with( getActivity() ).load( data.get( 0 ).getThumbnail_pic_s04() ).into( imageView4 );
                mlist.add( data.get( 0 ).getThumbnail_pic_s04() );

                imageView4.setScaleType( ImageView.ScaleType.CENTER_CROP );
                list.add( imageView4 );

                ImageView imageView5 = new ImageView( getActivity() );
                Glide.with( getActivity() ).load( data.get( 0 ).getThumbnail_pic_s05() ).into( imageView5 );
                mlist.add( data.get( 0 ).getThumbnail_pic_s05() );

                imageView5.setScaleType( ImageView.ScaleType.CENTER_CROP );
                list.add( imageView5 );
                MyParentingAdapter adapter = new MyParentingAdapter( getActivity(), list );
                vp_p.setAdapter( adapter );


                for(int i=0;i<list.size();i++){

                    View  view=list.get( i );
                    final int finalI = i;
                    view.setOnClickListener( new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            UMImage image = new UMImage(getActivity(), mlist.get( finalI ));//网络图片
//
                            UMImage thumb = new UMImage(getActivity(), mlist.get( finalI ));
                            image.setThumb( thumb );

                            image.compressStyle = UMImage.CompressStyle.SCALE;//大小压缩，默认为大小压缩，适合普通很大的图
                            image.compressStyle = UMImage.CompressStyle.QUALITY;//质量压缩，适合长图的分享压缩格式设置
                            image.compressFormat = Bitmap.CompressFormat.PNG;//用户分享透明背景的图片可以设置这种方式，但是qq好友，微信朋友圈，不支持透明背景图片，会变成黑色

                            new ShareAction(getActivity()).withText("hello").withMedia( image )
                                    .setDisplayList( SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                                    .setCallback(shareListener).open();
                        }
                    } );

                }


                List<Data2> list1 = new ArrayList<>();
                List<Data2> data = information.getResult().getData();
                for (int i = 1; i < data.size(); i++) {
                    Data2 data2 = data.get( i );
                    list1.add( data2 );
                }
                MyListViewAdapter adapter1 = new MyListViewAdapter( getActivity(), list1 );
                lv.setAdapter( adapter1 );


            }

            @Override
            public void fail(Throwable e) {

            }
        } );

        return view;
    }

    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText( getActivity(),"成功了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText( getActivity(),"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText( getActivity(),"取消                                          了",Toast.LENGTH_LONG).show();

        }
    };




}
