package com.yankovets.model;

import java.util.List;

public class Group extends Model {

    private Long id;
    private String title;
    private String description;

    private List<User> compatitors;

    public Group(String title, List<User> compatitors) {
        this.title = title;
        this.compatitors = compatitors;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public List<User> getCompatitors() {
        return compatitors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        return compatitors.equals(group.compatitors);

    }

    @Override
    public int hashCode() {
        return compatitors.hashCode();
    }
}
