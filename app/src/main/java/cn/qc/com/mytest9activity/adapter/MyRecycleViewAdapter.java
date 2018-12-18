package cn.qc.com.mytest9activity.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import cn.qc.com.mytest9activity.R;
import cn.qc.com.mytest9activity.bee.Data;


/**
 * Created by ASUS on 2018/12/13.
 */

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.VH> {
    private Context context;
    private List<Data> list;

    public MyRecycleViewAdapter(Context context, List<Data> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate( context, R.layout.item, null );

        return new VH( view );
    }

    @Override
    public void onBindViewHolder(VH holder, final int position) {
        Data data = list.get( position );
        Glide.with( context ).load( data.getThumbnail_pic_s() ).into( holder.img );

        holder.tv_author_name.setText( data.getAuthor_name() );
        holder.tv_title.setText( data.getTitle() );
        holder.tv_date.setText( data.getDate() );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class VH extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView tv_title;
        private final TextView tv_author_name;
        private final TextView tv_date;

        public VH(View itemView) {
            super( itemView );
            img = itemView.findViewById( R.id.img );
            tv_title = itemView.findViewById( R.id.tv_title );
            tv_author_name = itemView.findViewById( R.id.tv_author_name );
            tv_date = itemView.findViewById( R.id.tv_date );

        }
    }


}
