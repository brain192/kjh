package com.test.test.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import com.test.test.dto.TestDto;
import com.test.test.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
@Controller
public class TestController {

    @RequestMapping(value = "/home")
    public String home(){

        return "index.html";
    }


    @RequestMapping("/test")
    public ModelAndView test() throws Exception{
        ModelAndView mav = new ModelAndView("test");
        mav.addObject("name", "kjh");

        List<String> testList = new ArrayList<String>();
        testList.add("a");
        testList.add("b");
        testList.add("c");

        mav.addObject("list", testList);
        return mav;
    }

}



@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {
    private final TestService testService;

    @GetMapping("/test/{str}")
    public String test(@PathVariable String str) {
        TestDto res = testService.testServiceMethod(str);

        return "hello "+res.getTestStr() ;
    }
}
 */

@Controller
public class TestController {

    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "/index";
    }

    @GetMapping("/admin/success")
    public String adminSuccess() {
        return "/admin/success";
    }
    @GetMapping("/member/success")
    public String memberSuccess() {
        return "/member/success";
    }
    @GetMapping("/guest/success")
    public String guestSuccess() {
        return "/guest/success";
    }
}