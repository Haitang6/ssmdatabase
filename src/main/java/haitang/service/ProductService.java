package haitang.service;
import haitang.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductService {
    List<Product> findAll(int page ,int size );
    Product findById(String pid);
    void add(Product product);
    void del(String id);
    void updateById(Product product);
    List<Product> findAllByOrder(String orders,int page,int size);

}
