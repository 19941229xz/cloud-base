package wuhan.vp.userservice.feign;

import org.springframework.stereotype.Component;

@Component
public class OrderDaoFallback implements OrderDao{
    @Override
    public String test() {
        return "order service  visit  fail";
    }
}
