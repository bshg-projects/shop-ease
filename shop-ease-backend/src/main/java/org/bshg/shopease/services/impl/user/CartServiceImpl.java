
package org.bshg.shopease.services.impl.user;
import org.bshg.shopease.entity.core.user.Cart;
import org.bshg.shopease.repository.user.CartDao;
import org.bshg.shopease.services.facade.user.CartService;
import org.bshg.shopease.entity.core.user.CartItem;
import org.bshg.shopease.services.facade.user.CartItemService;
import org.bshg.shopease.entity.core.user.User;
import org.bshg.shopease.services.facade.user.UserService;
import org.bshg.shopease.zutils.service.ServiceImpl;
import org.bshg.shopease.zutils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class CartServiceImpl extends ServiceImpl<Cart, CartDao> implements CartService {
public CartServiceImpl(CartDao dao) {
super(dao);
}
@Override
public void deleteAssociatedList(Cart item) {
if (item == null || item.getId() == null) return;
cartItemService.deleteByCartId(item.getId());
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByUserId(Long id){
if (id == null) return 0;
List<Cart> found = findByUserId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByUserId(id);
}
@Override
public List<Cart> findByUserId(Long id){
return dao.findByUserId(id);
}
@Override
public void createAssociatedList(Cart item) {
if (item == null || item.getId() == null) return;
ServiceHelper.createList(item, Cart::getCartItem, CartItem::setCart, cartItemService);
}
@Override
public void updateAssociatedList(Cart item) {
if (item == null || item.getId() == null) return;
ServiceHelper.updateList(item,cartItemService::findByCartId,Cart::getCartItem,CartItem::setCart,cartItemService);
}
@Lazy @Autowired private CartItemService cartItemService;
@Lazy @Autowired private UserService userService;
}