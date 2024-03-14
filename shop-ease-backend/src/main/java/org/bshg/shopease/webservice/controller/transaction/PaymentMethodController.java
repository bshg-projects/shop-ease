package org.bshg.shopease.webservice.controller.transaction;
import org.bshg.shopease.entity.core.transaction.PaymentMethod;
import org.bshg.shopease.services.facade.transaction.PaymentMethodService;
import org.bshg.shopease.webservice.converter.transaction.PaymentMethodConverter;
import org.bshg.shopease.webservice.dto.transaction.PaymentMethodDto;
import org.bshg.shopease.zutils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/paymentmethod")
public class PaymentMethodController extends AbstractRestApi<PaymentMethod,PaymentMethodDto,PaymentMethodService,PaymentMethodConverter> {
public PaymentMethodController( PaymentMethodService service, PaymentMethodConverter converter) {
super(service, converter);
}
@Override
@GetMapping("/id/{id}")
public ResponseEntity<PaymentMethodDto> findById(@PathVariable Long id) {
return super.findById(id);
}
@Override
@GetMapping
public ResponseEntity<List<PaymentMethodDto>> findAll() {
return super.findAll();
}
@Override
@GetMapping("/optimized")
public ResponseEntity<List<PaymentMethodDto>> findAllOptimized() {
return super.findAllOptimized();
}
@Override
@PostMapping
public ResponseEntity<PaymentMethodDto> save(@RequestBody PaymentMethodDto dto) {
return super.save(dto);
}
@Override
@PostMapping("/all")
public ResponseEntity<List<PaymentMethodDto>> save(@RequestBody List<PaymentMethodDto> dtos) {
return super.save(dtos);
}
@Override
@PutMapping()
public ResponseEntity<PaymentMethodDto> update(@RequestBody PaymentMethodDto dto) {
return super.update(dto);
}
@Override
@PutMapping("/all")
public ResponseEntity<List<PaymentMethodDto>> update(@RequestBody List<PaymentMethodDto> dtos) {
return super.update(dtos);
}
@Override
@DeleteMapping
public ResponseEntity<PaymentMethodDto> delete(@RequestBody PaymentMethodDto dto) {
return super.delete(dto);
}
@Override
@DeleteMapping("/all")
public ResponseEntity<List<PaymentMethodDto>> delete(@RequestBody List<PaymentMethodDto> dtos) {
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
}