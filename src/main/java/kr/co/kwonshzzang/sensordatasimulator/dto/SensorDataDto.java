package kr.co.kwonshzzang.sensordatasimulator.dto;

import lombok.*;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class SensorDataDto {
    private Instant time;
    private String dataType;
    private String sensorId;
    private String status;
    private Double aValue;
    private String dValue;
    private String tValue;
}

