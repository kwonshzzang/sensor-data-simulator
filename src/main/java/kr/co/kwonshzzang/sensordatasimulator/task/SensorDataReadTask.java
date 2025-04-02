package kr.co.kwonshzzang.sensordatasimulator.task;

import jakarta.annotation.PostConstruct;
import kr.co.kwonshzzang.sensordatasimulator.dto.SensorDataDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Instant;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class SensorDataReadTask {
    private final WebClient webClient;
    @Value("${application.host}")
    private String dtHost;
    @Value("${application.url}")
    private String dtUrl;
    @Value("${application.tagNumber}")
    private int tagNumbers;
    private int[] sensorIdxList;

    @PostConstruct
    public void init() {
        sensorIdxList = new int[tagNumbers];
    }

    public void runTask(Map<Integer, SensorDataDto> dataMap, int sensorIdx) {
        if (sensorIdxList[sensorIdx] == dataMap.size() - 1)
            sensorIdxList[sensorIdx] = 0;

        SensorDataDto sensorDataDto  = dataMap.get(sensorIdxList[sensorIdx]);
        sensorDataDto.setTime(Instant.now());

        webClient.post()                  // POST method
                .uri(dtHost + dtUrl)               // baseUrl 이후 uri
                .bodyValue(sensorDataDto)    // set body value
                .retrieve()                      // client message 전송
                .bodyToMono(SensorDataDto.class)    // body type : SensorDataDto
                .block();                         // await
        log.info("Send Sensor data - {}", sensorDataDto);
        sensorIdxList[sensorIdx]++;
    }
}
