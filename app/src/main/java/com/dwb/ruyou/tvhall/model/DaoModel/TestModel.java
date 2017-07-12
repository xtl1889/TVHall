package com.dwb.ruyou.tvhall.model.DaoModel;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Slayer on 2017/7/10.
 *
 * @Entity： 告诉GreenDao该对象为实体，只有被@Entity注释的Bean类才能被dao类操作
 *@Id： 对象的Id，使用Long类型作为EntityId，否则会报错。(autoincrement = true)表示主键会自增，如果false就会使用旧值
 *@Property： 可以自定义字段名，注意外键不能使用该属性
 *@NotNull： 属性不能为空
 *@Transient： 使用该注释的属性不会被存入数据库的字段中
 *@Unique： 该属性值必须在数据库中是唯一值
 *@Generated： 编译后自动生成的构造函数、方法等的注释，提示构造函数、方法等不能被修改
 */

@Entity
public class TestModel {
    //不能用int
    @Id(autoincrement = true)
    private Long id;
    //商品名称
    @Unique
    private String name;
    //商品价格
    @Property(nameInDb = "price")
    private String price;
    //已售数量
    private int sell_num;
    @Generated(hash = 152419987)
    public TestModel(Long id, String name, String price, int sell_num) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sell_num = sell_num;
    }
    @Generated(hash = 1568142977)
    public TestModel() {
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
    public String getPrice() {
        return this.price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public int getSell_num() {
        return this.sell_num;
    }
    public void setSell_num(int sell_num) {
        this.sell_num = sell_num;
    }
}
