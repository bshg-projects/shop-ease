package org.bshg.shopease.services.facade.transaction;
import org.bshg.shopease.entity.core.transaction.Payment;
import org.bshg.shopease.entity.core.transaction.PaymentMethod;
import org.bshg.shopease.zutils.service.IService;
import java.util.List;
public interface PaymentService extends IService<Payment> {
int deleteByPaymentMethodId(Long id);
Payment findByPaymentMethodId(Long id);
}