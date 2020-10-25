package com.market.domain;

import java.io.Serializable;

/**
 * @author ll
 */
public class ShoppingInfo implements Serializable {
    private Integer id;
    private String order_id;
    private Integer userid;
    private String goods_name;
    private String sort;
    private Integer count;
    private Double price;
    private String date;

    public ShoppingInfo(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ShoppingInfo{" +
                "id=" + id +
                ", order_id='" + order_id + '\'' +
                ", userid=" + userid +
                ", goods_name='" + goods_name + '\'' +
                ", sort='" + sort + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", date='" + date + '\'' +
                '}';
    }
}
