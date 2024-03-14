
package org.bshg.shopease.services.impl.transaction;
import org.bshg.shopease.entity.core.transaction.PaymentMethod;
import org.bshg.shopease.repository.transaction.PaymentMethodDao;
import org.bshg.shopease.services.facade.transaction.PaymentMethodService;
import org.bshg.shopease.entity.core.transaction.Payment;
import org.bshg.shopease.services.facade.transaction.PaymentService;
import org.bshg.shopease.zutils.service.ServiceImpl;
import org.bshg.shopease.zutils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class PaymentMethodServiceImpl extends ServiceImpl<PaymentMethod, PaymentMethodDao> implements PaymentMethodService {
public PaymentMethodServiceImpl(PaymentMethodDao dao) {
super(dao);
}
@Override
public List<PaymentMethod> findAllOptimized() {
return dao.findAllOptimized();
}
@Override
public void deleteAssociatedObjects(PaymentMethod item) {
if (item == null || item.getId() == null) return;
paymentService.deleteByPaymentMethodId(item.getId());
}
@Lazy @Autowired private PaymentService paymentService;
}