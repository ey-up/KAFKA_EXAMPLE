package com.kartaca.okur.configuration.kafka.consumer;

public class KafkaListenerProperties {

    private String groupId;
    private int concurrency;
    private String offsetReset;
    private boolean autoCommit;
    private String sessionTimeout;
    private String maxPoll;

    public KafkaListenerProperties() {
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public int getConcurrency() {
        return concurrency;
    }

    public void setConcurrency(int concurrency) {
        this.concurrency = concurrency;
    }

    public String getOffsetReset() {
        return offsetReset;
    }

    public void setOffsetReset(String offsetReset) {
        this.offsetReset = offsetReset;
    }

    public boolean isAutoCommit() {
        return autoCommit;
    }

    public void setAutoCommit(boolean autoCommit) {
        this.autoCommit = autoCommit;
    }

    public String getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(String sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    public String getMaxPoll() {
        return maxPoll;
    }

    public void setMaxPoll(String maxPoll) {
        this.maxPoll = maxPoll;
    }
}
