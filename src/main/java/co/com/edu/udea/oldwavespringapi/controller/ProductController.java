package co.com.edu.udea.oldwavespringapi.controller;

import co.com.edu.udea.oldwavespringapi.dto.ItemDetail;
import co.com.edu.udea.oldwavespringapi.dto.Page;
import co.com.edu.udea.oldwavespringapi.exception.ApiNotFoundException;
import co.com.edu.udea.oldwavespringapi.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Product")
@RequiredArgsConstructor
@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    @ApiOperation(value = "Busca productos por descripcion", notes = "Productos que contengan la palabra a bsucar")
    @GetMapping()
    public ResponseEntity<Page> getProductsByName(
            @ApiParam(name = "name", type = "String", value = "Producto a buscar", example = "Iphone", required = true)
            @RequestParam(name = "name") String name,
            @ApiParam(name = "page", type = "String", value = "Página a buscar", example = "1", required = true)
            @RequestParam(name = "page") Integer page,
            @ApiParam(name = "size", type = "String", value = "Productos por página", example = "5", required = true)
            @RequestParam(name = "size") Integer size){
        return ResponseEntity.ok(productService.getPage(name, page, size));
    }

    @ApiOperation(value = "Busca producto por codigo", notes = "Detalles del producto con codigo")
    @GetMapping("/{code}/detail")
    public ResponseEntity<ItemDetail> getProductsByName(
            @ApiParam(name = "code", type = "String", value = "Código del producto", example = "1234", required = true)
            @PathVariable(name = "code") String productCode){
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
