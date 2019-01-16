package com.tutorial.demo.repository;

import com.tutorial.demo.model.MemberAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class MemberDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addMember(MemberAccount memberAccount) {
        System.out.println("EXCUTE INSERT MEMBER");
        jdbcTemplate.update("INSERT INTO member_account(PASSWORD, EMAIL, ADDRESS,CELLPHONE,CREATE_DATE) "
                        + "VALUES (?,?,?,?,?)", memberAccount.getPassword(), memberAccount.getEmail(),
                memberAccount.getAddress(), memberAccount.getCellphone(), memberAccount.getCreateTime());
    }
}
