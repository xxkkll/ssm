package com.lbyier.collectionInfo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author LByier
 * @date 2020/11/7 10:42
 */
//null值不显示
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CollectionInfo implements Serializable {
    private Integer id;
    private String temp;
    private String hum;
    private Date createTime;
    private String createBy;
    private String equipment_id;
    private String smoke;
    private String fire;
    private String infra_red;

    public CollectionInfo(Integer id, String temp, String hum, Date createTime, String createBy, String equipment_id, String smoke, String fire, String infra_red) {
        this.id = id;
        this.temp = temp;
        this.hum = hum;
        this.createTime = createTime;
        this.createBy = createBy;
        this.equipment_id = equipment_id;
        this.smoke = smoke;
        this.fire = fire;
        this.infra_red = infra_red;
    }

    public String getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(String equipment_id) {
        this.equipment_id = equipment_id;
    }

    public String getSmoke() {
        return smoke;
    }

    public void setSmoke(String smoke) {
        this.smoke = smoke;
    }

    public String getFire() {
        return fire;
    }

    public void setFire(String fire) {
        this.fire = fire;
    }

    public String getInfra_red() {
        return infra_red;
    }

    public void setInfra_red(String infra_red) {
        this.infra_red = infra_red;
    }

    public CollectionInfo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getHum() {
        return hum;
    }

    public void setHum(String hum) {
        this.hum = hum;
    }
   @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }
   @DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Override
    public String toString() {
        return "CollectionInfo{" +
                "id=" + id +
                ", temp='" + temp + '\'' +
                ", hum='" + hum + '\'' +
                ", createTime=" + createTime +
                ", createBy='" + createBy + '\'' +
                ", equipment_id='" + equipment_id + '\'' +
                ", smoke='" + smoke + '\'' +
                ", fire='" + fire + '\'' +
                ", infra_red='" + infra_red + '\'' +
                '}';
    }
}
