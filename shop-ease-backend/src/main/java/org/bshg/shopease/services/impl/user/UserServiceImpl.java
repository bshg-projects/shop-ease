
package org.bshg.shopease.services.impl.user;
import org.bshg.shopease.entity.core.user.User;
import org.bshg.shopease.repository.user.UserDao;
import org.bshg.shopease.services.facade.user.UserService;
import org.bshg.shopease.entity.core.user.Order;
import org.bshg.shopease.services.facade.user.OrderService;
import org.bshg.shopease.entity.core.user.Cart;
import org.bshg.shopease.services.facade.user.CartService;
import org.bshg.shopease.entity.core.transaction.Address;
import org.bshg.shopease.services.facade.transaction.AddressService;
import org.bshg.shopease.zutils.service.ServiceImpl;
import org.bshg.shopease.zutils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class UserServiceImpl extends ServiceImpl<User, UserDao> implements UserService {
public UserServiceImpl(UserDao dao) {
super(dao);
}
@Override
public void deleteAssociatedList(User item) {
if (item == null || item.getId() == null) return;
orderService.deleteByUserId(item.getId());
cartService.deleteByUserId(item.getId());
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByAddressId(Long id){
if (id == null) return 0;
List<User> found = findByAddressId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByAddressId(id);
}
@Override
public List<User> findByAddressId(Long id){
return dao.findByAddressId(id);
}
@Override
public void createAssociatedList(User item) {
if (item == null || item.getId() == null) return;
ServiceHelper.createList(item, User::getOrders, Order::setUser, orderService);
ServiceHelper.createList(item, User::getCarts, Cart::setUser, cartService);
}
@Override
public void updateAssociatedList(User item) {
if (item == null || item.getId() == null) return;
ServiceHelper.updateList(item,orderService::findByUserId,User::getOrders,Order::setUser,orderService);
ServiceHelper.updateList(item,cartService::findByUserId,User::getCarts,Cart::setUser,cartService);
}
@Lazy @Autowired private OrderService orderService;
@Lazy @Autowired private CartService cartService;
@Lazy @Autowired private AddressService addressService;
}