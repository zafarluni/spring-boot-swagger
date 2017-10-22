package com.example.demo;

import io.swagger.annotations.ApiModelProperty;

public class User {

    @ApiModelProperty(notes = "Windows Network Id of user", required = true)
    private String networkId;

    @ApiModelProperty(notes = "Full name of user", required = true)
    private String name;

    public User() {
    }

    public User(String networkId, String name) {
        this.networkId = networkId;
        this.name = name;
    }

    public String getNetworkId() {
        return networkId;
    }

    public void setNetworkId(String networkId) {
        this.networkId = networkId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (networkId != null ? !networkId.equals(user.networkId) : user.networkId != null) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        int result = networkId != null ? networkId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
