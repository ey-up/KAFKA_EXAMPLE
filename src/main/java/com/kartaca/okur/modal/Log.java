package com.kartaca.okur.modal;

import org.springframework.data.annotation.Id;

import java.util.UUID;

public class Log {
    @Id
    private String id;
    private String methodType;
    private Long time;
    private Long waitTime;

    public Log() {
        this.id = UUID.randomUUID().toString();
    }

    public Log(String methodType, Long time, Long waitTime) {
        this.id = UUID.randomUUID().toString();
        this.methodType = methodType;
        this.time = time;
        this.waitTime = waitTime;
    }

    public String getId() {
        return id;
    }

    public String getMethodType() {
        return methodType;
    }

    public void setMethodType(String methodType) {
        this.methodType = methodType;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(Long waitTime) {
        this.waitTime = waitTime;
    }
}
