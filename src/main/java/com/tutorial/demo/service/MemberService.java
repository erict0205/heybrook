package com.tutorial.demo.service;

import com.tutorial.demo.model.MemberAccount;
import com.tutorial.demo.repository.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    MemberDao memberDao;

    public void addMember(MemberAccount memberAccount) {
        memberDao.addMember(memberAccount);
    }
}
