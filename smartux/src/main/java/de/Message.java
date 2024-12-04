package de;

import com.google.gson.annotations.SerializedName;

public class Message {


    @SerializedName("type")
    private String type;
    @SerializedName("topic")
    private String topic;
    @SerializedName("payload")
    private String payload;

    public String getTopic() {
        return topic;
    }

    public String getType() {
        return type;
    }



    public String getPayload() {
        return payload;
    }


    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

}