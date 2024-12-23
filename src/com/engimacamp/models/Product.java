package com.engimacamp.models;

import com.engimacamp.models.enums.Category;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Product {
    private String productId;
    private String name;
    private Category category;
    private BigDecimal buyPrice;
    private BigDecimal sellPrice;
    private int stock;
    private int minStock;
    private LocalDate expiryDate;
    private LocalDate lastRestockDate;

    public Product(String productId, String name, Category category, BigDecimal buyPrice, BigDecimal sellPrice, int stock, int minStock, LocalDate expiryDate) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.stock = stock;
        this.minStock = minStock;
        this.expiryDate = expiryDate;
        this.lastRestockDate = LocalDate.now();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getMinStock() {
        return minStock;
    }

    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDate getLastRestockDate() {
        return lastRestockDate;
    }

    public void setLastRestockDate(LocalDate lastRestockDate) {
        this.lastRestockDate = lastRestockDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", buyPrice=" + buyPrice +
                ", sellPrice=" + sellPrice +
                ", stock=" + stock +
                ", minStock=" + minStock +
                ", expiryDate=" + expiryDate +
                ", lastRestockDate=" + lastRestockDate +
                '}';
    }
}
