package com.dwb.ruyou.tvhall.ui.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.ui.adapter.KeyBoartAdapter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Slayer on 2017/6/19.
 */

public class SearchKeyBoart extends RelativeLayout {
    private Context mContext;
    private TextView showTv,clearTv,delTv;
    private RecyclerView recyclerView;
    private List<String> keyStringList;
    private KeyBoartAdapter adapter;
    private boolean hasGetItemHeight;
    private int itemHeigtht;

    private StringBuffer searchString=new StringBuffer();
    private  SearchChange searchChange;

    public interface SearchChange{
        void getSeachString(String s);
    }

    public SearchKeyBoart(Context context) {
        super(context);
    }

    public SearchKeyBoart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext= context;
        initView();
    }

    private void initView(){
        keyStringList= Arrays.asList(getResources().getStringArray(R.array.keyBoart));
        View view= LayoutInflater.from(mContext).inflate(R.layout.search_keyboart_layout,this);
        showTv= (TextView) view.findViewById(R.id.keyboart_tv);
        clearTv= (TextView) view.findViewById(R.id.keyboart_clear_tv);
        delTv= (TextView) view.findViewById(R.id.keyboart_del_tv);
        recyclerView= (RecyclerView) view.findViewById(R.id.keyboart_recycler);

        recyclerView.setHasFixedSize(true);
//        recyclerView.addItemDecoration(new DividerGridItemDecoration(mContext));//设置分割线
        adapter=new KeyBoartAdapter(mContext, new KeyBoartAdapter.ClickKeyBoart() {
            @Override
            public void getKeyBoartString(String s) {
                searchString=searchString.append(s);
//                Log.e("searchStirng", "onClick: ----click-------"+searchString+"----leanth---"+searchString.length() );
                showTv.setText(searchString);
                searchChange.getSeachString(searchString.toString());
            }
        });

        GridLayoutManager gridLayoutManager=new GridLayoutManager(mContext,6);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

//        adapter.addItems(keyStringList);

        /**动态设置itme的高度*/
        ViewTreeObserver viewTreeObserver=recyclerView.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (!hasGetItemHeight){
                    /**测试提交*/
//                    Log.e("height", "onCreateViewHolder: ----searchKeyBoart   2---"+recyclerView.getHeight() );
                    itemHeigtht=recyclerView.getHeight()/6;
                    hasGetItemHeight=true;
                    adapter.setItemHeight(itemHeigtht);
                    adapter.addItems(keyStringList);
                }
            }
        });

        clearTv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (searchString.length()>0){
                    searchString.setLength(0);
                    showTv.setText(searchString);
                    searchChange.getSeachString(searchString.toString());
                }
//                Log.e("searchStirng", "onClick: ----clear-------"+searchString+"----leanth---"+searchString.length() );
            }
        });

        delTv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (searchString.length()>0){
                    searchString.deleteCharAt(searchString.length()-1);
                    showTv.setText(searchString);
                    searchChange.getSeachString(searchString.toString());
                }
//                Log.e("searchStirng", "onClick: ----del-------"+searchString );
            }
        });
    }
    public void searchStirngChange(SearchChange search){
        this.searchChange=search;
    }
}
