package com.nro.god.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username", length = 20)
    private String username;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime = new Date();

    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime = new Date();

    @Column(name = "ban")
    private Short ban = 0;

    @Column(name = "point_post")
    private Integer pointPost = 0;

    @Column(name = "last_post")
    private Integer lastPost = 0;

    @Column(name = "role")
    private Integer role = -1;

    @Column(name = "is_admin")
    private Boolean isAdmin = false;

    @Column(name = "last_time_login",insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastTimeLogin = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2002-05-07 07:00:00");

    @Column(name = "last_time_logout",insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastTimeLogout = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2002-05-07 07:00:00");;

    @Column(name = "ip_address", length = 50)
    private String ipAddress = "";

    @Column(name = "active", columnDefinition = "DEFAULT 1")
    private Integer active = 0;

    @Lob
    @Column(name = "reward")
    private String reward = "";

    @Column(name = "thoi_vang", nullable = false)
    private Integer thoiVang = 20;

    @Column(name = "server_login", nullable = false)
    private Integer serverLogin = -1;

    @Column(name = "new_reg", nullable = false)
    private Integer newReg = 0;

    public Account() throws ParseException {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Short getBan() {
        return ban;
    }

    public void setBan(Short ban) {
        this.ban = ban;
    }

    public Integer getPointPost() {
        return pointPost;
    }

    public void setPointPost(Integer pointPost) {
        this.pointPost = pointPost;
    }

    public Integer getLastPost() {
        return lastPost;
    }

    public void setLastPost(Integer lastPost) {
        this.lastPost = lastPost;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Date getLastTimeLogin() {
        return lastTimeLogin;
    }

    public void setLastTimeLogin(Date lastTimeLogin) {
        this.lastTimeLogin = lastTimeLogin;
    }

    public Date getLastTimeLogout() {
        return lastTimeLogout;
    }

    public void setLastTimeLogout(Date lastTimeLogout) {
        this.lastTimeLogout = lastTimeLogout;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public Integer getThoiVang() {
        return thoiVang;
    }

    public void setThoiVang(Integer thoiVang) {
        this.thoiVang = thoiVang;
    }

    public Integer getServerLogin() {
        return serverLogin;
    }

    public void setServerLogin(Integer serverLogin) {
        this.serverLogin = serverLogin;
    }

    public Integer getNewReg() {
        return newReg;
    }

    public void setNewReg(Integer newReg) {
        this.newReg = newReg;
    }

}