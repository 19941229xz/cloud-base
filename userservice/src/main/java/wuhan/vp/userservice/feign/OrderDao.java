package wuhan.vp.userservice.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//
@FeignClient(value = "order-service",fallback = OrderDaoFallback.class)
public interface OrderDao {

    @GetMapping("/hello")
    String test();

}
