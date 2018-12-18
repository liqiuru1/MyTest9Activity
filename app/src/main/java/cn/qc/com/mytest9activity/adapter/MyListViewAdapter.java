package cn.qc.com.mytest9activity.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import cn.qc.com.mytest9activity.R;
import cn.qc.com.mytest9activity.bee.Data2;

/**
 * Created by ASUS on 2018/12/18.
 */

public class MyListViewAdapter extends BaseAdapter {
    private Context context;
    private List<Data2> list;

    public MyListViewAdapter(Context context, List<Data2> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get( position );
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = View.inflate( context, R.layout.item1, null );
        ImageView img = convertView.findViewById( R.id.iv_img );
        TextView title=convertView.findViewById( R.id.title );
        TextView author_name=convertView.findViewById( R.id.author_name );
        TextView category=convertView.findViewById( R.id.category );
        TextView date=convertView.findViewById( R.id.date );
        Data2 data = list.get( position );
        Glide.with( context ).load( data.getThumbnail_pic_s() ).into( img );
        title.setText( data.getTitle() );
        author_name.setText( data.getAuthor_name() );
        category.setText( data.getCategory() );
        date.setText( data.getDate() );
        return convertView;
    }
}
