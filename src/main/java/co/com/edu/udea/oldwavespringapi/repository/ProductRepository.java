package co.com.edu.udea.oldwavespringapi.repository;

import co.com.edu.udea.oldwavespringapi.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>, JpaSpecificationExecutor<Product> {
    List <Product> getAllByNameLike(String name, Pageable pageable);

    Product getProductDetailsByProductCode(String productCode);
}
