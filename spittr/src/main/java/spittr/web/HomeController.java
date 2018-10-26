package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller // 声明为一个控制器
@RequestMapping("/")
public class HomeController {

    @RequestMapping(method = GET) // 处理对 "/" 的 GET 请求
    public String home() {
        return "home"; // 视图名为 home
    }
}
