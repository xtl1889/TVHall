package com.dwb.ruyou.tvhall.ui.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.application.TVHallApplication;
import com.dwb.ruyou.tvhall.ui.adapter.GameStarAdapter;

import java.util.List;

/**
 * Created by Slayer on 2017/6/15.
 */

public class GameStarView extends LinearLayout {

    private int starNum;
    private Context mContext;
    private TextView gameNaem_tv;
    private RecyclerView starRecyclerView;
    private GameStarAdapter starAdapter;
    private LinearLayout game_item_star_layout;

    public GameStarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext= TVHallApplication.getTVHallInstance();
        setStarState();
    }


    private void setStarState(){
        View view= LayoutInflater.from(mContext).inflate(R.layout.gamestarlayout,this);
        gameNaem_tv= (TextView) view.findViewById(R.id.game_item_name);
        starRecyclerView= (RecyclerView) view.findViewById(R.id.game_item_star_recycler);
        game_item_star_layout= (LinearLayout) view.findViewById(R.id.game_item_star_layout);
//
//        if (starAdapter==null){
//            starAdapter=new GameStarAdapter(mContext);
//        }
//        TvGridLayoutManager gridLayoutManager=new TvGridLayoutManager(mContext,5,GridLayoutManager.VERTICAL,false);
//        starRecyclerView.setLayoutManager(gridLayoutManager);
//        starRecyclerView.setAdapter(starAdapter);

        gameNaem_tv.setText("游戏游戏");
    }

    public void setGameName(String s){
        if (gameNaem_tv!=null){
            gameNaem_tv.setText(s);
        }
    }

    public void setGameStart(List<Integer> list){
//        if (starAdapter!=null){
//            starAdapter.updateItems(list);
//        }
        if (list!=null){
            for (int i = 0; i < list.size(); i++) {
                ImageView img=new ImageView(mContext);
                if (list.get(i)==1){
                    img.setImageResource(R.drawable.game_star3);
                }else if (list.get(i)==0){
                    img.setImageResource(R.drawable.game_star1);
                }
                game_item_star_layout.addView(img);
            }
        }
    }

    public void setStarNum(int i){
        starNum =i;
    }
}
