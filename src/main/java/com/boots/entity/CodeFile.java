package com.boots.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_code")
public class CodeFile {
    @Id
    private String uuid;
    private String name;
    private String text;
    private String status;
    private String comments;
    @Transient
    @ManyToOne
    private User users;

    public CodeFile() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
