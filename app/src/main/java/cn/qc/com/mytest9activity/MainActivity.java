package cn.qc.com.mytest9activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.UMShareAPI;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_story;
    private TextView tv_parenting;
    private FrameLayout fraem;
    private FragmentManager manager;
    private FragmentTransaction transaction;

    private StoryFragment storyFragment;
    private ParentingFragment parentingFragment;
    private ScrollView scroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        fraem = findViewById( R.id.fraem );
        tv_story = findViewById( R.id.tv_story );
        tv_parenting = findViewById( R.id.tv_parenting );
        scroll = findViewById( R.id.scroll );
        tv_story.setOnClickListener( this );
        tv_parenting.setOnClickListener( this );

        manager = getSupportFragmentManager();
        setDrawable( tv_story, R.mipmap.tabbar_icon_story_s, R.color.colortheme );
        showF();


    }

    public void setDrawable(TextView textView, int Resourid, int colorid) {
        Drawable drawable = getResources().getDrawable( Resourid );
        drawable.setBounds( 0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight() );
        textView.setCompoundDrawables( null, drawable, null, null );
        textView.setTextColor( getResources().getColor( colorid ) );
    }

    public void showF() {
        transaction = manager.beginTransaction();
        if (storyFragment == null) {
            storyFragment = new StoryFragment();
            transaction.add( R.id.fraem, storyFragment ).show( storyFragment );
        } else {
            transaction.show( storyFragment );
        }
        transaction.commit();
    }

    public void hide() {
        transaction = manager.beginTransaction();
        if (storyFragment != null) {
            transaction.hide( storyFragment );
        }
        if (parentingFragment != null) {
            transaction.hide( parentingFragment );
        }
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText( this, "哈哈哈哈", Toast.LENGTH_SHORT ).show();
        hide();
        transaction = manager.beginTransaction();
        switch (v.getId()) {
            case R.id.tv_story:
                setDrawable( tv_story, R.mipmap.tabbar_icon_story_s, R.color.colortheme );
                setDrawable( tv_parenting, R.mipmap.tabbar_icon_lis_n, R.color.color_n );
                if (storyFragment == null) {
                    storyFragment = new StoryFragment();
                    transaction.add( R.id.fraem, storyFragment ).show( storyFragment ).commit();
                } else {
                    transaction.show( storyFragment ).commit();
                }
                //        //重新回到scroll的自己的顶点
        scroll.scrollTo(0,0);
        scroll.smoothScrollTo(0, 0);
                break;
            case R.id.tv_parenting:
                setDrawable( tv_parenting, R.mipmap.tabbar_icon_lis_s, R.color.colortheme );
                setDrawable( tv_story, R.mipmap.tabbar_icon_story_n, R.color.color_n );
                if (parentingFragment == null) {
                    parentingFragment = new ParentingFragment();
                    transaction.add( R.id.fraem, parentingFragment ).show( parentingFragment ).commit();
                } else {
                    transaction.show( parentingFragment ).commit();
                }
                //        //重新回到scroll的自己的顶点
                scroll.scrollTo(0,0);
                scroll.smoothScrollTo(0, 0);
                break;
        }
    }

    public  void lala(View view){

        Intent  intent=new Intent( MainActivity.this,Test1Activity.class );
        startActivity( intent );

        Toast.makeText( MainActivity.this, "你好", Toast.LENGTH_SHORT ).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult( requestCode, resultCode, data );
        UMShareAPI.get(MainActivity.this).onActivityResult(requestCode,resultCode,data);
    }

}
