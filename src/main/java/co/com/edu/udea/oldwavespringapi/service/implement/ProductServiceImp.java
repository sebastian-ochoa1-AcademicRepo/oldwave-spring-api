package co.com.edu.udea.oldwavespringapi.service.implement;

import co.com.edu.udea.oldwavespringapi.dto.Item;
import co.com.edu.udea.oldwavespringapi.dto.ItemDetail;
import co.com.edu.udea.oldwavespringapi.dto.Page;
import co.com.edu.udea.oldwavespringapi.model.Product;
import co.com.edu.udea.oldwavespringapi.repository.ProductRepository;
import co.com.edu.udea.oldwavespringapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Page getPage(String name, Integer pageNumber, Integer size) {
        Pageable pageable = PageRequest.of(Math.toIntExact(pageNumber/size), size);
        List<Product> productList = productRepository.findByNameContainingIgnoreCase(name , pageable);
        List<Item> items = new ArrayList<>();
        for (Product product : productList){
            Item item = new Item(updateSearchQuantity(product));
            items.add(item);
        }
        Page page = new Page();
        page.setItems(items);
        page.setTotal(items.size());
        page.setPage(pageNumber);
        page.setSize(pageable.getPageSize());
        return page;
    }

    private Product updateSearchQuantity(Product product){
        product.setSearchQuantity(product.getSearchQuantity() + 1);
        productRepository.save(product);
        return product;
    }


    @Override
    public ItemDetail getProductDetails(String productCode) {
        return productToItemDetail(productRepository.getProductDetailsByProductCode(productCode));
    }

    private ItemDetail productToItemDetail(Product product){
        return new ItemDetail(product);
    }

}
