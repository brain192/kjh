package com.test.test.service;

import com.test.test.dto.TestDto;
import com.test.test.entity.Test;
import com.test.test.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Component
@RequiredArgsConstructor
public class TestService {

    //DTA
    private final TestRepository testRepository;

    public TestDto testServiceMethod(String str) {
//        TestDto testDto = new TestDto(str);
//        return testDto;
        return new TestDto(str);
    }


//    public TestDto testServiceMethod2(String str) {
//        Optional<Test> otTest = testRepository.findById(Integer.valueOf(str));
//        if(otTest.isEmpty()) {
//            throw new IllegalArgumentException("Test not found");
//        }
//        System.out.println(otTest.get());
//        return null;
//    }

    public TestDto testServiceMethod2(String str) {
        Optional<Test> test = Optional.ofNullable(testRepository.findById(Integer.valueOf(str)).orElseThrow(IllegalArgumentException::new));

        TestDto vo = new TestDto();

        test.ifPresent(u ->{
            vo.setId(u.getTestId());
            vo.setContent(u.getTestContents());
        });

        System.out.println(test.get());
        System.out.println(vo.toString());

        return vo;
    }

}
