package com.arnold.www.controller;

/**
 * @author Arnold
 * @version V1.0
 * @className UserController
 * @description TODO
 * @date 2020/6/2
 **/
import com.alibaba.fastjson.JSONObject;
import com.arnold.www.pojo.User;
import com.arnold.www.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version: V1.0
 * @author: fendo
 * @className: UserController
 * @packageName: com.fendo.mybatis.plus.controller
 * @description: 用户Controller
 * @data: 2018-03-24 19:07
 **/
@RestController
@RequestMapping("/user")
@Api("用户操作接口")
public class UserController {

    @Autowired
    private UserService userService;

    //增删改查
    @GetMapping("/crud")
    @ApiOperation(value = "增删改查")
    @ApiResponse(code = 200, message = "success")
    public void test() {
        User user = new  User();
        user.setId("1");
        user.setSex("0");
        user.setName("小明");
        user.setPassword("12345678");
        userService.save(user);
    }

   /* *//**
     * AR 部分测试
     *//*
    @GetMapping("/insert")
    public Page<User> insert() {
        User user = new User(IdGen.getUUID(), "testAr", AgeEnum.ONE, SexEnum.FEMALE);
        System.err.println("删除所有：" + user.delete(null));
        user.insert();
        System.err.println("查询插入结果：" + user.selectById().toString());
        user.setName("mybatis-plus-ar");
        System.err.println("更新：" + user.updateById());
        return user.selectPage(new Page<User>(0, 12), null);
    }

    *//**
     * 增删改查 CRUD
     *//*
    @GetMapping("/crud")
    public User crud() {
        System.err.println("删除一条数据：" + userService.deleteById("85349feb19f04fa78a7a717f4dce031f"));
        System.err.println("deleteAll：" + userService.deleteAll());
        String IdGens = IdGen.getUUID();
        System.err.println("插入一条数据：" + userService.insert(new User(IdGens, "张三", AgeEnum.TWO, SexEnum.FEMALE)));
        User user = new User("张三", AgeEnum.TWO, SexEnum.MALE);
        boolean result = userService.insert(user);

        // 自动回写的ID
        String id = user.getId();
        System.err.println("插入一条数据：" + result + ", 插入信息：" + user.toString());
        System.err.println("查询：" + userService.selectById(id).toString());
        System.err.println("更新一条数据：" + userService.updateById(new User(IdGens, "三毛", AgeEnum.ONE, SexEnum.FEMALE)));
        for (int i = 0; i < 5; ++i) {
            userService.insert(new User( IdGen.getUUID(), "张三" + i, AgeEnum.ONE, SexEnum.FEMALE));
        }
        Page<User> userListPage = userService.selectPage(new Page<User>(1, 5), new EntityWrapper<>(new User()));
        System.err.println("total=" + userListPage.getTotal() + ", current list size=" + userListPage.getRecords().size());
        return userService.selectById(IdGens);
    }

    *//**
     * 插入 OR 修改
     *//*
    @GetMapping("/save")
    public User save() {
        String IdGens = IdGen.getUUID();
        User user = new User(IdGens, "王五", AgeEnum.ONE, SexEnum.FEMALE);
        userService.insertOrUpdate(user);
        return userService.selectById(IdGens);
    }

    @GetMapping("/add")
    public Object addUser() {
        User user = new User(IdGen.getUUID(), "张三'特殊`符号", AgeEnum.TWO, SexEnum.FEMALE);
        JSONObject result = new JSONObject();
        result.put("result", userService.insert(user));
        return result;
    }

    @GetMapping("/selectsql")
    public Object getUserBySql() {
        JSONObject result = new JSONObject();
        result.put("records", userService.selectListBySQL());
        return result;
    }

    *//**
     * 7、分页 size 一页显示数量  current 当前页码
     * 方式一：http://localhost:8080/user/page?size=1¤t=1
     * 方式二：http://localhost:8080/user/pagehelper?size=1¤t=1
     *//*

    // 参数模式分页
    @GetMapping("/pages")
    public Object page(Page page) {
        return userService.selectPage(page);
    }

    // ThreadLocal 模式分页
    @GetMapping("/pagehelper")
    public Object pagehelper(Page page) {
        PageHelper.setPagination(page);
        page.setRecords(userService.selectList(null));
        page.setTotal(PageHelper.freeTotal());//获取总数并释放资源 也可以 PageHelper.getTotal()
        return page;
    }


    *//**
     * 测试事物
     * http://localhost:8080/user/test_transactional<br>
     * 访问如下并未发现插入数据说明事物可靠！！<br>
     * http://localhost:8080/user/test<br>
     * <br>
     * 启动  Application 加上 @EnableTransactionManagement 注解其实可无默认貌似就开启了<br>
     * 需要事物的方法加上 @Transactional 必须的哦！！
     *//*
    @Transactional
    @GetMapping("/test_transactional")
    public void testTransactional() {
        String IdGens = IdGen.getUUID();
        userService.insert(new User(IdGens, "测试事物", AgeEnum.ONE, SexEnum.FEMALE));
        System.out.println(" 这里手动抛出异常，自动回滚数据 : " + IdGens);
        throw new RuntimeException();
    }
*/
}