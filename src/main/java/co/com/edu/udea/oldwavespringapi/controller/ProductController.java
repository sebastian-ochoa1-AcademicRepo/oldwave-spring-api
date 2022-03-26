package co.com.edu.udea.oldwavespringapi.controller;

import co.com.edu.udea.oldwavespringapi.dto.ItemForSearchDto;
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
    public ResponseEntity<List<ItemForSearchDto>> getProductsByName(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "page") Integer page,
            @RequestParam(name = "size") Integer size){
        PageRequest pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(productService.getProductsByName(name, pageRequest));
    }
}
