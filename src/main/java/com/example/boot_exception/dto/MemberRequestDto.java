package com.example.boot_exception.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class MemberRequestDto {

    @Max(value = 3, message = "가입한 회원이 10명 이상입니다.")
    private int id;

    @NotNull(message = "이름은 필수입니다.")
    @Size(min = 2, message = "이름을 2글자 이상 입력해주세요.")
    private String name;

    @Min(value = 18, message = "18세 이상 회원가입 가능합니다.")
    private int age;

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public int getAge() {
        return age; // Getter 메서드
    }


}
