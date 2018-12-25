package com.itheima.ssm.domain;

import com.itheima.ssm.utils.StringToDate;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
//订单实体类

public class Orders implements Serializable {

    private String id;
    private String orderNum;//订单编号
    private Date orderTime;//下单时间
    private String orderTimeStr;
    private int orderStatus;//订单状态(0 未支付 1 已支付)
    private String orderStatusStr;
    private int peopleCount;//出行人数
    private Product product;
    private List<Traveller> travellers;
    private Member member;
    private Integer payType;
    private String payTypeStr;
    private String orderDesc;//订单描述(其它信息)

    public String getOrderStatusStr() {
        if(orderStatus == 0){
            orderStatusStr = "未支付";
        }else if(orderStatus == 1){
            orderStatusStr = "已支付";
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        if(orderTime != null){
            orderTimeStr = StringToDate.date2String(orderTime,"yyyy-MM-dd HH:mm:ss");
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
        //支付方式:0支付宝 1微信 2其它
        if(payType == 0){
            payTypeStr = "支付宝";
        }else if(payType == 1){
            payTypeStr = "微信";
        }else if(payType == 2){
            payTypeStr = "其它";
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

}
