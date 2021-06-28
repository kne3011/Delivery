package com.epam.delivery.entity;

public class Teg_list {
    private long id;
    private long product_id;
    private long teg_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public long getTeg_id() {
        return teg_id;
    }

    public void setTeg_id(long teg_id) {
        this.teg_id = teg_id;
    }

    @Override
    public String toString() {
        return "Teg_list{" +
                "id=" + id +
                ", product_id=" + product_id +
                ", teg_id=" + teg_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teg_list teg_list = (Teg_list) o;

        if (id != teg_list.id) return false;
        if (product_id != teg_list.product_id) return false;
        return teg_id == teg_list.teg_id;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (product_id ^ (product_id >>> 32));
        result = 31 * result + (int) (teg_id ^ (teg_id >>> 32));
        return result;
    }
}
