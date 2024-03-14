package org.bshg.shopease.services.facade.user;
import org.bshg.shopease.entity.core.user.User;
import org.bshg.shopease.entity.core.user.Order;
import org.bshg.shopease.entity.core.transaction.Address;
import org.bshg.shopease.entity.core.user.Cart;
import org.bshg.shopease.zutils.service.IService;
import java.util.List;
public interface UserService extends IService<User> {
int deleteByAddressId(Long id);
List<User> findByAddressId(Long id);
}