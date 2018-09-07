package com.project.invoice_manager;

import net.minidev.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceManagerApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Test
    public void contextLoads() {
    }

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void UserTest() throws Exception{
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", "123");
        map.put("user_mail", "testMail");
        map.put("user_name", "testName");
        map.put("user_phone", "testPhone");
        map.put("user_qq","testQQ");
        map.put("user_gender", "testGender");
        map.put("user_account", "testAccount");

        MvcResult result = mockMvc.perform(post("/user/alterInfo")
                .contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(map)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());

    }

    @Test
    public void GroupTestUpload() throws Exception{
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", "admin");
        map.put("group_name", "testGroup");
        MvcResult result = mockMvc.perform(post("/group/upload")
                .contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(map)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());

    }

    @Test
    public void GroupTestAddMember() throws Exception{
        Map<String, Object> map = new HashMap<>();
        map.put("group_id", "4028668165b40d2e0165b40d3c2d0000");
        map.put("user_id", "123");

        MvcResult result = mockMvc.perform(post("/group/addMember")
                .contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(map)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());

    }

    @Test
    public void InvoiceTestUpload() throws Exception{
        Map<String, Object> map = new HashMap<>();
        map.put("invoice_id", "testId");
        map.put("invoice_name", "testName");
        map.put("invoice_type", "test");
        map.put("invoice_money", "100");
        map.put("user_id", "admin");
        map.put("partner", "123");
        map.put("location", "SH");
        map.put("fee_type", "test");
        map.put("invoice_time", "2018/9/7");

        MvcResult result = mockMvc.perform(post("/invoice/upload")
                .contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(map)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());

    }

    @Test
    public void InvoiceTestMyInvoice() throws Exception{
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", "admin");

        MvcResult result = mockMvc.perform(post("/invoice/myInvoice")
                .contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(map)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());

    }
}
