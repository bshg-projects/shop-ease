package org.bshg.shopease.services.facade.user;
import org.bshg.shopease.entity.core.user.OrderItem;
import org.bshg.shopease.entity.core.user.Order;
import org.bshg.shopease.entity.core.product.Product;
import org.bshg.shopease.zutils.service.IService;
import java.util.List;
public interface OrderItemService extends IService<OrderItem> {
int deleteByOrderId(Long id);
List<OrderItem> findByOrderId(Long id);
int deleteByProductId(Long id);
List<OrderItem> findByProductId(Long id);
}