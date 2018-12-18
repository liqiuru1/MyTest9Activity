package cn.qc.com.mytest9activity.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by ASUS on 2018/12/17.
 */

public class MyParentingAdapter extends PagerAdapter {
    private Context context;
    private List<View>  list;

    public MyParentingAdapter(Context context, List<View> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView( list.get( position%list.size() ) );
        return list.get( position%list.size());
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
      container.removeView( (View) object );
    }
}
