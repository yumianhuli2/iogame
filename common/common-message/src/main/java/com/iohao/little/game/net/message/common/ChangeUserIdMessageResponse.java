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
package com.iohao.little.game.net.message.common;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 变更 userId 响应
 *
 * @author 洛朱
 * @date 2022-01-19
 */
@Data
public class ChangeUserIdMessageResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = -3776596417948970990L;
    /** true: userId 变更成功 */
    boolean success;
    /** 变更后的 userId */
    long userNewId;
}
