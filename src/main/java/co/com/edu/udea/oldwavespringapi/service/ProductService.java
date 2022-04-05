package co.com.edu.udea.oldwavespringapi.service;

import co.com.edu.udea.oldwavespringapi.dto.ItemDetail;
import co.com.edu.udea.oldwavespringapi.dto.Page;

public interface ProductService {

     Page getPage(String name, Integer pageNumber, Integer size);

     ItemDetail getProductDetails(String product_code);
}
