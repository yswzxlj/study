package com.example.mydockertest.sentinel.config;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: lich
 * @Description:
 * @Date: 2022/8/15 14:32
 * @Version: v1.0
 */
@Configuration
public class SentinelAspectConfiguration {
    @Bean
    public SentinelResourceAspect sentinelResourceAspect() {
        initSentinel();
        return new SentinelResourceAspect();
    }

    private  void initSentinel(){
        List<FlowRule> lists = new ArrayList<>();
        FlowRule testSentinel = new FlowRule("testSentinel");
        testSentinel.setCount(2);
        testSentinel.setGrade(RuleConstant.FLOW_GRADE_QPS);
        testSentinel.setLimitApp("default");
        lists.add(testSentinel);
        FlowRuleManager.loadRules(lists);
    }
}
