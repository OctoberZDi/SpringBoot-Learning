package com.didispace.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.awt.SunHints;

/**
 * @ProjectName: MyGitHub-OctoberZDi-springboot-learning
 * @ClassName: ZHTestController
 * @Description: 测试swagger的类
 * @Author: zhangdi
 * @Date: 2020年01月19日 09:22
 **/
@Api(value = "这是一个测试swagger2的一个类")
@RestController
@RequestMapping(value = "test")
public class ZHTestController {

    @ApiOperation(value = "这个hello方法", notes = "这是个notes啊")
    @RequestMapping(value = "hello/{name}/{age}", method = RequestMethod.DELETE)
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    public String hello(@ApiParam(name = "name", value = "姓名", required = true) @PathVariable String name, @ApiParam(name = "age", value = "年龄", required = true) @PathVariable int age) {
        return "hello world" + name + "," + age;
    }
}
