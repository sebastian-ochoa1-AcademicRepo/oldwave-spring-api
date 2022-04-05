package co.com.edu.udea.oldwavespringapi.service.implement;


import co.com.edu.udea.oldwavespringapi.dto.Item;
import co.com.edu.udea.oldwavespringapi.dto.ItemDetail;
import co.com.edu.udea.oldwavespringapi.dto.Page;
import co.com.edu.udea.oldwavespringapi.model.Product;
import co.com.edu.udea.oldwavespringapi.repository.ProductRepository;
import co.com.edu.udea.oldwavespringapi.service.ProductService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;


public class ProductServiceImpTest {

    @Mock
    ProductRepository productRepository;

    ProductService productService;

    private Product product;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        productService = new ProductServiceImp(productRepository);

        product = new Product();
        product.setProductCode("1");
        product.setName("Iphone");
        product.setSearchQuantity(1);
    }

    @Test
    public void debeRetornarPageCuandoNameSeaIphoneYPageNumberSeaUnoYSizeSeaCinco(){
        //Arrange
        List<Product> products = new ArrayList<>();
        products.add(product);
        Item item = new Item(product);
        List<Item> items= new ArrayList<>();
        items.add(item);
        Page pageEsperado = new Page();
        pageEsperado.setItems(items);
        Page pageObtenido;
        when(productRepository.findByNameContainingIgnoreCase(eq("Iphone"), any())).thenReturn(products);
        //Act
        pageObtenido = productService.getPage("Iphone", 1, 5);
        //Assert
        Assert.assertEquals(pageEsperado.getItems().get(0).getName(),pageObtenido.getItems().get(0).getName());
    }

    @Test
    void getProductDetails() {
        //Arrange
        ItemDetail itemDetailEsperado = new ItemDetail(product);
        ItemDetail itemDetailDado;
        when(productRepository.getProductDetailsByProductCode(any())).thenReturn(product);
        //Act
        itemDetailDado = productService.getProductDetails("1");
        //Assert
        Assert.assertEquals(itemDetailEsperado,itemDetailDado);
    }
}
