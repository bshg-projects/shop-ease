package org.bshg.shopease.repository.product;
import org.bshg.shopease.entity.core.product.Product;
import org.bshg.shopease.entity.core.category.Category;
import org.bshg.shopease.entity.core.user.OrderItem;
import org.bshg.shopease.entity.core.user.CartItem;
import org.bshg.shopease.entity.core.product.Image;
import org.bshg.shopease.zutils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface ProductDao extends Repository<Product, Long> {
int deleteByCategoryId(Long id);
List<Product> findByCategoryId(Long id);
@Query("SELECT NEW Product(item.id,item.name) FROM Product item")
List<Product> findAllOptimized();
}