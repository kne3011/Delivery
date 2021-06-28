package com.epam.delivery.entity;

public class Reciept_component {
    private long id;
    private long product_id;
    private long reciept_id;

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

    public long getReciept_id() {
        return reciept_id;
    }

    public void setReciept_id(long reciept_id) {
        this.reciept_id = reciept_id;
    }

    @Override
    public String toString() {
        return "Reciept_component{" +
                "id=" + id +
                ", product_id=" + product_id +
                ", reciept_id=" + reciept_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reciept_component that = (Reciept_component) o;

        if (id != that.id) return false;
        if (product_id != that.product_id) return false;
        return reciept_id == that.reciept_id;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (product_id ^ (product_id >>> 32));
        result = 31 * result + (int) (reciept_id ^ (reciept_id >>> 32));
        return result;
    }
}
