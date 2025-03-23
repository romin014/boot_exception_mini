package com.example.boot_exception.dto;

import com.example.boot_exception.entity.Member;
import lombok.Getter;

@Getter
public class MemberResponseDto {
    private String name;
    private int age;

    public MemberResponseDto(Member member){
        this.name = member.getName();
        this.age = member.getAge();
    }
}
