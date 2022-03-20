package ru.kpfu.classwork.OnlineStore;


public class Product {
    private String name;
    private String stars;
    private String review;
    private int Quantity;
    private int id;
    private int orders=0;
    private int price;
    private int discount;
    private String Photo;
    private places places;
    public Product(String name,int price,int discount,String photo,int Quantity,String review){
        this.name=name;
        this.price=price;
        this.discount=discount;
        this.Photo=photo;
        this.id=(int)(Math.random()*1999);
        this.Quantity=Quantity;
        this.review=review;
        places=null;
    }

    public void setPlaces(places places) {
        this.places=places;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setPositiveQuantity() {
        Quantity ++;
    }
    public void setNegativeQuantity() {
        Quantity --;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Product(){

    }

    public void setOrders() {
        this.orders++;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public String getStars() {
        return stars;
    }

    public String getReview() {
        return review;
    }

    public int getOrders() {
        return orders;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscount() {
        return discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    enum places{
        In_Store,
        In_Shipping,
        Not_In_Store;

    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", stars='" + stars + '\'' +
                ", review='" + review + '\'' +
                ", Quantity=" + Quantity +
                ", id=" + id +
                ", orders=" + orders +
                ", price=" + price +
                ", discount=" + discount +
                ", Photo='" + Photo + '\'' +
                ", places=" + places +
                '}';
    }
}
