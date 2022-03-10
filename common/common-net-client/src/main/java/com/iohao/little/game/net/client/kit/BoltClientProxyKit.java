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
package com.iohao.little.game.net.client.kit;

import com.iohao.little.game.net.client.common.BoltClientProxy;
import com.iohao.little.game.net.message.common.ModuleKey;
import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 洛朱
 * @date 2022-01-16
 */
@UtilityClass
public class BoltClientProxyKit {
    Map<ModuleKey, BoltClientProxy> boltClientProxyMap = new HashMap<>();

    public void put(ModuleKey moduleKey, BoltClientProxy boltClientProxy) {
        boltClientProxyMap.put(moduleKey, boltClientProxy);
    }

    public BoltClientProxy get(ModuleKey moduleKey) {
        return boltClientProxyMap.get(moduleKey);
    }
}
