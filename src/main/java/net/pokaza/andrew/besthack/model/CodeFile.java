package net.pokaza.andrew.besthack.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_code")
public class CodeFile {
    @Id
    private String uuid;
    private String text;
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
}
