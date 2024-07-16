package com.xuyuan.xyojbackendjudgeservice.judge.strategy;

import com.xuyuan.xyojbackendmodel.model.codesandbox.JudgeInfo;
import com.xuyuan.xyojbackendmodel.model.dto.question.JudgeCase;
import com.xuyuan.xyojbackendmodel.model.entity.Question;
import com.xuyuan.xyojbackendmodel.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * 上下文（用于定义在策略中传递的参数）
 */
@Data
public class JudgeContext {

    private JudgeInfo judgeInfo;

    private List<String> testOutputList;

    private List<String> runOutputList;

//    private List<JudgeCase> judgeCaseList;

    private Question question;

    private QuestionSubmit questionSubmit;

}
