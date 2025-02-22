package com.vicky.uni.example.startProject.SP1SpringBootInitApp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Question {
    private String difficulty;
    @JsonIgnore
    private int id;
    @JsonIgnore
    private boolean paidOnly;
    @JsonIgnore
    private String questionFrontendId;
    @JsonIgnore
    private String status;
    private String title;
    private String titleSlug;
    private List<CommonTagNode> topicTags;
    @JsonIgnore
    private Object frequency; // Can be null, so use Object or a suitable type
    @JsonIgnore
    private boolean isInMyFavorites;
    @JsonIgnore
    private double acRate;
    @JsonIgnore
    private String __typename;


    // Getters and setters for all fields (important!)

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPaidOnly() {
        return paidOnly;
    }

    public void setPaidOnly(boolean paidOnly) {
        this.paidOnly = paidOnly;
    }

    public String getQuestionFrontendId() {
        return questionFrontendId;
    }

    public void setQuestionFrontendId(String questionFrontendId) {
        this.questionFrontendId = questionFrontendId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleSlug() {
        return titleSlug;
    }

    public void setTitleSlug(String titleSlug) {
        this.titleSlug = titleSlug;
    }

    public List<CommonTagNode> getTopicTags() {
        return topicTags;
    }

    public void setTopicTags(List<CommonTagNode> topicTags) {
        this.topicTags = topicTags;
    }

    public Object getFrequency() {
        return frequency;
    }

    public void setFrequency(Object frequency) {
        this.frequency = frequency;
    }

    public boolean isInMyFavorites() {
        return isInMyFavorites;
    }

    public void setInMyFavorites(boolean isInMyFavorites) {
        this.isInMyFavorites = isInMyFavorites;
    }

    public double getAcRate() {
        return acRate;
    }

    public void setAcRate(double acRate) {
        this.acRate = acRate;
    }

    public String get__typename() {
        return __typename;
    }

    public void set__typename(String __typename) {
        this.__typename = __typename;
    }


}

class CommonTagNode {
    private String name;
    private String slug;
    @JsonIgnore
    private String __typename;

    // Getters and setters for CommonTagNode
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String get__typename() {
        return __typename;
    }

    public void set__typename(String __typename) {
        this.__typename = __typename;
    }
}
