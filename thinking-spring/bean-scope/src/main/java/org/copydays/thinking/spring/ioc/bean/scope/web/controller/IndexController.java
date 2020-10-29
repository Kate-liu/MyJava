package org.copydays.thinking.spring.ioc.bean.scope.web.controller;

import org.copydays.thinking.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 首页 Spring Web MVC Controller
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
@Controller
public class IndexController {

    @Autowired
    private User user;

    // @RequestScope
    //
    // 结论：
    // 1.页面注入的对象是一个 被 CGLAB 提升的代理对象，每一次请求的对象是一样的，看@后面的数字
    // 2.每一次返回页面的对象，是一个新创建的对象，可以从
    // org.springframework.web.context.request.AbstractRequestAttributesScope.get() 方法中，
    // scopedObject 对象看到，看@后面的数字
    //
    // @SessionScope
    //
    // 结论:
    // 1.如果没有记录本地的 Cookie，会在每一次请求创建新的对象
    // 2.如果使用浏览器，则会记录本地的 Cookie， 保持与服务器的链接，每一次链接返回的对象是同一个
    // 具体的 Session 机制，可以查看 org.springframework.web.context.request.SessionScope.get()

    @GetMapping("/index.html")
    public String index(Model model) {
        // jsp EL 变量搜索路径： page -> request -> session -> application(ServletContext)

        // @ApplicationScope
        //
        // 结论:
        // userObject ，存在渲染上下文中
        // user 对象，存在与 ServletContext 上下文中，名称叫做 scopedTarget.user，
        // 在 org.springframework.web.context.request.SessionScope.get() 中，查看 name 即可看到
        model.addAttribute("userObject", user);
        return "index";
    }
}

