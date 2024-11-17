package com.test.test.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString   //toString 어노테션 추가추가
public class TestDto {

    private String testStr;

    private int id;             //ID
    private String content;     //내용

    public TestDto() {}

    public TestDto(String testStr) {
        this.testStr = testStr;
    }
}
