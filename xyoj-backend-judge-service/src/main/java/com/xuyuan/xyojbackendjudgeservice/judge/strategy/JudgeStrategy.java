package com.xuyuan.xyojbackendjudgeservice.judge.strategy;


import com.xuyuan.xyojbackendmodel.model.codesandbox.JudgeInfo;

/**
 * 判题策略 （策略模式）
 */
public interface JudgeStrategy {

    /**
     * 执行判题
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext);
}
