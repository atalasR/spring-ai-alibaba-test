package com.ai.demo;

import com.alibaba.cloud.ai.dashscope.api.DashScopeApi;
import com.alibaba.cloud.ai.dashscope.chat.DashScopeChatModel;
import com.alibaba.cloud.ai.dashscope.chat.DashScopeChatOptions;
import com.alibaba.cloud.ai.graph.agent.ReactAgent;
import com.alibaba.cloud.ai.graph.exception.GraphRunnerException;
import org.junit.Test;
import org.springframework.ai.chat.model.ChatModel;

public class AgentsTester {






    /**
     * 高级模型配置
     */
    @Test
    public void test2() throws GraphRunnerException {
        //创建ChatModel
        String apiKey = System.getenv("AI_DASHSCOPE_API_KEY");
        // 创建DashScopeApi实例
        DashScopeApi dashScopeApi = DashScopeApi.builder()
                .apiKey(apiKey)
                .build();
        //创建ChatModel
        ChatModel chatModel = DashScopeChatModel.builder()
                .dashScopeApi(dashScopeApi)
                .defaultOptions(DashScopeChatOptions.builder()
                        .model(DashScopeChatModel.DEFAULT_MODEL_NAME)//模型名称
                        .temperature(0.7) //控制随机性
                        .maxToken(2000) //最大输出长度
                        .topP(0.9) //核采样，控制输出的多样性
                        .topK(50) //采样候选池的大小（top-k）。例如，topk = 50 表示只考虑得分最高的 50 个标记进行随机采样。较大的值增加随机性；较小的值增加确定性。
                        .build()
                )
                .build();
        //基于模型，指定agent的名称，创建agent
        ReactAgent simpleModelAgent = ReactAgent.builder()
                .model(chatModel)
                .name("simple_model_agent")
                .build();
    }


    /**
     * 基本模型配置
     */
    @Test
    public void test1() {
        //创建ChatModel
        String apiKey = System.getenv("AI_DASHSCOPE_API_KEY");
        // 创建DashScopeApi实例
        DashScopeApi dashScopeApi = DashScopeApi.builder()
                .apiKey(apiKey)
                .build();
        //创建ChatModel
        ChatModel chatModel = DashScopeChatModel.builder()
                .dashScopeApi(dashScopeApi)
                .build();
        //基于模型，指定agent的名称，创建agent
        ReactAgent simpleModelAgent = ReactAgent.builder()
                .model(chatModel)
                .name("simple_model_agent")
                .build();

    }
}
