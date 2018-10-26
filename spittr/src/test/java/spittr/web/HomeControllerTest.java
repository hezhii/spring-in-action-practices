package spittr.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

// 这个测试没有站在 Spring MVC 控制器的视角进行测试。
// 没有断言当接收到针对 "/" 的 GET 请求时会调用 home() 方法，也没有真正判断 home 就是视图的名称。
// 不过从 Spring 3.2 开始，可以按照控制器的方式来测试 Spring MVC 中的控制器。
//public class HomeControllerTest {
//    @Test
//    public void testHomePage() throws Exception {
//        HomeController controller = new HomeController();
//        assertEquals("home", controller.home());
//    }
//}

public class HomeControllerTest {
    @Test
    public void testHomePage() throws Exception {
        HomeController controller = new HomeController();
        MockMvc mockMvc = standaloneSetup(controller).build(); // 搭建 MockMvc
        mockMvc.perform(get("/")) // 对 "/" 执行 GET 请求
                .andExpect(view().name("home")); // 预期得到 home 视图
    }
}