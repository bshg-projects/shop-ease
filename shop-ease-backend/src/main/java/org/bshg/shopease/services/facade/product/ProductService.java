package org.bshg.shopease.services.facade.product;
import org.bshg.shopease.entity.core.product.Product;
import org.bshg.shopease.entity.core.category.Category;
import org.bshg.shopease.entity.core.user.OrderItem;
import org.bshg.shopease.entity.core.user.CartItem;
import org.bshg.shopease.entity.core.product.Image;
import org.bshg.shopease.zutils.service.IService;
import java.util.List;
public interface ProductService extends IService<Product> {
int deleteByCategoryId(Long id);
List<Product> findByCategoryId(Long id);
}