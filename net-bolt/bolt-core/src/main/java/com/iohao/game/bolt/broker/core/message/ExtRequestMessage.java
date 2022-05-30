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
package com.iohao.game.bolt.broker.core.message;

import com.iohao.game.bolt.broker.core.client.BrokerClientType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author 渔民小镇
 * @date 2022-05-30
 */
@Data
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExtRequestMessage implements Serializable {
    @Serial
    private static final long serialVersionUID = -3607944559114318088L;

    int extHash;
    /**
     * json 扩展字段
     * <pre>
     *     有特殊业务可以通过这个字段来扩展元信息
     * </pre>
     */
    String extJsonField;

    /** 开发者不需要关心，由游戏网关来赋值 */
    String address;
    /** 开发者不需要关心，由框架来赋值 */
    BrokerClientType brokerClientType;
}
