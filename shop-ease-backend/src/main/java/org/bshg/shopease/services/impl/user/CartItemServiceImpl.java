
package org.bshg.shopease.services.impl.user;
import org.bshg.shopease.entity.core.user.CartItem;
import org.bshg.shopease.repository.user.CartItemDao;
import org.bshg.shopease.services.facade.user.CartItemService;
import org.bshg.shopease.entity.core.user.Cart;
import org.bshg.shopease.services.facade.user.CartService;
import org.bshg.shopease.entity.core.product.Product;
import org.bshg.shopease.services.facade.product.ProductService;
import org.bshg.shopease.zutils.service.ServiceImpl;
import org.bshg.shopease.zutils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class CartItemServiceImpl extends ServiceImpl<CartItem, CartItemDao> implements CartItemService {
public CartItemServiceImpl(CartItemDao dao) {
super(dao);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByCartId(Long id){
if (id == null) return 0;
return dao.deleteByCartId(id);
}
@Override
public List<CartItem> findByCartId(Long id){
return dao.findByCartId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByProductId(Long id){
if (id == null) return 0;
return dao.deleteByProductId(id);
}
@Override
public List<CartItem> findByProductId(Long id){
return dao.findByProductId(id);
}
@Lazy @Autowired private CartService cartService;
@Lazy @Autowired private ProductService productService;
}