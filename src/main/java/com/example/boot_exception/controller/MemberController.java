package com.example.boot_exception.controller;

import com.example.boot_exception.dto.MemberRequestDto;
import com.example.boot_exception.dto.MemberResponseDto;
import com.example.boot_exception.entity.Member;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/api")
@RestController
public class MemberController {
    private final Map<Long, Member> memberList = new HashMap<>();

    //회원가입 기능
    @PostMapping("/sign-up")
    public ResponseEntity<MemberResponseDto> createMember(@Valid @RequestBody MemberRequestDto dto) {
        //18세 이상 회원가입
//        if (dto.getAge() < 18) {
//            throw new CustomException("18세 이상 회원가입 가능합니다.");
//        }
        //회원수 10명 이하로 제한
//        if(memberList.size() >= 10){
//            throw new CustomException("가입한 회원이 10명 이상입니다.");
//        }
        //이름 2글자 이상으로 제한
//        if(dto.getName().length() < 2){
//            throw new CustomException("이름을 2글자 이상 입력해주세요.");
//        }
//        if (dto.getName() == null||dto.getAge() == '0'){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }

        long memberId = memberList.isEmpty() ? 1 : Collections.max(memberList.keySet()) + 1;
        Member member = new Member(dto.getName(), dto.getAge());
        memberList.put(memberId, member);

        return new ResponseEntity<>(new MemberResponseDto(member), HttpStatus.CREATED);
    }

    @GetMapping("/check/{name}")
    public ResponseEntity<String> findMemberByName(@PathVariable String name) {
        //사용 가능한 이름 확인
        for (Member member : memberList.values()) {
            if (member.getName().equals(name)) {

                return new ResponseEntity<>("이미 회원가입된 이름입니다.", HttpStatus.OK);
            }
        }

        return new ResponseEntity<>("사용 가능한 이름입니다.", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/check") // 모든 회원 조회
    public List<MemberResponseDto> findAllMembers() {
        List<MemberResponseDto> responseList = new ArrayList<>();

        for (Member member : memberList.values()) {
            MemberResponseDto responseDto = new MemberResponseDto(member);
            responseList.add(responseDto);
        }

        return responseList;
    }
}
