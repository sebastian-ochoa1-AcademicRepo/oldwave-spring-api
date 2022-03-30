package co.com.edu.udea.oldwavespringapi.dto;

import co.com.edu.udea.oldwavespringapi.model.Product;
import lombok.Data;

import java.util.List;

@Data
public class ItemDetail {
    public ItemDetail(Product product) {
        this.productCode = product.getProductCode();
        this.name = product.getName();
        this.description = product.getDescription();
        this.brand = product.getBrand();
        this.city = product.getCity();
        this.price = product.getPrice();
        this.reseller = product.getReseller();
        this.rating = product.getRating();
        this.images = product.getImages();
    }

    private String productCode;
    private String name;
    private String description;
    private String brand;
    private String city;
    private Integer price;
    private String reseller;
    private Integer rating;
    private List<String> images;
}
