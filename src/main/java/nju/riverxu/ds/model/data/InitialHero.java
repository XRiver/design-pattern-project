package nju.riverxu.ds.model.data;

import nju.riverxu.ds.model.spirit.HeroStatus;

import java.io.Serializable;

public class InitialHero implements Serializable {
    private String name;
    private String description;
    private HeroStatus status;

    public InitialHero(String name, String description, HeroStatus status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HeroStatus getStatus() {
        return status;
    }

    public void setStatus(HeroStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "InitialHero{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
