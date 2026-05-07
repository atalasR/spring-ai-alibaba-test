package com.ai.demo;

import org.springframework.ai.chat.model.ToolContext;

import java.util.function.BiFunction;

/**
 * 天气查询工具
 */
public class WeatherTool implements BiFunction<WeatherToolRequest, ToolContext, String> {
    @Override
    public String apply(WeatherToolRequest request, ToolContext toolContext) {
        return "sunny";
    }
}