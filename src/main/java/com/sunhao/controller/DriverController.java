package com.sunhao.controller;

import com.github.pagehelper.PageInfo;
import com.sun.org.apache.regexp.internal.RE;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.sunhao.entity.Car;
import com.sunhao.entity.Driver;
import com.sunhao.entity.DriverType;
import com.sunhao.service.DriverService;
import com.sunhao.utils.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.tools.jconsole.HTMLPane;

import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Soundbank;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 项目名称：driverCar
 * 类 名 称：DriverController
 * 类 描 述：TODO
 * 创建时间：2019/11/25 8:53 下午
 * 创 建 人：sunhao
 */
@Controller
@RequestMapping
public class DriverController {

    @Autowired
    DriverService driverService;
    @Value("/Users/sunhao/Desktop/day/pic")
    String updloadPath;

    Logger log = Logger.getLogger(DriverController.class);


    @GetMapping("register")
    public  String register(HttpServletRequest request){
        List<DriverType> typeList = driverService.getList();
        request.setAttribute("typeList",typeList);
        request.setAttribute("driver",new Driver());
        return "register";
    }

    @PostMapping("register")
    public String register(HttpServletRequest request,
                           @Valid @ModelAttribute("driver") Driver driver,
                           BindingResult result){
        if (result.hasErrors()){
            List<DriverType> typeList = driverService.getList();
            request.setAttribute("typeList",typeList);
            return "register";
        }

        driverService.addDriver(driver);

        return "redirect:login";
    }

    @GetMapping("login")
    public String login(HttpServletRequest request){
    request.setAttribute("driver",new Driver());
        return "login";
    }

    @PostMapping("login")
    public String login(HttpServletRequest request, Driver driver) {

        Driver loginDriver = driverService.login(driver);
        if (loginDriver==null){
            request.setAttribute("error","用户名密码错误");
            return "login";
        }

        request.getSession().setAttribute("user",loginDriver);
        System.out.println(loginDriver);
        return "redirect:carList";
    }

    //查看当前司机能开的车
    @RequestMapping("carList")
    public String carList(HttpServletRequest request){

        //获取用户信息
        Driver loginDriver = (Driver) request.getSession().getAttribute("user");
        System.out.println("loginDriver"+loginDriver);

        //  获取当前司机驾驶照的类型
        /**
         * 根据司机注册时的驾驶照类型（driver中 DriverType等于中间表的code） 来获取对应驾照可以驾驶的车辆
         */

        DriverType driverType= driverService.getDriverTypeByCode(loginDriver.getDriverType());

        System.out.println(driverType+"+++++");
        String drivable = "";

        if (!StringUtils.isBlank(driverType.getInclude())){
            //获取司机的驾驶证可以驾驶的全部类型  例：c1 可以驾驶c1,c2,c3,c4
            drivable=loginDriver.getDriverType()+","+driverType.getInclude();
        }else {
            //为空 说明当前驾驶证只能驾驶这一个类型的车
            drivable = loginDriver.getDriverType();
        }
        //多个类型 中间有逗号，需要隔开，字符串类型需要加'',
            drivable=drivable.replaceAll(",","','");
        System.out.println(drivable+"------");

        // 获取可以驾驶的车辆 用中间表的驾驶照类型获取车辆信息
        List<Car>  carList =  driverService.carlist(drivable);


        request.setAttribute("carList",carList);
        return "carList";
    }

    /**
     * 跳转到添加的页面
     * @param request
     * @return
     */
    @GetMapping("addcar")
    public String addCar(HttpServletRequest request
    ) {

        List<DriverType>  typeList =  driverService.getList();
        request.setAttribute("typeList", typeList);

        request.setAttribute("car", new Car());
        return "addcar";

    }


    /**
     *
     * @param file
     * @return  保存文件的相对路径
     * @throws IllegalStateException
     * @throws IOException
     */
    private String processFile(MultipartFile file) throws IllegalStateException, IOException {

        log.info("updloadPath is "  + updloadPath);


        //1 求扩展名  "xxx.jpg"
        String suffixName =  file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
        String fileNamePre = UUID.randomUUID().toString();
        // 计算出新的文件名称
        String fileName = fileNamePre + suffixName;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String path = dateFormat.format(new Date());
        File pathFile  = new File(updloadPath + "/" + path);
        if(!pathFile.exists()) {
            pathFile.mkdirs();
        }

        // 最终的新的文件名称
        String newFileName = updloadPath + "/"+ path + "/" + fileName;
        file.transferTo(new File(newFileName));

        return path + "/" + fileName ;
    }

    /**
     * 添加车辆
     * @param request
     * @param car
     * @param result
     * @return
     * @throws IOException
     * @throws IllegalStateException
     */
    @PostMapping("addcar")
    public String addCar(HttpServletRequest request,
                         @Valid @ModelAttribute("car") Car car,
                         MultipartFile file,
                         BindingResult result) throws IllegalStateException, IOException {

        if(result.hasErrors()) {
            List<DriverType>  typeList =  driverService.getList();
            request.setAttribute("typeList", typeList);
            return "addcar";
        }
        if(!file.isEmpty()) {
            String url = processFile(file);
            car.setPicUrl(url);
        }

        driverService.addCar(car);
        return "redirect:carList";

    }





}
