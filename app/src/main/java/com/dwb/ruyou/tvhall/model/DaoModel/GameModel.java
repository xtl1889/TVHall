package com.dwb.ruyou.tvhall.model.DaoModel;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Slayer on 2017/7/10.
 *
 */

@Entity
public class GameModel {
    @Id(autoincrement = true)
    private Long id;
    @Unique
    private String name;
    @Generated(hash = 160039523)
    public GameModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 1977967076)
    public GameModel() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
