
package org.bshg.shopease.services.impl.user;
import org.bshg.shopease.entity.core.user.Order;
import org.bshg.shopease.repository.user.OrderDao;
import org.bshg.shopease.services.facade.user.OrderService;
import org.bshg.shopease.entity.core.user.OrderItem;
import org.bshg.shopease.services.facade.user.OrderItemService;
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
public class OrderServiceImpl extends ServiceImpl<Order, OrderDao> implements OrderService {
public OrderServiceImpl(OrderDao dao) {
super(dao);
}
@Override
public void deleteAssociatedList(Order item) {
if (item == null || item.getId() == null) return;
orderItemService.deleteByOrderId(item.getId());
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByUserId(Long id){
if (id == null) return 0;
List<Order> found = findByUserId(id);
if (found == null) return 0;
found.forEach(this::deleteAssociated);
return dao.deleteByUserId(id);
}
@Override
public List<Order> findByUserId(Long id){
return dao.findByUserId(id);
}
@Override
public void createAssociatedList(Order item) {
if (item == null || item.getId() == null) return;
ServiceHelper.createList(item, Order::getOrderItem, OrderItem::setOrder, orderItemService);
}
@Override
public void updateAssociatedList(Order item) {
if (item == null || item.getId() == null) return;
ServiceHelper.updateList(item,orderItemService::findByOrderId,Order::getOrderItem,OrderItem::setOrder,orderItemService);
}
@Lazy @Autowired private OrderItemService orderItemService;
@Lazy @Autowired private UserService userService;
}