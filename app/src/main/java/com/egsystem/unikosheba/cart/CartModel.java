package com.egsystem.unikosheba.cart;

public class CartModel {
    public static final String TABLE_NAME = "cart_items_table";

    public static final String COLUMN_ID = "id";
    public static final String CATEGORY_NAME = "category_name";
    public static final String SUB_CATEGORY_NAME = "sub_category_name";
    public static final String SERVICE_ID = "service_id";
    public static final String SERVICE_NAME = "service_name";
    public static final String PRICE = "price";
    public static final String DISCOUNT = "discount";
    public static final String QUANTITY = "quantity";
    public static final String IMG_LINK = "img_link";

    private int id;
    private String category_name;
    private String sub_category_name;
    private String service_id;
    private String service_name;
    private String price;
    private String discount;
    private String quantity;
    private String img_link;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + CATEGORY_NAME + " TEXT,"
                    + SUB_CATEGORY_NAME + " TEXT,"
                    + SERVICE_ID + " TEXT,"
                    + SERVICE_NAME + " TEXT,"
                    + PRICE + " TEXT,"
                    + DISCOUNT + " TEXT,"
                    + QUANTITY + " TEXT,"
                    + IMG_LINK + " TEXT"
                    + ")";


    public CartModel() {
    }


    public CartModel(int id, String category_name, String sub_category_name, String service_id, String service_name, String price, String discount, String quantity, String img_link) {
        this.id = id;
        this.category_name = category_name;
        this.sub_category_name = sub_category_name;
        this.service_id = service_id;
        this.service_name = service_name;
        this.price = price;
        this.discount = discount;
        this.quantity = quantity;
        this.img_link = img_link;
    }

//    public CartModel(String category_name, String sub_category_name, String service_id, String price, String discount, String img_link) {
//        this.category_name = category_name;
//        this.sub_category_name = sub_category_name;
//        this.service_id = service_id;
//        this.price = price;
//        this.discount = discount;
//        this.img_link = img_link;
//    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getSub_category_name() {
        return sub_category_name;
    }

    public void setSub_category_name(String sub_category_name) {
        this.sub_category_name = sub_category_name;
    }

    public String getSub_category_id() {
        return service_id;
    }

    public void setSub_category_id(String service_id) {
        this.service_id = service_id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }


    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getImg_link() {
        return img_link;
    }

    public void setImg_link(String img_link) {
        this.img_link = img_link;
    }
}