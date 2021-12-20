package com.iohao.little.game.action.skeleton.core.flow;

import com.iohao.little.game.action.skeleton.core.ActionCommand;
import com.iohao.little.game.action.skeleton.core.ParamContext;
import com.iohao.little.game.action.skeleton.protocol.RequestMessage;
import com.iohao.little.game.action.skeleton.protocol.ResponseMessage;

/**
 * ActionAfter 最后的处理
 * <pre>
 *     处理完每个action后会执行这个接口实现类(前提是你配置了)
 *     目前只开放两个参数, 目的是通过cahnnel write响应数据到客户端
 *     因为不知道各个NIO框架是如何写出数据到客户端的, 所以把这个问题交给用户自行处理
 * </pre>
 *
 * @param <Request>  客户端请求的request
 * @param <Response> 响应类型
 * @author 洛朱
 * @Date 2021-12-12
 */
public interface ActionAfter<Request extends RequestMessage, Response extends ResponseMessage> {
    /**
     * 最后执行的方法, 一般将发送到客户端的逻辑存放到这里
     * <pre>
     * netty
     *     channelContext.writeAndFlush(msg);
     * </pre>
     *
     * @param paramContext  参数上下文
     * @param actionCommand actionCommand
     * @param request       request
     * @param response      response
     */
    void execute(ParamContext paramContext, ActionCommand actionCommand, Request request, Response response);
}
