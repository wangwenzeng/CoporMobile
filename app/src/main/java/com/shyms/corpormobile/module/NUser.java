package com.shyms.corpormobile.module;

import java.io.Serializable;

/**
 * Created by Weimin on 4/8/2016.
 */
public class NUser implements Serializable{
    public final String name; //用户姓名、昵称
    public final String lastLoginTime;//最后登录时间
    public final String ban;//权限
    public final int points;//积分
    public final String userId;//用户ID
    public final String username;//用户名
    public final String id_card;//身份证号码
    public final String badges;//头衔
    public final String log_verify_code;//登录用户识别码  string，12小时内有效
    public final String avatar;
    public final String avatarUrl;
    public final String email;

    public NUser() {
        this.name = null;
        this.lastLoginTime = null;
        this.ban = null;
        this.points = 0;
        this.userId = null;
        this.username = null;
        this.id_card = null;
        this.badges = null;
        this.log_verify_code = null;
        avatar = null;
        avatarUrl = null;
        email = null;

    }

    public String getName() {
        return name;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public String getBan() {
        return ban;
    }

    public int getPoints() {
        return points;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getId_card() {
        return id_card;
    }

    public String getBadges() {
        return badges;
    }

    public String getLog_verify_code() {
        return log_verify_code;
    }




}
