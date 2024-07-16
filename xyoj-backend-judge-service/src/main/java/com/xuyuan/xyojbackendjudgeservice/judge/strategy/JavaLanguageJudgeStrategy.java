package com.xuyuan.xyojbackendjudgeservice.judge.strategy;

import cn.hutool.json.JSONUtil;
import com.xuyuan.xyojbackendmodel.model.codesandbox.JudgeInfo;
import com.xuyuan.xyojbackendmodel.model.dto.question.JudgeCase;
import com.xuyuan.xyojbackendmodel.model.dto.question.JudgeConfig;
import com.xuyuan.xyojbackendmodel.model.entity.Question;
import com.xuyuan.xyojbackendmodel.model.enums.JudgeInfoMessageEnum;

import java.util.List;
import java.util.Optional;

/**
 * Java 程序的判题策略
 */
public class JavaLanguageJudgeStrategy implements JudgeStrategy {

    /**
     * 执行判题
     * @param judgeContext
     * @return
     */
    @Override
    public JudgeInfo doJudge(JudgeContext judgeContext) {
        JudgeInfo judgeInfo = judgeContext.getJudgeInfo();
        // 沙箱运行配置
        Long memory = Optional.ofNullable(judgeInfo.getMemory()).orElse(0L)/1024;
        Long time = Optional.ofNullable(judgeInfo.getTime()).orElse(0L);
        // 测试输出用例
        List<String> testOutputList = judgeContext.getTestOutputList();
        // 运行输出用例
        List<String> runOutputList = judgeContext.getRunOutputList();
        // 获取题目配置信息
        Question question = judgeContext.getQuestion();
//        List<JudgeCase> judgeCaseList = judgeContext.getJudgeCaseList();
        JudgeInfoMessageEnum judgeInfoMessageEnum = JudgeInfoMessageEnum.ACCEPTED;
        JudgeInfo judgeInfoResponse = new JudgeInfo();
        judgeInfoResponse.setMemory(memory);
        judgeInfoResponse.setTime(time);
        // 先判断沙箱执行的结果输出数量是否和预期输出数量相等
        System.out.println("testOutputList.size" + testOutputList.size());
        System.out.println("runOutputList.size()" + runOutputList.size());
        if (testOutputList.size() != runOutputList.size()) {
            judgeInfoMessageEnum = JudgeInfoMessageEnum.WRONG_ANSWER;
            judgeInfoResponse.setMessage(judgeInfoMessageEnum.getText());
            return judgeInfoResponse;
        }
        // 依次判断每一项输出和预期输出是否相等
        for (int i = 0; i < testOutputList.size(); i++) {
            String testOutput = testOutputList.get(i);
            String runOutput = runOutputList.get(i);
            System.out.println("testOutput" + ":" + testOutput);
            System.out.println("runOutput" + ":" + runOutput);
            boolean flag = !testOutput.equals(runOutput);
            System.out.println("flag"+ flag);
            if (flag) {
                System.out.println("直接返回了这是什么意思？");
                judgeInfoMessageEnum = JudgeInfoMessageEnum.WRONG_ANSWER;
                judgeInfoResponse.setMessage(judgeInfoMessageEnum.getText());
                return judgeInfoResponse;
            }
        }
        // 判断题目限制
        String judgeConfigStr = question.getJudgeConfig();
        JudgeConfig judgeConfig = JSONUtil.toBean(judgeConfigStr, JudgeConfig.class);
        Long needMemoryLimit = judgeConfig.getMemoryLimit();
        Long needTimeLimit = judgeConfig.getTimeLimit();
        if (memory > needMemoryLimit) {
            judgeInfoMessageEnum = JudgeInfoMessageEnum.MEMORY_LIMIT_EXCEEDED;
            judgeInfoResponse.setMessage(judgeInfoMessageEnum.getText());
            return judgeInfoResponse;
        }
        // Java 程序本身需要额外执行 10 秒钟
        long JAVA_PROGRAM_TIME_COST = 10000L;
        if ((time - JAVA_PROGRAM_TIME_COST) > needTimeLimit) {
            judgeInfoMessageEnum = JudgeInfoMessageEnum.TIME_LIMIT_EXCEEDED;
            judgeInfoResponse.setMessage(judgeInfoMessageEnum.getText());
            return judgeInfoResponse;
        }
        judgeInfoResponse.setMessage(judgeInfoMessageEnum.getText());
        return judgeInfoResponse;
    }
}
