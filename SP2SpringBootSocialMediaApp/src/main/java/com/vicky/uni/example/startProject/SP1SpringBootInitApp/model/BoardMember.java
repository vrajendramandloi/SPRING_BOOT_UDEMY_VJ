package com.vicky.uni.example.startProject.SP1SpringBootInitApp.model;

import java.io.Serializable;

public class BoardMember {
    private String memberName;
    private Integer sharePer;

    public BoardMember(String memberName, Integer sharePer) {
        this.memberName = memberName;
        this.sharePer = sharePer;
    }

    public Integer getSharePer() {
        return sharePer;
    }

    public void setSharePer(Integer sharePer) {
        this.sharePer = sharePer;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Override
    public String toString() {
        return "BoardMember{" +
                "memberName='" + memberName + '\'' +
                ", sharePer=" + sharePer +
                '}';
    }
}
