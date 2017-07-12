package com.dwb.ruyou.tvhall.model;

import java.util.List;

/**
 * Created by Slayer on 2017/7/4.
 */

public class GoldInfo {

    /**
     * result : SUCCESS
     * list : [{"id":6,"chargeMoney":100000,"deliverMoney":15000},{"id":5,"chargeMoney":50000,"deliverMoney":7500},{"id":4,"chargeMoney":20000,"deliverMoney":3000},{"id":3,"chargeMoney":10000,"deliverMoney":1500},{"id":2,"chargeMoney":5000,"deliverMoney":700},{"id":1,"chargeMoney":1000,"deliverMoney":100}]
     * 1元==10电玩币
     * 第一行 chargeMoney/10
     * 第二行 deliverMoney/10
     * 第三行 chargeMoney/100
     * chargeMoney 充值的钱 单位:分
     * deliverMoney 送的电玩币/10
     */

    private String result;
    private List<ListBean> list;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * id : 6
         * chargeMoney : 100000
         * deliverMoney : 15000
         */

        private int id;
        private int chargeMoney;
        private int deliverMoney;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getChargeMoney() {
            return chargeMoney;
        }

        public void setChargeMoney(int chargeMoney) {
            this.chargeMoney = chargeMoney;
        }

        public int getDeliverMoney() {
            return deliverMoney;
        }

        public void setDeliverMoney(int deliverMoney) {
            this.deliverMoney = deliverMoney;
        }

        @Override
        public String toString() {
            return "id="+id+
                    ",chargeMoney="+chargeMoney+
                    ",deliverMoney="+deliverMoney;
        }
    }

    @Override
    public String toString() {
        return "result="+result+
                ",list="+list;
    }
}
