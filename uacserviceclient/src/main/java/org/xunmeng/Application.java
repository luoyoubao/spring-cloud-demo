package org.xunmeng;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
// @EnableDiscoveryClient
public class Application {
    static final String SERVICE_NAME = "UACSERVICE";

    @Autowired
    private RestTemplate client;

    // @Autowired
    // private DiscoveryClient discoveryClient;

    /**
     * LoadBalanced 注解表明restTemplate使用LoadBalancerClient执行请求
     *
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        RestTemplate template = new RestTemplate();
        SimpleClientHttpRequestFactory factory = (SimpleClientHttpRequestFactory) template.getRequestFactory();
        factory.setConnectTimeout(3000);
        factory.setReadTimeout(3000);
        return template;
    }

    @RequestMapping("/hello/{name}")
    public String helloWorld(@PathVariable("name") String name) {
        System.err.println("client call================>");
        return client.getForObject("http://" + SERVICE_NAME + "/user/" + name,
                String.class);
    }

    // @RequestMapping("/discovery")
    // public String doDiscoveryService() {
    // StringBuilder buf = new StringBuilder();
    // List<String> serviceIds = discoveryClient.getServices();
    // if (!CollectionUtils.isEmpty(serviceIds)) {
    // for (String s : serviceIds) {
    // System.out.println("serviceId:" + s);
    // List<ServiceInstance> serviceInstances = discoveryClient.getInstances(s);
    // if (!CollectionUtils.isEmpty(serviceInstances)) {
    // for (ServiceInstance si : serviceInstances) {
    // buf.append("[" + si.getServiceId() + " host=" + si.getHost() + " port=" +
    // si.getPort() + " uri=" + si.getUri() + "]");
    // }
    // } else {
    // buf.append("no service.");
    // }
    // }
    // }
    //
    // return buf.toString();
    // }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
    }
}