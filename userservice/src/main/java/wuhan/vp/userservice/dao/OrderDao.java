package wuhan.vp.userservice.dao;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//
@FeignClient(value = "order-service",fallback = OrderDaoFallback.class)
public interface OrderDao {

    @GetMapping("/hello")
    String test();

}
