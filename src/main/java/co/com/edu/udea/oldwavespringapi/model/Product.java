package co.com.edu.udea.oldwavespringapi.model;

import co.com.edu.udea.oldwavespringapi.helper.StringToListConverter;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Convert;
import java.util.List;

@Data
@Table(name = "products")
@Entity
public class Product {

    @Id
    @Column
    private String productCode;

    @Column
    private String name;
    @Column
    private String brand;
    @Column
    private String thumbnail;
    @Column
    private String city;
    @Column
    private Integer price;
    @Column
    private String seller;
    @Column
    private Integer rating;
    @Column
    private Integer searchQuantity;
    @Column
    private String description;
    @Column
    private String reseller;
    @Column
    @Convert(converter = StringToListConverter.class)
    private List<String> images;

}
