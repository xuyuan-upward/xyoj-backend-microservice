package com.xuyuan.xyojbackendquestionservice;

import com.xuyuan.xyojbackendmodel.model.entity.Question;
import com.xuyuan.xyojbackendquestionservice.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class XyojBackendQuestionServiceApplicationTests {

    @Resource
    private QuestionService questionService;

    @Test
    void contextLoads() {
        Question byId = questionService.getById(1);
        System.out.println(byId);
    }

}
