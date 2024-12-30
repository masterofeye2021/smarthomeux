package de;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Message {


    @SerializedName("type")
    private String type;
    @SerializedName("topic")
    private String topic;
    @SerializedName("payload")
    private String payload;
    @JsonIgnore
    private transient LocalDateTime timestamp;

}