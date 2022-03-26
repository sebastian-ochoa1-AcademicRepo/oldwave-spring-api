package co.com.edu.udea.oldwavespringapi.service;

import co.com.edu.udea.oldwavespringapi.dto.ItemForSearchDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<ItemForSearchDto> getProductsByName(String name, Pageable pageable);
}
