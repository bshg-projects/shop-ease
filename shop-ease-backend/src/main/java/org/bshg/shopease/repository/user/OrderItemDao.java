package org.bshg.shopease.repository.user;
import org.bshg.shopease.entity.core.user.OrderItem;
import org.bshg.shopease.entity.core.user.Order;
import org.bshg.shopease.entity.core.product.Product;
import org.bshg.shopease.zutils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface OrderItemDao extends Repository<OrderItem, Long> {
int deleteByOrderId(Long id);
List<OrderItem> findByOrderId(Long id);
int deleteByProductId(Long id);
List<OrderItem> findByProductId(Long id);
}