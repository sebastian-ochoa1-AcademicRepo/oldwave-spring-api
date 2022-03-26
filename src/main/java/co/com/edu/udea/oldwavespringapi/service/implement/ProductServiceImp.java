package co.com.edu.udea.oldwavespringapi.service.implement;

import co.com.edu.udea.oldwavespringapi.dto.ItemForSearchDto;
import co.com.edu.udea.oldwavespringapi.model.Product;
import co.com.edu.udea.oldwavespringapi.repository.ProductRepository;
import co.com.edu.udea.oldwavespringapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ItemForSearchDto> getProductsByName(String name, Pageable pageable) {
        List<Product> productList = productRepository.getAllByNameLike("%"+ name +"%", pageable);
        List<ItemForSearchDto> items = new ArrayList<ItemForSearchDto>();
        for (Product product : productList){
            ItemForSearchDto item = new ItemForSearchDto(product);
            items.add(item);
        }
        return items;
    }
}
