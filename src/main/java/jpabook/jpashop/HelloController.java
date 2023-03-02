package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) { //Model에 데이터를 실어서 뷰에 넘길 수 있음
        model.addAttribute("data", "hello!!!");
        return "hello"; //return은 화면 이름 templates/hello.html로 이동
    }
}
