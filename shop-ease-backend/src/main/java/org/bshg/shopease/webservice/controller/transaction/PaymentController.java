package org.bshg.shopease.webservice.controller.transaction;
import org.bshg.shopease.entity.core.transaction.Payment;
import org.bshg.shopease.services.facade.transaction.PaymentService;
import org.bshg.shopease.webservice.converter.transaction.PaymentConverter;
import org.bshg.shopease.webservice.dto.transaction.PaymentDto;
import org.bshg.shopease.zutils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/payment")
public class PaymentController extends AbstractRestApi<Payment,PaymentDto,PaymentService,PaymentConverter> {
public PaymentController( PaymentService service, PaymentConverter converter) {
super(service, converter);
}
@Override
@GetMapping("/id/{id}")
public ResponseEntity<PaymentDto> findById(@PathVariable Long id) {
return super.findById(id);
}
@Override
@GetMapping
public ResponseEntity<List<PaymentDto>> findAll() {
return super.findAll();
}
@Override
@GetMapping("/optimized")
public ResponseEntity<List<PaymentDto>> findAllOptimized() {
return super.findAllOptimized();
}
@Override
@PostMapping
public ResponseEntity<PaymentDto> save(@RequestBody PaymentDto dto) {
return super.save(dto);
}
@Override
@PostMapping("/all")
public ResponseEntity<List<PaymentDto>> save(@RequestBody List<PaymentDto> dtos) {
return super.save(dtos);
}
@Override
@PutMapping()
public ResponseEntity<PaymentDto> update(@RequestBody PaymentDto dto) {
return super.update(dto);
}
@Override
@PutMapping("/all")
public ResponseEntity<List<PaymentDto>> update(@RequestBody List<PaymentDto> dtos) {
return super.update(dtos);
}
@Override
@DeleteMapping
public ResponseEntity<PaymentDto> delete(@RequestBody PaymentDto dto) {
return super.delete(dto);
}
@Override
@DeleteMapping("/all")
public ResponseEntity<List<PaymentDto>> delete(@RequestBody List<PaymentDto> dtos) {
return super.delete(dtos);
}
@Override
@DeleteMapping("/id/{id}")
public ResponseEntity<Long> deleteById(@PathVariable Long id) {
return super.deleteById(id);
}
@Override
@DeleteMapping("/ids")
public ResponseEntity<List<Long>> deleteByIdIn(@RequestParam("id") List<Long> ids) {
return super.deleteByIdIn(ids);
}
@DeleteMapping("/paymentmethod/id/{id}")
public ResponseEntity<Long> deleteByPaymentMethodId(@PathVariable Long id){
return super.deleteProcess(id, service::deleteByPaymentMethodId);
}
@GetMapping("/paymentmethod/id/{id}")
public ResponseEntity<PaymentDto> findByPaymentMethodId(@PathVariable Long id){
return super.findByChildId(id, service::findByPaymentMethodId);
}
}