package com.person.qi_boot;

import com.person.qi_boot.utils.TimeUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class QiBootApplicationTests {

    @Test
    public void contextLoads() {
        Date date = new Date(TimeUtils.getWorkStartTime());
        System.out.println(date);
    }

}
