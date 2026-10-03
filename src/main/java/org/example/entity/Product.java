package org.example.entity;

import org.example.utils.GetInput;

import java.time.LocalDate;
import java.util.Scanner;

public class Product {
    private Long productId ;
    private String productName ;
    private Float  productPrice ;
    private String productTitle ;
    private LocalDate productCreated ;
    private String productCatalog ;
    private boolean productStatus ;

    public Product() {
    }

    public Product(Long productId, String productName, Float productPrice, String productTitle, LocalDate productCreated, String productCatalog, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productTitle = productTitle;
        this.productCreated = productCreated;
        this.productCatalog = productCatalog;
        this.productStatus = productStatus;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public LocalDate getProductCreated() {
        return productCreated;
    }

    public void setProductCreated(LocalDate productCreated) {
        this.productCreated = productCreated;
    }

    public String getProductCatalog() {
        return productCatalog;
    }

    public void setProductCatalog(String productCatalog) {
        this.productCatalog = productCatalog;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public void InputData(Scanner scanner ){
        this.productName = GetInput.getString(scanner,"Nhập vào tên sản phẩm : ");
        this.productTitle = GetInput.getString(scanner,"Nhập vào tiêu đề sản phẩm : ");
        this.productPrice = GetInput.getFloat(scanner,"Nhập vào giá sản phẩm : " , 1,9999.999f);
        this.productCreated = LocalDate.now();
        this.productCatalog = GetInput.getString(scanner , "Nhập vào danh mục của sản phẩm : ");
        this.productStatus = GetInput.getBoolean(scanner,"Nhập vào trạng thái của sản phẩm (1- đang bán , 0- đang hết hàng) : ");
    }

  

    public void displayData(){
        System.out.printf("| Id : %-3d | Product Name : %-20s | Title : %-20s | Price : %-5.2f | Catalog : %-15s | Status : %-15s |\n",
                this.productId,this.productName,this.productTitle,this.productPrice,this.productCatalog,this.productStatus ? "Đang bán" : "Đang hết hàng");
    }
}
