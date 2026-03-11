package edu.norcocollege.cis18b.week2.demo;

import java.util.Optional;

public class getPerson {
    String name;

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
