package com.tutorial.demo.web;


import com.tutorial.demo.domain.Member;
import com.tutorial.demo.model.MemberAccount;
import com.tutorial.demo.repository.MemberRepository;
import com.tutorial.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {

    //透過 @RequestMapping 指定從/會被對應到此hello()方法
    @Autowired
    MemberAccount memberAccount;

    @Autowired
    MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @RequestMapping("/")
    public String hello() {
        memberAccount = new MemberAccount();
        memberAccount.setPassword("12345678");
        memberAccount.setEmail("test@gmail.com");
        memberAccount.setCellphone("0912345789");
        memberAccount.setAddress("台北市");
        memberAccount.setCreateTime(LocalDateTime.now());
        memberService.addMember(memberAccount);
        return "新增會員成功!!";
    }

    @GetMapping("/add-member")
    public String addMember() {
        List<Member> members = new ArrayList<>();
        members = memberRepository.findAll();

        for (Member member : members) {
            System.out.println(member.getId());
        }
        return "add-member";
    }
}
