package haitang.service.Impl;
import com.github.pagehelper.PageHelper;
import haitang.dao.ProductDao;
import haitang.domain.Product;
import haitang.service.ProductService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional//事务，后期会用到
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAll(int page ,int size) {


        PageHelper.startPage(page,size);
        return productDao.findAll();
    }

    @Override
    public Product findById(String pid) {

        return productDao.findById(pid);
    }

    @Override
    public void add(Product product) {

        productDao.add(product);
    }

    @Override
    public void del(String id) {
        productDao.del(id);
    }

    @Override
    public void updateById(Product product) {
        productDao.updateById(product);
    }

    @Override
    public List<Product> findAllByOrder(String order,int page,int size) {
        PageHelper.startPage(page,size);
        return productDao.findAllByOrder(order);
    }


}
