/*
 * # iohao.com . 渔民小镇
 * Copyright (C) 2021 - 2022 double joker （262610965@qq.com） . All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License..
 */
package com.iohao.little.game.action.skeleton.core.flow.interal;

import com.iohao.little.game.action.skeleton.core.ActionCommand;
import com.iohao.little.game.action.skeleton.core.exception.MsgException;
import com.iohao.little.game.action.skeleton.core.flow.ActionMethodResultWrap;
import com.iohao.little.game.action.skeleton.core.flow.FlowContext;
import com.iohao.little.game.action.skeleton.protocol.ResponseMessage;

/**
 * Default ActionMethod 结果包装器
 *
 * @author 洛朱
 * @Date 2021-12-20
 */
public class ObjectActionMethodResultWrap implements ActionMethodResultWrap {
    @Override
    public void wrap(FlowContext flowContext) {
        final ActionCommand actionCommand = flowContext.getActionCommand();
        final ResponseMessage responseMessage = flowContext.getResponse();
        final Object result = flowContext.getMethodResult();

        // 业务方法返回值
        responseMessage.setData(result);

        // 异常处理
        if (actionCommand.isThrowException() && result instanceof MsgException msgException) {
            int code = msgException.getMsgCode();
            responseMessage.setResponseStatus(code);
        }

    }
}
