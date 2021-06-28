package com.epam.delivery.entity;

public class Product {
    private long id;
    private String name;
    private long type_id;
    private String description;
    private String photo_link;
    private int price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getType_id() {
        return type_id;
    }

    public void setType_id(long type_id) {
        this.type_id = type_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto_link() {
        return photo_link;
    }

    public void setPhoto_link(String photo_link) {
        this.photo_link = photo_link;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type_id=" + type_id +
                ", description='" + description + '\'' +
                ", photo_link='" + photo_link + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (type_id != product.type_id) return false;
        if (price != product.price) return false;
        if (!name.equals(product.name)) return false;
        if (!description.equals(product.description)) return false;
        return photo_link.equals(product.photo_link);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + (int) (type_id ^ (type_id >>> 32));
        result = 31 * result + description.hashCode();
        result = 31 * result + photo_link.hashCode();
        result = 31 * result + price;
        return result;
    }
}
