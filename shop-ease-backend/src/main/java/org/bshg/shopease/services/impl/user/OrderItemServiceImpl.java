
package org.bshg.shopease.services.impl.user;
import org.bshg.shopease.entity.core.user.OrderItem;
import org.bshg.shopease.repository.user.OrderItemDao;
import org.bshg.shopease.services.facade.user.OrderItemService;
import org.bshg.shopease.entity.core.user.Order;
import org.bshg.shopease.services.facade.user.OrderService;
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
public class OrderItemServiceImpl extends ServiceImpl<OrderItem, OrderItemDao> implements OrderItemService {
public OrderItemServiceImpl(OrderItemDao dao) {
super(dao);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByOrderId(Long id){
if (id == null) return 0;
return dao.deleteByOrderId(id);
}
@Override
public List<OrderItem> findByOrderId(Long id){
return dao.findByOrderId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByProductId(Long id){
if (id == null) return 0;
return dao.deleteByProductId(id);
}
@Override
public List<OrderItem> findByProductId(Long id){
return dao.findByProductId(id);
}
@Lazy @Autowired private OrderService orderService;
@Lazy @Autowired private ProductService productService;
}