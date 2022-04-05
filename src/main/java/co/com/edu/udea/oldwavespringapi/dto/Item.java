package co.com.edu.udea.oldwavespringapi.dto;

import co.com.edu.udea.oldwavespringapi.model.Product;
import lombok.Data;

@Data
public class Item {
    public Item(Product product) {
        this.productCode = product.getProductCode();
        this.name = product.getName();
        this.brand = product.getBrand();
        this.thumbnail = product.getThumbnail();
        this.city = product.getCity();
        this.price = product.getPrice();
        this.seller = product.getSeller();
        this.rating = product.getRating();
        this.searchQuantity = product.getSearchQuantity();
    }

    private String productCode;
    private String name;
    private String brand;
    private String thumbnail;
    private String city;
    private Integer price;
    private String seller;
    private Integer rating;
    private Integer searchQuantity;
}
