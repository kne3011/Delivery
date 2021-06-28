package com.epam.delivery.entity;

import java.sql.Date;

public class Reciept {
    private long id;
    private String type;
    private Date time;
    private int allPrice;
    private long user_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(int allPrice) {
        this.allPrice = allPrice;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reciept reciept = (Reciept) o;

        if (id != reciept.id) return false;
        if (allPrice != reciept.allPrice) return false;
        if (user_id != reciept.user_id) return false;
        if (!type.equals(reciept.type)) return false;
        return time.equals(reciept.time);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + type.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + allPrice;
        result = 31 * result + (int) (user_id ^ (user_id >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Reciept{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", time=" + time +
                ", allPrice=" + allPrice +
                ", user_id=" + user_id +
                '}';
    }
}
