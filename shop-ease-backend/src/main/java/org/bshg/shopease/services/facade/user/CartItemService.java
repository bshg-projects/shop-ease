package org.bshg.shopease.services.facade.user;
import org.bshg.shopease.entity.core.user.CartItem;
import org.bshg.shopease.entity.core.product.Product;
import org.bshg.shopease.entity.core.user.Cart;
import org.bshg.shopease.zutils.service.IService;
import java.util.List;
public interface CartItemService extends IService<CartItem> {
int deleteByCartId(Long id);
List<CartItem> findByCartId(Long id);
int deleteByProductId(Long id);
List<CartItem> findByProductId(Long id);
}