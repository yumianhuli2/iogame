/*
 * # iohao.com . 渔民小镇
 * Copyright (C) 2021 - 2022 double joker （262610965@qq.com） . All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.iohao.game.action.skeleton.core.flow.parser;

import com.iohao.game.action.skeleton.core.ActionCommand;
import com.iohao.game.action.skeleton.core.DataCodecKit;
import com.iohao.game.action.skeleton.protocol.wrapper.IntListPb;
import com.iohao.game.action.skeleton.protocol.wrapper.IntPb;

import java.util.List;

/**
 * @author 渔民小镇
 * @date 2022-06-26
 */
final class IntMethodParser implements MethodParser {

    @Override
    public Class<?> getActualClazz(ActionCommand.MethodParamResultInfo methodParamResultInfo) {
        return methodParamResultInfo.isList() ? IntListPb.class : IntPb.class;
    }

    @Override
    public Object parseParam(byte[] data, ActionCommand.ParamInfo paramInfo) {
        if (paramInfo.isList()) {
            IntListPb intListPb = DataCodecKit.decode(data, IntListPb.class);
            return intListPb.intValues;
        }

        IntPb intPb = DataCodecKit.decode(data, IntPb.class);
        return intPb.intValue;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object parseResult(ActionCommand.ActionMethodReturnInfo actionMethodReturnInfo, Object methodResult) {

        if (actionMethodReturnInfo.isList()) {
            IntListPb intListPb = new IntListPb();
            intListPb.intValues = (List<Integer>) methodResult;
            return intListPb;
        }

        // 将结果转换为 intPb
        IntPb intPb = new IntPb();
        intPb.intValue = (int) methodResult;
        return intPb;
    }

    private IntMethodParser() {

    }

    public static IntMethodParser me() {
        return Holder.ME;
    }

    /** 通过 JVM 的类加载机制, 保证只加载一次 (singleton) */
    private static class Holder {
        static final IntMethodParser ME = new IntMethodParser();
    }
}
