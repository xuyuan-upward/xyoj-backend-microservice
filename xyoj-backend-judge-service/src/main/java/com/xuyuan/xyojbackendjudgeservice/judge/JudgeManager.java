package com.xuyuan.xyojbackendjudgeservice.judge;

import com.xuyuan.xyojbackendjudgeservice.judge.strategy.DefaultJudgeStrategy;
import com.xuyuan.xyojbackendjudgeservice.judge.strategy.JavaLanguageJudgeStrategy;
import com.xuyuan.xyojbackendjudgeservice.judge.strategy.JudgeContext;
import com.xuyuan.xyojbackendjudgeservice.judge.strategy.JudgeStrategy;
import com.xuyuan.xyojbackendmodel.model.codesandbox.JudgeInfo;
import com.xuyuan.xyojbackendmodel.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }

}
