package co.com.edu.udea.oldwavespringapi.service;

import co.com.edu.udea.oldwavespringapi.dto.ItemDetail;
import co.com.edu.udea.oldwavespringapi.dto.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    Page getPage(String name, Pageable pageable);

    ItemDetail getProductDetails(String product_code);
}
