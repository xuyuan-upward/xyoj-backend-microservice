package com.xuyuan.xyojbackendjudgeservice.judge.codesandbox;

import com.xuyuan.xyojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.xuyuan.xyojbackendmodel.model.codesandbox.ExecuteCodeResponse;

/**
 * 代码沙箱接口定义
 */
public interface CodeSandbox {

    /**
     * 执行代码
     *
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
