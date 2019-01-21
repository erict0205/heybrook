package com.tutorial.demo.web.api;

import com.tutorial.demo.domain.Member;
import com.tutorial.demo.model.MemberAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberApiController {
    @Autowired
    private MemberAccount memberAccount;

    @RequestMapping("/memberApi/memberTest")
    public MemberAccount memberTest() {
        MemberAccount memberAccount = new MemberAccount();
        memberAccount.setAddress("南投縣");
        memberAccount.setCellphone("0987987987");
        memberAccount.setEmail("test@gmail.com");
        memberAccount.setId(1);
        memberAccount.setPassword("98787");
        return memberAccount;
    }
}
