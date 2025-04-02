package kr.co.kwonshzzang.sensordatasimulator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
public class SensorDataSimulatorConfig {
    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .build();
    }
}
