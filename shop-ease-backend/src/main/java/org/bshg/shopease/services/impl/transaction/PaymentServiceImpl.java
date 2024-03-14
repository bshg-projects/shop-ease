
package org.bshg.shopease.services.impl.transaction;
import org.bshg.shopease.entity.core.transaction.Payment;
import org.bshg.shopease.repository.transaction.PaymentDao;
import org.bshg.shopease.services.facade.transaction.PaymentService;
import org.bshg.shopease.entity.core.transaction.PaymentMethod;
import org.bshg.shopease.services.facade.transaction.PaymentMethodService;
import org.bshg.shopease.zutils.service.ServiceImpl;
import org.bshg.shopease.zutils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class PaymentServiceImpl extends ServiceImpl<Payment, PaymentDao> implements PaymentService {
public PaymentServiceImpl(PaymentDao dao) {
super(dao);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByPaymentMethodId(Long id){
return dao.deleteByPaymentMethodId(id);
}
@Override
public Payment findByPaymentMethodId(Long id){
return dao.findByPaymentMethodId(id);
}
@Lazy @Autowired private PaymentMethodService paymentMethodService;
}