package wuhan.vp.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import wuhan.vp.userservice.feign.OrderDao;
import wuhan.vp.userservice.message.SourceSender;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class UserserviceApplication {

    @Autowired
    OrderDao orderDao;

    @Autowired
    SourceSender sourceSender;

//    @Value("${girlname}")
//    private String girlname;

    public static void main(String[] args) {
        SpringApplication.run(UserserviceApplication.class, args);
    }

    /**
     * 假如这个客户端要提供一个getUser的方法
     * @return
     */
    @GetMapping(value = "/getUser/{id}")
    @ResponseBody
    public Map<String,Object> getUser(@PathVariable("id") int id){
        Map<String,Object> data = new HashMap<>();
        data.put("id",id);
//        data.put("userName",girlname);
        data.put("from","provider-A");
        return data;
    }

    @GetMapping("/visitOrderHello")
    public String hello(){

        return orderDao.test();
    }


    @GetMapping("/testSendRbtmq")
    public String testSendRbtmq(){
        sourceSender.send("testSendRbtmq"+new Date());
        return "success";
    }

}
