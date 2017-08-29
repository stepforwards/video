package com.forward.video.model;

import java.sql.Date;

import com.forward.video.util.MyMD5Util;

public class User {
    private Integer id;

    private String nickName;

    private Integer sex;

    private Date birthday;

    private String email;

    private String province;

    private String city;

    private String headUrl;

    private String password;

    private Date insertTime;

    private Date updateTime;

    private String captcha;
    
    
    
    private String oldPassword;
    private String newPassword;
    
    
    

    public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		 this.oldPassword = oldPassword == null ? null : MyMD5Util.MD5Encrypt(oldPassword.trim());
	}
	

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		 this.newPassword = newPassword == null ? null : MyMD5Util.MD5Encrypt(newPassword.trim());
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl == null ? null : headUrl.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : MyMD5Util.MD5Encrypt(password.trim());
    }
    
    public void setPwdNMD5(String password) {
    	this.password = password == null ? null : password.trim();
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha == null ? null : captcha.trim();
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", nickName=" + nickName + ", sex=" + sex + ", birthday=" + birthday + ", email="
				+ email + ", province=" + province + ", city=" + city + ", headUrl=" + headUrl + ", password="
				+ password + ", insertTime=" + insertTime + ", updateTime=" + updateTime + ", captcha=" + captcha
				+ ", oldPassword=" + oldPassword + ", newPassword=" + newPassword + "]";
	}
    
}