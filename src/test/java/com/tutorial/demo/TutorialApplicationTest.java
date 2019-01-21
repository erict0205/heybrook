package com.tutorial.demo;

import com.tutorial.demo.domain.Member;
import com.tutorial.demo.repository.MemberApiRepository;
import com.tutorial.demo.web.api.MemberApiController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MemberApiController.class)
@WebAppConfiguration
public class TutorialApplicationTest {
//    @Autowired
//    private MemberApiRepository memberApiRepository; //加入MemberRepository

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    MemberApiRepository memberApiRepository;

    MockMvc mvc; //創建MockMvc類的物件

    @Before
    public void setup() {
        Member member = new Member();
        member.setId(1L);
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void contextLoads() throws Exception {
        String uri = "/memberApi/1";
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(
                MediaType.APPLICATION_JSON_VALUE
        )).andReturn();
        int status = result.getResponse().getStatus();
        System.err.println(status);
        Assert.assertEquals("錯誤", 200, status);
    }
}
