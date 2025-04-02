package kr.co.kwonshzzang.sensordatasimulator.controller;

import jakarta.annotation.PostConstruct;
import kr.co.kwonshzzang.sensordatasimulator.dto.SensorDataDto;
import kr.co.kwonshzzang.sensordatasimulator.task.SensorDataReadTask;
import kr.co.kwonshzzang.sensordatasimulator.util.NumberFormatUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@EnableAsync
@RequiredArgsConstructor
public class SensorDataController {
    private final Environment env;
    private final SensorDataReadTask task;

    @Value("${application.tagNumber}")
    private int sensorNumbers;

    private List<Map<Integer, SensorDataDto>> sensorDataMapList;

    @PostConstruct
    public void init() {
        sensorDataMapList = new ArrayList<>();
        for(int i = 0; i < sensorNumbers; i++) {
            String path = env.getProperty(String.format("application.taglist[%d].path", i));
            parseCSV(path);
        }
    }

    @Async
    @Scheduled(initialDelayString = "${application.tagList[0].initialDelay}",  fixedDelayString = "${application.tagList[0].duration}")
    public void scheduleTask_0() {
        task.runTask(sensorDataMapList.get(0), 0);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[1].initialDelay}", fixedDelayString = "${application.tagList[1].duration}")
    public void scheduleTask_1() {
        task.runTask(sensorDataMapList.get(1), 1);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[2].initialDelay}", fixedDelayString = "${application.tagList[2].duration}")
    public void scheduleTask_2() {
        task.runTask(sensorDataMapList.get(2), 2);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[3].initialDelay}", fixedDelayString = "${application.tagList[3].duration}")
    public void scheduleTask_3() {
        task.runTask(sensorDataMapList.get(3), 3);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[4].initialDelay}", fixedDelayString = "${application.tagList[4].duration}")
    public void scheduleTask_4() {
        task.runTask(sensorDataMapList.get(4), 4);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[5].initialDelay}", fixedDelayString = "${application.tagList[5].duration}")
    public void scheduleTask_5() {
        task.runTask(sensorDataMapList.get(5), 5);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[6].initialDelay}", fixedDelayString = "${application.tagList[6].duration}")
    public void scheduleTask_6() {
        task.runTask(sensorDataMapList.get(6), 6);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[7].initialDelay}", fixedDelayString = "${application.tagList[7].duration}")
    public void scheduleTask_7() {
        task.runTask(sensorDataMapList.get(7), 7);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[8].initialDelay}", fixedDelayString = "${application.tagList[8].duration}")
    public void scheduleTask_8() {
        task.runTask(sensorDataMapList.get(8), 8);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[9].initialDelay}", fixedDelayString = "${application.tagList[9].duration}")
    public void scheduleTask_9() {
        task.runTask(sensorDataMapList.get(9), 9);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[10].initialDelay}", fixedDelayString = "${application.tagList[10].duration}")
    public void scheduleTask_10() {
        task.runTask(sensorDataMapList.get(10), 10);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[11].initialDelay}", fixedDelayString = "${application.tagList[11].duration}")
    public void scheduleTask_11() {
        task.runTask(sensorDataMapList.get(11), 11);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[12].initialDelay}", fixedDelayString = "${application.tagList[12].duration}")
    public void scheduleTask_12() {
        task.runTask(sensorDataMapList.get(12), 12);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[13].initialDelay}", fixedDelayString = "${application.tagList[13].duration}")
    public void scheduleTask_13() {
        task.runTask(sensorDataMapList.get(13), 13);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[14].initialDelay}", fixedDelayString = "${application.tagList[14].duration}")
    public void scheduleTask_14() {
        task.runTask(sensorDataMapList.get(14), 14);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[15].initialDelay}", fixedDelayString = "${application.tagList[15].duration}")
    public void scheduleTask_15() {
        task.runTask(sensorDataMapList.get(15), 15);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[16].initialDelay}", fixedDelayString = "${application.tagList[16].duration}")
    public void scheduleTask_16() {
        task.runTask(sensorDataMapList.get(16), 16);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[17].initialDelay}", fixedDelayString = "${application.tagList[17].duration}")
    public void scheduleTask_17() {
        task.runTask(sensorDataMapList.get(17), 17);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[18].initialDelay}", fixedDelayString = "${application.tagList[18].duration}")
    public void scheduleTask_18() {
        task.runTask(sensorDataMapList.get(18), 18);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[19].initialDelay}", fixedDelayString = "${application.tagList[19].duration}")
    public void scheduleTask_19() {
        task.runTask(sensorDataMapList.get(19), 19);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[20].initialDelay}", fixedDelayString = "${application.tagList[20].duration}")
    public void scheduleTask_20() {
        task.runTask(sensorDataMapList.get(20), 20);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[21].initialDelay}", fixedDelayString = "${application.tagList[21].duration}")
    public void scheduleTask_21() {
        task.runTask(sensorDataMapList.get(21), 21);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[22].initialDelay}", fixedDelayString = "${application.tagList[22].duration}")
    public void scheduleTask_22() {
        task.runTask(sensorDataMapList.get(22), 22);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[23].initialDelay}", fixedDelayString = "${application.tagList[23].duration}")
    public void scheduleTask_23() {
        task.runTask(sensorDataMapList.get(23), 23);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[24].initialDelay}", fixedDelayString = "${application.tagList[24].duration}")
    public void scheduleTask_24() {
        task.runTask(sensorDataMapList.get(24), 24);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[25].initialDelay}", fixedDelayString = "${application.tagList[25].duration}")
    public void scheduleTask_25() {
        task.runTask(sensorDataMapList.get(25), 25);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[26].initialDelay}", fixedDelayString = "${application.tagList[26].duration}")
    public void scheduleTask_26() {
        task.runTask(sensorDataMapList.get(26), 26);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[27].initialDelay}", fixedDelayString = "${application.tagList[27].duration}")
    public void scheduleTask_27() {
        task.runTask(sensorDataMapList.get(27), 27);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[28].initialDelay}", fixedDelayString = "${application.tagList[28].duration}")
    public void scheduleTask_28() {
        task.runTask(sensorDataMapList.get(28), 28);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[29].initialDelay}", fixedDelayString = "${application.tagList[29].duration}")
    public void scheduleTask_29() {
        task.runTask(sensorDataMapList.get(29), 29);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[30].initialDelay}", fixedDelayString = "${application.tagList[30].duration}")
    public void scheduleTask_30() {
        task.runTask(sensorDataMapList.get(30), 30);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[31].initialDelay}", fixedDelayString = "${application.tagList[31].duration}")
    public void scheduleTask_31() {
        task.runTask(sensorDataMapList.get(31), 31);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[32].initialDelay}", fixedDelayString = "${application.tagList[32].duration}")
    public void scheduleTask_32() {
        task.runTask(sensorDataMapList.get(32), 32);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[33].initialDelay}", fixedDelayString = "${application.tagList[33].duration}")
    public void scheduleTask_33() {
        task.runTask(sensorDataMapList.get(33), 33);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[34].initialDelay}", fixedDelayString = "${application.tagList[34].duration}")
    public void scheduleTask_34() {
        task.runTask(sensorDataMapList.get(34), 34);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[35].initialDelay}", fixedDelayString = "${application.tagList[35].duration}")
    public void scheduleTask_35() {
        task.runTask(sensorDataMapList.get(35), 35);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[36].initialDelay}", fixedDelayString = "${application.tagList[36].duration}")
    public void scheduleTask_36() {
        task.runTask(sensorDataMapList.get(36), 36);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[37].initialDelay}", fixedDelayString = "${application.tagList[37].duration}")
    public void scheduleTask_37() {
        task.runTask(sensorDataMapList.get(37), 37);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[38].initialDelay}", fixedDelayString = "${application.tagList[38].duration}")
    public void scheduleTask_38() {
        task.runTask(sensorDataMapList.get(38), 38);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[39].initialDelay}", fixedDelayString = "${application.tagList[39].duration}")
    public void scheduleTask_39() {
        task.runTask(sensorDataMapList.get(39), 39);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[40].initialDelay}", fixedDelayString = "${application.tagList[40].duration}")
    public void scheduleTask_40() {
        task.runTask(sensorDataMapList.get(40), 40);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[41].initialDelay}", fixedDelayString = "${application.tagList[41].duration}")
    public void scheduleTask_41() {
        task.runTask(sensorDataMapList.get(41), 41);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[42].initialDelay}", fixedDelayString = "${application.tagList[42].duration}")
    public void scheduleTask_42() {
        task.runTask(sensorDataMapList.get(42), 42);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[43].initialDelay}", fixedDelayString = "${application.tagList[43].duration}")
    public void scheduleTask_43() {
        task.runTask(sensorDataMapList.get(43), 43);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[44].initialDelay}", fixedDelayString = "${application.tagList[44].duration}")
    public void scheduleTask_44() {
        task.runTask(sensorDataMapList.get(44), 44);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[45].initialDelay}", fixedDelayString = "${application.tagList[45].duration}")
    public void scheduleTask_45() {
        task.runTask(sensorDataMapList.get(45), 45);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[46].initialDelay}", fixedDelayString = "${application.tagList[46].duration}")
    public void scheduleTask_46() {
        task.runTask(sensorDataMapList.get(46), 46);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[47].initialDelay}", fixedDelayString = "${application.tagList[47].duration}")
    public void scheduleTask_47() {
        task.runTask(sensorDataMapList.get(47), 47);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[48].initialDelay}", fixedDelayString = "${application.tagList[48].duration}")
    public void scheduleTask_48() {
        task.runTask(sensorDataMapList.get(48), 48);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[49].initialDelay}", fixedDelayString = "${application.tagList[49].duration}")
    public void scheduleTask_49() {
        task.runTask(sensorDataMapList.get(49), 49);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[50].initialDelay}", fixedDelayString = "${application.tagList[50].duration}")
    public void scheduleTask_50() {
        task.runTask(sensorDataMapList.get(50), 50);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[51].initialDelay}", fixedDelayString = "${application.tagList[51].duration}")
    public void scheduleTask_51() {
        task.runTask(sensorDataMapList.get(51), 51);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[52].initialDelay}", fixedDelayString = "${application.tagList[52].duration}")
    public void scheduleTask_52() {
        task.runTask(sensorDataMapList.get(52), 52);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[53].initialDelay}", fixedDelayString = "${application.tagList[53].duration}")
    public void scheduleTask_53() {
        task.runTask(sensorDataMapList.get(53), 53);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[54].initialDelay}", fixedDelayString = "${application.tagList[54].duration}")
    public void scheduleTask_54() {
        task.runTask(sensorDataMapList.get(54), 54);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[55].initialDelay}", fixedDelayString = "${application.tagList[55].duration}")
    public void scheduleTask_55() {
        task.runTask(sensorDataMapList.get(55), 55);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[56].initialDelay}", fixedDelayString = "${application.tagList[56].duration}")
    public void scheduleTask_56() {
        task.runTask(sensorDataMapList.get(56), 56);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[57].initialDelay}", fixedDelayString = "${application.tagList[57].duration}")
    public void scheduleTask_57() {
        task.runTask(sensorDataMapList.get(57), 57);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[58].initialDelay}", fixedDelayString = "${application.tagList[58].duration}")
    public void scheduleTask_58() {
        task.runTask(sensorDataMapList.get(58), 58);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[59].initialDelay}", fixedDelayString = "${application.tagList[59].duration}")
    public void scheduleTask_59() {
        task.runTask(sensorDataMapList.get(59), 59);
    }

