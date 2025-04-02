package kr.co.kwonshzzang.sensordatasimulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SensorDataSimulatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SensorDataSimulatorApplication.class, args);
    }

}
