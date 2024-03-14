package org.bshg.shopease.services.facade.user;
import org.bshg.shopease.entity.core.user.Cart;
import org.bshg.shopease.entity.core.user.User;
import org.bshg.shopease.entity.core.user.CartItem;
import org.bshg.shopease.zutils.service.IService;
import java.util.List;
public interface CartService extends IService<Cart> {
int deleteByUserId(Long id);
List<Cart> findByUserId(Long id);
}