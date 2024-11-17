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


*/


/**
 * java.lang.IllegalArgumentException: Name for argument of type [java.lang.String] not specified, and parameter name information not found in class file either.
 * 스프링 핵심 원리 기본편 관련
 * No qualifying bean of type 'com.example.demo.MemberRepository' available: expected single matching bean but found 2: memoryMemberRepository,memberRepository
 * 스프링 부트 3.2부터 자바 컴파일러에 -parameters 옵션을 넣어주어야 애노테이션의 이름을 생략할 수 있다.
 * 주로 아래의 애노테이션을 사용할 때 문제가 발생한다.
 * @RequestParam, @PathVariable, @Autowired, @ConfigurationProperties
 *
 * 1. IntelliJ IDEA에서 File -> Settings를 연다. (Mac은 IntelliJ IDEA -> Settings)
 * 2. Build, Execution, Deployment → Compiler → Java Compiler로 이동한다.
 * 3. Additional command line parameters라는 항목에 다음을 추가한다.
 * -parameters
 * 4. out 폴더를 삭제하고 다시 실행한다. 꼭 out 폴더를 삭제해야 다시 컴파일이 일어난다.
 */

/**
 * <p> DB 테스트 연결 URL</p>
 * @author hs
 *
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    @GetMapping("/test/{str}")
    public String test(@PathVariable String str) {
//    public String test(String str) {

        System.out.println("pathValue:" + str);

        TestDto res = testService.testServiceMethod(str);

        System.out.println("test/test url call ---->");

        return "hello :"+res.getTestStr() ;
    }

    @GetMapping("/test2/{str}")
    public String test2(@PathVariable String str) {

        System.out.println("test/test url call ---->" + str);

        TestDto result = testService.testServiceMethod2(str);

        return "input:" + result.toString();
    }
}


//@Controller
//public class TestController {
//
//    @GetMapping(value = {"/", "/index"})
//    public String index() {
//        return "/index";
//    }
//
//    @GetMapping("/admin/success")
//    public String adminSuccess() {
//        return "/admin/success";
//    }
//    @GetMapping("/member/success")
//    public String memberSuccess() {
//        return "/member/success";
//    }
//    @GetMapping("/guest/success")
//    public String guestSuccess() {
//        return "/guest/success";
//    }
//}