package com.gooney.controller;

import com.gooney.domain.User;
import com.gooney.entity.JsonData;
import com.gooney.entity.TranferRequest;
import com.gooney.service.UserService;
import com.gooney.task.TaskAsync;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.concurrent.Future;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/findAll")
    @ResponseBody
    public List<User> findAll(){
        return userService.findAll();
    }
    @RequestMapping("/userList")
    public String userList(){
        return "tl/userList";
    }
    @RequestMapping(value = "/tranferMoney",method = RequestMethod.POST)
    @ResponseBody
    public JsonData tranferMoney(@RequestBody TranferRequest request){
        JsonData jsonData=null;
        try {
            Boolean r=userService.tranfer(request.getSource(),request.getTarget(),request.getMoney());
            if(r)
                jsonData = new JsonData(200,"成功");
        }catch (Exception e){
            jsonData = new JsonData(500,e.getMessage(),"");
        }
        return jsonData;
    }
    @RequestMapping(value = "/tranfer",method = RequestMethod.GET)
    public String tranfer(){
        return "tl/tranfer";
    }

    @Autowired
    private TaskAsync taskAsync;

    /**
     * 异步方法
     * @return
     * @throws Exception
     */
    @GetMapping("/async_test")
    @ResponseBody
    public String async_Test() throws Exception {
        long begin=System.currentTimeMillis();
//        taskAsync.task1();
//        taskAsync.task2();
//        taskAsync.task3();
        Future<String> t4=taskAsync.task4();
        Future<String> t5=taskAsync.task5();
        Future<String> t6=taskAsync.task6();
        while (true){
            if(t4.isDone() && t5.isDone() && t6.isDone())
                break;
        }
        System.out.println(t4.get()+t5.get()+t6.get());
        long end=System.currentTimeMillis();
        return "{\""+(end-begin)+"\"}";
    }
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping("/log_test")
    @ResponseBody
    public String log_test(){
        logger.info("info日志");
        logger.debug("debug日志");
        logger.error("error日志");
        logger.warn("warn日志");
        return "ok";
    }
}
