package com.study.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.study.springcloud.entities.Dept;
import com.study.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean addDept(@RequestBody Dept dept) {
        return deptService.addDept(dept);
    }

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "getDeptError")
    public Dept getById(@PathVariable("id") Long id) {
        if(deptService.getById(id) == null){
            throw new RuntimeException("该id:"+ id +"没有对应信息");
        }
        return deptService.getById(id);
    }

    public Dept getDeptError(@PathVariable("id") Long id){
        return new Dept().setDeptNo(id).setDName("该id:"+ id + "没有对应的信息,null--@HystrixCommand")
                .setDb_source("no this database in Mysql");
    }

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> getAll() {
        return deptService.getAll();
    }

    @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
    public Object discovery(){
        List<String> list = discoveryClient.getServices();
        System.out.println("*****"+list);

        List<ServiceInstance> srvList = discoveryClient.getInstances("MICROSPRINGCLOUD-DEPT");
        for (ServiceInstance element : srvList){
            System.out.println(element.getServiceId() + "\t" +element.getHost() + "\t"
            + element.getPort() + "\t" +element.getUri());
        }
        return this.discoveryClient;
    }


}