    @Async
    @Scheduled(initialDelayString = "${application.tagList[60].initialDelay}", fixedDelayString = "${application.tagList[60].duration}")
    public void scheduleTask_60() {
        task.runTask(sensorDataMapList.get(60), 60);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[61].initialDelay}", fixedDelayString = "${application.tagList[61].duration}")
    public void scheduleTask_61() {
        task.runTask(sensorDataMapList.get(61), 61);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[62].initialDelay}", fixedDelayString = "${application.tagList[62].duration}")
    public void scheduleTask_62() {
        task.runTask(sensorDataMapList.get(62), 62);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[63].initialDelay}", fixedDelayString = "${application.tagList[63].duration}")
    public void scheduleTask_63() {
        task.runTask(sensorDataMapList.get(63), 63);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[64].initialDelay}", fixedDelayString = "${application.tagList[64].duration}")
    public void scheduleTask_64() {
        task.runTask(sensorDataMapList.get(64), 64);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[65].initialDelay}", fixedDelayString = "${application.tagList[65].duration}")
    public void scheduleTask_65() {
        task.runTask(sensorDataMapList.get(65), 65);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[66].initialDelay}", fixedDelayString = "${application.tagList[66].duration}")
    public void scheduleTask_66() {
        task.runTask(sensorDataMapList.get(66), 66);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[67].initialDelay}", fixedDelayString = "${application.tagList[67].duration}")
    public void scheduleTask_67() {
        task.runTask(sensorDataMapList.get(67), 67);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[68].initialDelay}", fixedDelayString = "${application.tagList[68].duration}")
    public void scheduleTask_68() {
        task.runTask(sensorDataMapList.get(68), 68);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[69].initialDelay}", fixedDelayString = "${application.tagList[69].duration}")
    public void scheduleTask_69() {
        task.runTask(sensorDataMapList.get(69), 69);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[70].initialDelay}", fixedDelayString = "${application.tagList[70].duration}")
    public void scheduleTask_70() {
        task.runTask(sensorDataMapList.get(70), 70);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[71].initialDelay}", fixedDelayString = "${application.tagList[71].duration}")
    public void scheduleTask_71() {
        task.runTask(sensorDataMapList.get(71), 71);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[72].initialDelay}", fixedDelayString = "${application.tagList[72].duration}")
    public void scheduleTask_72() {
        task.runTask(sensorDataMapList.get(72), 72);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[73].initialDelay}", fixedDelayString = "${application.tagList[73].duration}")
    public void scheduleTask_73() {
        task.runTask(sensorDataMapList.get(73), 73);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[74].initialDelay}", fixedDelayString = "${application.tagList[74].duration}")
    public void scheduleTask_74() {
        task.runTask(sensorDataMapList.get(74), 74);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[75].initialDelay}", fixedDelayString = "${application.tagList[75].duration}")
    public void scheduleTask_75() {
        task.runTask(sensorDataMapList.get(75), 75);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[76].initialDelay}", fixedDelayString = "${application.tagList[76].duration}")
    public void scheduleTask_76() {
        task.runTask(sensorDataMapList.get(76), 76);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[77].initialDelay}", fixedDelayString = "${application.tagList[77].duration}")
    public void scheduleTask_77() {
        task.runTask(sensorDataMapList.get(77), 77);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[78].initialDelay}", fixedDelayString = "${application.tagList[78].duration}")
    public void scheduleTask_78() {
        task.runTask(sensorDataMapList.get(78), 78);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[79].initialDelay}", fixedDelayString = "${application.tagList[79].duration}")
    public void scheduleTask_79() {
        task.runTask(sensorDataMapList.get(79), 79);
    }
    @Async
    @Scheduled(initialDelayString = "${application.tagList[80].initialDelay}", fixedDelayString = "${application.tagList[80].duration}")
    public void scheduleTask_80() {
        task.runTask(sensorDataMapList.get(80), 80);
    }

    private void parseCSV(String path) {
        Map<Integer, SensorDataDto> dataMap = new HashMap<>();
        int index = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(new File(path)))) {
            String line;
            while((line = br.readLine()) != null) {
                String[] lineArr = line.split(",");
                if(!NumberFormatUtil.isNumberic(lineArr[4]))
                    continue;
                dataMap.put(index++,
                        SensorDataDto.builder()
                                .dataType(lineArr[1])
                                .sensorId(lineArr[2])
                                .time(toUtcTime(lineArr[3]))
                                .aValue(Double.parseDouble(lineArr[4]))
                                .status(lineArr[5])
                                .build());
            }
        } catch (IOException e) {
           log.error(e.getMessage());
        }
        sensorDataMapList.add(dataMap);
    }

    private Instant toUtcTime(String timeStr) {
        LocalDateTime dateTime = LocalDateTime.parse(timeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"));
        return dateTime.minusHours(9L).toInstant(ZoneOffset.UTC);
    }
}
