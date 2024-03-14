
package org.bshg.shopease.services.impl.transaction;
import org.bshg.shopease.entity.core.transaction.Address;
import org.bshg.shopease.repository.transaction.AddressDao;
import org.bshg.shopease.services.facade.transaction.AddressService;
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
public class AddressServiceImpl extends ServiceImpl<Address, AddressDao> implements AddressService {
public AddressServiceImpl(AddressDao dao) {
super(dao);
}
@Override
public void deleteAssociatedList(Address item) {
if (item == null || item.getId() == null) return;
userService.deleteByAddressId(item.getId());
}
@Override
public void createAssociatedList(Address item) {
if (item == null || item.getId() == null) return;
ServiceHelper.createList(item, Address::getUsers, User::setAddress, userService);
}
@Override
public void updateAssociatedList(Address item) {
if (item == null || item.getId() == null) return;
ServiceHelper.updateList(item,userService::findByAddressId,Address::getUsers,User::setAddress,userService);
}
@Lazy @Autowired private UserService userService;
}