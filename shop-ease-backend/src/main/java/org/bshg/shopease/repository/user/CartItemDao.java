package org.bshg.shopease.repository.user;
import org.bshg.shopease.entity.core.user.CartItem;
import org.bshg.shopease.entity.core.product.Product;
import org.bshg.shopease.entity.core.user.Cart;
import org.bshg.shopease.zutils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface CartItemDao extends Repository<CartItem, Long> {
int deleteByCartId(Long id);
List<CartItem> findByCartId(Long id);
int deleteByProductId(Long id);
List<CartItem> findByProductId(Long id);
}