package com.example.myweixin;

import android.app.Fragment;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.example.myweixin.R;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {
//    private RecyclerView recyclerView;
//    private Context context;
//    private adapter adapter;
    private List<String> list=new ArrayList<>();
    private static  final String tag=MainActivity.class.getSimpleName();

    private Fragment mTab01=new weixinFragment();
    private Fragment mTab02=new frdFragment();
    private Fragment mTab03=new contactFragment();
    private Fragment mTab04=new settingsFragment();
    private FragmentManager fm;

    private LinearLayout mTabWeixin;
    private LinearLayout mTabFrd;
    private LinearLayout mTabAddress;
    private LinearLayout mTabSettings;

    private ImageButton mImgWeixin;
    private ImageButton mImgFrd;
    private ImageButton mImgAddress;
    private ImageButton mImgSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        context=this;
        setContentView(R.layout.activity_main);
//        list=new ArrayList<>();
//        for(int i=0;i<30;i++){
//            if(i%2==0)  list.add("松鼠");
//            else list.add("鹦鹉");
//        }
//        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
//        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
//        manager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
//        recyclerView.setLayoutManager(manager);
//        adapter = new adapter(context,list);
//        recyclerView.setAdapter(adapter);
        initmyData();
        initView1();
        initView();
        initEvent();
        initFragment();
        selectfragment(0);
    }
    private void initmyData() {
        list.add("路德维希·凡·贝多芬");
        list.add("萧友梅");
        list.add("阿炳");
        list.add("冼星海");
        list.add("聂耳");
        list.add("施光南");
        list.add("弗里德里克·肖邦");
        list.add("罗伯特·舒曼");
        list.add("莫扎特");
        list.add("约瑟夫·海顿");
        list.add("舒伯特");
        list.add("巴赫");
        list.add("弗仑兹·李斯特");
        list.add("约翰奈斯·勃拉姆斯");
        list.add("门德尔松");
        list.add("德国作曲家、钢琴家、指挥家，被称为乐圣。");
        list.add("中国专业音乐教育的奠基人和开拓者、音乐理论家、作曲家。");
        list.add("民间音乐家、二胡演奏家，誉为演奏能手。");
        list.add("中国近代作曲家、钢琴家--人民音乐家。");
        list.add("中国音乐家--时代歌手。");
        list.add("誉为时代歌手，现代抒情歌曲作曲家。");
        list.add("誉为钢琴诗人，波兰作曲家、钢琴家。");
        list.add("德国著名作曲家、音乐评论家。");
        list.add("奥地利作曲家，被誉为神童。");
        list.add("奥地利作曲家，维也纳古典派奠基者之一。");
        list.add("奥地利作曲家--前所未有的最富诗意的音乐家。");
        list.add("德国最伟大的古典作曲家之一，管风琴演奏家。");
        list.add("天才的匈牙利作曲家、钢琴家、指挥家和音乐活动家。");
        list.add("德国十九世纪后半叶最卓越的、古典乐派最后的一位作曲家。");
        list.add("德国著名作曲家。");
    }

    private void initView1() {
        adapter adapter = new adapter(this);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        adapter.setExpandCollapseDataList(list);
    }

    private void initFragment(){
        fm=getFragmentManager();
        FragmentTransaction transaction=fm.beginTransaction();
        transaction.add(R.id.id_content, mTab01);
        transaction.add(R.id.id_content, mTab02);
        transaction.add(R.id.id_content, mTab03);
        transaction.add(R.id.id_content, mTab04);
        transaction.commit();
    }

    private void initView(){
        mTabWeixin=(LinearLayout)findViewById(R.id.id_tab_weixin);
        mTabFrd=(LinearLayout)findViewById(R.id.id_tab_frd);
        mTabAddress=(LinearLayout)findViewById(R.id.id_tab_contact);
        mTabSettings=(LinearLayout)findViewById(R.id.id_tab_settings);

        mImgWeixin=(ImageButton)findViewById(R.id.id_tab_weixin_img);
        mImgFrd=(ImageButton)findViewById(R.id.id_tab_frd_img);
        mImgAddress=(ImageButton)findViewById(R.id.id_tab_contact_img);
        mImgSettings=(ImageButton)findViewById(R.id.id_tab_settings_img);
    }

    private void hidefragment(FragmentTransaction transaction){
        transaction.hide(mTab01);
        transaction.hide(mTab02);
        transaction.hide(mTab03);
        transaction.hide(mTab04);
    }

    private void selectfragment(int i ){
        FragmentTransaction transaction=fm.beginTransaction();
        hidefragment(transaction);
        switch (i){
            case 0:
                transaction.show(mTab01);
                mImgWeixin.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case 1:
                transaction.show(mTab02);
                mImgFrd.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case 2:
                transaction.show(mTab03);
                mImgAddress.setImageResource(R.drawable.tab_address_pressed);
                break;
            case 3:
                transaction.show(mTab04);
                mImgSettings.setImageResource(R.drawable.tab_settings_pressed);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    @Override
    public void onClick(View v){
        Log.d("onClick","1");
        resetImgs();
        switch (v.getId()){
            case R.id.id_tab_weixin:
                selectfragment(0);
                break;
            case R.id.id_tab_frd:
                selectfragment(1);
                break;
            case R.id.id_tab_contact:
                selectfragment(2);
                break;
            case R.id.id_tab_settings:
                selectfragment(3);
                break;
            default:
                break;
        }
    }

    private void resetImgs(){
        mImgWeixin.setImageResource(R.drawable.tab_weixin_normal);
        mImgFrd.setImageResource(R.drawable.tab_find_frd_normal);
        mImgAddress.setImageResource(R.drawable.tab_address_normal);
        mImgSettings.setImageResource(R.drawable.tab_settings_normal);
    }

    private void initEvent() {
        mTabWeixin.setOnClickListener(this);
        mTabFrd.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
        mTabSettings.setOnClickListener(this);
    }
}
