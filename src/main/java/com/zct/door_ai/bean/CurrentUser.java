package com.zct.door_ai.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author zct
 * Created by zct11 on 2018/1/13.
 */
@ApiModel("户主属性")
public class CurrentUser {

    public static final int TYPE_ADMIN = 0;
    public static final int TYPE_HOSTER = 1;
    @ApiModelProperty(value = "户号")
    private String roomid;
    @ApiModelProperty(value ="用户名")
    private String username;
    @ApiModelProperty(value ="密码")
    private String password;
    @ApiModelProperty(value ="姓名")
    private String name;
    @ApiModelProperty(value ="身份证")
    private String idcard;
    @ApiModelProperty(value ="手机号码")
    private String telephone;
    @ApiModelProperty(value ="微信号")
    private String wechat;
    @ApiModelProperty(value ="注册时间")
    private String time;
    /*power 0：管理员，1；户主*/
    @ApiModelProperty(value ="权限")
    private int power;

    public CurrentUser() {
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
