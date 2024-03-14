package org.bshg.shopease.services.facade.user;
import org.bshg.shopease.entity.core.user.Order;
import org.bshg.shopease.entity.core.user.User;
import org.bshg.shopease.entity.core.user.OrderItem;
import org.bshg.shopease.zutils.service.IService;
import java.util.List;
public interface OrderService extends IService<Order> {
int deleteByUserId(Long id);
List<Order> findByUserId(Long id);
}