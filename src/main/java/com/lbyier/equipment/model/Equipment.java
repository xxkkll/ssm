package com.lbyier.equipment.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;

/**
 * @author LByier
 * @date 2020/10/25 16:28
 */
//null值不显示
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Equipment implements Serializable {
    private Integer id;
    private Integer state_blind;
    private String equipment_type;
    private Integer state_run;
    private String owner_id;
    private Date create_time;
    private Date blind_time;
    private String equipment_name;
    private Integer is_delet;
    private String  equipment_id;

    public Equipment() {
    }

    public Equipment(Integer id, Integer state_blind, String equipment_type, Integer state_run, String owner_id, Date create_time, Date blind_time, String equipment_name, Integer is_delet, String equipment_id) {
        this.id = id;
        this.state_blind = state_blind;
        this.equipment_type = equipment_type;
        this.state_run = state_run;
        this.owner_id = owner_id;
        this.create_time = create_time;
        this.blind_time = blind_time;
        this.equipment_name = equipment_name;
        this.is_delet = is_delet;
        this.equipment_id = equipment_id;
    }

    public String getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(String equipment_id) {
        this.equipment_id = equipment_id;
    }

    public Integer getIs_delet() {
        return is_delet;
    }

    public void setIs_delet(Integer is_delet) {
        this.is_delet = is_delet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getState_blind() {
        return state_blind;
    }

    public void setState_blind(Integer state_blind) {
        this.state_blind = state_blind;
    }

    public String getEquipment_type() {
        return equipment_type;
    }

    public void setEquipment_type(String equipment_type) {
        this.equipment_type = equipment_type;
    }

    public Integer getState_run() {
        return state_run;
    }

    public void setState_run(Integer state_run) {
        this.state_run = state_run;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getBlind_time() {
        return blind_time;
    }

    public void setBlind_time(Date blind_time) {
        this.blind_time = blind_time;
    }

    public String getEquipment_name() {
        return equipment_name;
    }

    public void setEquipment_name(String equipment_name) {
        this.equipment_name = equipment_name;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", state_blind=" + state_blind +
                ", equipment_type='" + equipment_type + '\'' +
                ", state_run=" + state_run +
                ", owner_id='" + owner_id + '\'' +
                ", create_time=" + create_time +
                ", blind_time=" + blind_time +
                ", equipment_name='" + equipment_name + '\'' +
                ", is_delet=" + is_delet +
                ", equipment_id='" + equipment_id + '\'' +
                '}';
    }
}
