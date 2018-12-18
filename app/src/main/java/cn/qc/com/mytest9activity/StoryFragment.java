package cn.qc.com.mytest9activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import cn.qc.com.mytest9activity.adapter.MyRecycleViewAdapter;
import cn.qc.com.mytest9activity.adapter.MyStoryAdapter;
import cn.qc.com.mytest9activity.bee.Content;
import cn.qc.com.mytest9activity.bee.Data;
import cn.qc.com.mytest9activity.http.HttpRetrofit;
import cn.qc.com.mytest9activity.http.RequestCallBack;

/**
 * Created by ASUS on 2018/12/17.
 */

public class StoryFragment extends Fragment {

    private ViewPager vp_s;
    private List<Data> data;
    private RecyclerView recy;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fradment_story, null );
        vp_s = view.findViewById( R.id.vp_s );
        recy = view.findViewById( R.id.recy );
        HttpRetrofit.getInstace().doRequestRetrofit( new RequestCallBack<Content>() {
            @Override
            public void complemete() {

            }

            @Override
            public void sucess(Content content) {
                data = content.getResult().getData();
                List<View> list = new ArrayList<>();
                ImageView imageView1 = new ImageView( getActivity() );
                Glide.with( getActivity() ).load( data.get( 0 ).getThumbnail_pic_s() ).into( imageView1 );
                imageView1.setScaleType( ImageView.ScaleType.CENTER_CROP );
                list.add( imageView1 );

                ImageView imageView2 = new ImageView( getActivity() );
                Glide.with( getActivity() ).load( data.get( 0 ).getThumbnail_pic_s() ).into( imageView2 );
                imageView2.setScaleType( ImageView.ScaleType.CENTER_CROP );
                list.add( imageView2 );

                ImageView imageView3 = new ImageView( getActivity() );
                Glide.with( getActivity() ).load( data.get( 0 ).getThumbnail_pic_s() ).into( imageView3 );
                imageView3.setScaleType( ImageView.ScaleType.CENTER_CROP );
                list.add( imageView3 );

                ImageView imageView4 = new ImageView( getActivity() );
                Glide.with( getActivity() ).load( data.get( 0 ).getThumbnail_pic_s() ).into( imageView4 );
                imageView4.setScaleType( ImageView.ScaleType.CENTER_CROP );
                list.add( imageView4 );

                ImageView imageView5 = new ImageView( getActivity() );
                Glide.with( getActivity() ).load( data.get( 0 ).getThumbnail_pic_s() ).into( imageView5 );
                imageView5.setScaleType( ImageView.ScaleType.CENTER_CROP );
                list.add( imageView5 );
                MyStoryAdapter adapter = new MyStoryAdapter( getActivity(), list );
                vp_s.setAdapter( adapter );
                List<Data> list1 = new ArrayList<>();
                List<Data> data = content.getResult().getData();
                for (int i = 1; i < data.size(); i++) {
                    Data data1 = data.get( i );
                    list1.add( data1 );
                }
                MyRecycleViewAdapter adapter1 = new MyRecycleViewAdapter( getActivity(), list1 );
                GridLayoutManager manager = new GridLayoutManager( getActivity(), 2 );
                recy.setLayoutManager( manager );
                recy.setAdapter( adapter1 );


            }

            @Override
            public void fail(Throwable e) {
                Log.e( "sssss", e.getMessage() );
            }
        } );

        return view;
    }

}

