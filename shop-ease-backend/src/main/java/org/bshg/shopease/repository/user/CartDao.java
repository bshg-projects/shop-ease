package org.bshg.shopease.repository.user;
import org.bshg.shopease.entity.core.user.Cart;
import org.bshg.shopease.entity.core.user.User;
import org.bshg.shopease.entity.core.user.CartItem;
import org.bshg.shopease.zutils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface CartDao extends Repository<Cart, Long> {
int deleteByUserId(Long id);
List<Cart> findByUserId(Long id);
}