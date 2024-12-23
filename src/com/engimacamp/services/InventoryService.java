package com.engimacamp.services;

import com.engimacamp.models.Product;
import com.engimacamp.models.enums.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryService {
    private Map<String, Product> products = new HashMap<>();

    public InventoryService() {
    }

    public void addProduct(Product product) {
        this.products.put(product.getProductId(), product);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(this.products.values());
    }

    public void updateStock(String productId, int stock) {
        Product product = this.products.get(productId);
        product.setStock(stock);
    }

    public void checkLevelStock(Category category) {
        List<Product> result = new ArrayList<>();
        int i = 1;
        for (Product product : this.products.values()){
            if (category.equals(product.getCategory())){
                result.add(product);
                System.out.println(i + ". " + product.getName());
                System.out.println("\uD83D\uDCCA Stock: " + product.getStock());
                System.out.println("\uD83D\uDD0D Minimum Stock: " + product.getMinStock() + " units");
                getStatus(product.getStock(), product.getMinStock());
                i++;
            }
        }
        if (result.isEmpty()){
            System.out.println("Stok belum tersedia untuk kategori: " + category);
        }
    }
    public void getStatus(int stock, int minStock){
        double persentaseStock = (double) stock/minStock;
        if (persentaseStock >= 1) {
            System.out.println("✅ Status: OK");
        }
        if (persentaseStock >= 0.4 && persentaseStock < 1){
            System.out.println("✅ Status: LOW STOCK");
        }
        if (persentaseStock < 0.4){
            System.out.println("✅ Status: CRITICAL");
        }
    }



}
