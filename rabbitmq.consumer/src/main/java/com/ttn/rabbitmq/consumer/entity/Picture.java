package com.ttn.rabbitmq.consumer.entity;


public class Picture {

    public Picture() {
    }

    public Picture(String name, String type, Integer size, String source) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.source = source;
    }

    private String name;
    private String type;
    private Integer size;
    private String source;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", size=" + size +
                ", source='" + source + '\'' +
                '}';
    }
}
