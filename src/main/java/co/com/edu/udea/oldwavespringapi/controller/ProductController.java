package co.com.edu.udea.oldwavespringapi.controller;

import co.com.edu.udea.oldwavespringapi.dto.ItemDetail;
import co.com.edu.udea.oldwavespringapi.dto.Page;
import co.com.edu.udea.oldwavespringapi.exception.ApiNotFoundException;
import co.com.edu.udea.oldwavespringapi.service.ProductService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    @ApiOperation(value = "Busca productos por descripcion", notes = "Productos que contengan la palabra a bsucar")
    @GetMapping()
    public ResponseEntity<Page> getProductsByName(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "page") Integer page,
            @RequestParam(name = "size") Integer size){
        PageRequest pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(productService.getPage(name, pageRequest));
    }

    @ApiOperation(value = "Busca producto por codigo", notes = "Detalles del producto con codigo")
    @GetMapping("/detail")
    public ResponseEntity<ItemDetail> getProductsByName(
            @RequestParam(name = "code") String productCode){
        if(productCode==null){
            throw new ApiNotFoundException("400 Trying");
        }
        try{
            return ResponseEntity.ok(productService.getProductDetails(productCode));
        }catch (NullPointerException e){
            throw new ApiNotFoundException("No se encontró un producto con el código enviado");
        }
    }
}
