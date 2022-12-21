package com.estudos.log.logmsg.domain.entity;

import jakarta.persistence.*;

@Entity
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column (name = "messageKey")
    private String messageKey;
    @Column (name = "message")
    private String message;
    @Column (name = "timeAt")
    private Long timeAt;
    @Column (name = "loggedMessage")
    private boolean loggedMessage = false;

    public Messages() {
    }

    public Messages(Integer id, String messageKey, String message, Long timeAt, boolean loggedMessage) {
        this.id = id;
        this.messageKey = messageKey;
        this.message = message;
        this.timeAt = timeAt;
        this.loggedMessage = loggedMessage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimeAt() {
        return timeAt;
    }

    public void setTimeAt(Long timeAt) {
        this.timeAt = timeAt;
    }

    public boolean isLoggedMessage() {
        return loggedMessage;
    }

    public void setLoggedMessage(boolean loggedMessage) {
        this.loggedMessage = loggedMessage;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "id=" + id +
                ", messageKey='" + messageKey + '\'' +
                ", message='" + message + '\'' +
                ", timeAt=" + timeAt +
                ", loggedMessage=" + loggedMessage +
                '}';
    }
}
