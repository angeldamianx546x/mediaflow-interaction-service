package com.mediaflow.api.dto;

public class EmotionResponse {
    private Integer emotionId;
    private String name;

    public EmotionResponse() {
    }

    public EmotionResponse(Integer emotionId, String name) {
        this.emotionId = emotionId;
        this.name = name;
    }

    public Integer getEmotionId() {
        return emotionId;
    }

    public void setEmotionId(Integer emotionId) {
        this.emotionId = emotionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
