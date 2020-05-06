package com.example.demo090.dao.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 商品实体类
 */
@Entity
@Table(name = "Commodity")
public class CommodityEntity {

    //商品id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "com_id")
    private Long comID;

    //商品价格
    @Column(name = "com_price")
    private Double comPrice;

    //商品名字
    @Column(name = "com_name")
    private String comName;

    //商品描述
    @Column(name = "com_describe")
    private String comDescribe;

    //发布时间
    @Column(name = "com_releasetime")
    private LocalDateTime comReleaseTime;

    //商品状态
    //release已经发布
    //traded 已经交易
    //commented 已经评论
    @Column(name = "com_status")
    private String comStatus;

    //和用户创建多对一关系
    @ManyToOne(targetEntity = UserEntity.class)
    @JoinColumn(name = "out_user_id",referencedColumnName = "id")
    private UserEntity user;

//    @OneToOne(mappedBy = "commodityEntity")
//    private DealEntity deal;

    public Long getComID() {
        return comID;
    }

    public void setComID(Long comID) {
        this.comID = comID;
    }

    public Double getComPrice() {
        return comPrice;
    }

    public void setComPrice(Double comPrice) {
        this.comPrice = comPrice;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComDescribe() {
        return comDescribe;
    }

    public void setComDescribe(String comDescribe) {
        this.comDescribe = comDescribe;
    }

    public LocalDateTime getComReleaseTime() {
        return comReleaseTime;
    }

    public void setComReleaseTime(LocalDateTime comReleaseTime) {
        this.comReleaseTime = comReleaseTime;
    }

    public String getComStatus() {
        return comStatus;
    }

    public void setComStatus(String comStatus) {
        this.comStatus = comStatus;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

//    public DealEntity getDeal() {
//        return deal;
//    }
//
//    public void setDeal(DealEntity deal) {
//        this.deal = deal;
//    }

//    @Override
//    public String toString() {
//        return "CommodityEntity{" +
//                "comID=" + comID +
//                ", comPrice=" + comPrice +
//                ", comName='" + comName + '\'' +
//                ", comDescribe='" + comDescribe + '\'' +
//                ", comReleaseTime=" + comReleaseTime +
//                '}';
//    }
}