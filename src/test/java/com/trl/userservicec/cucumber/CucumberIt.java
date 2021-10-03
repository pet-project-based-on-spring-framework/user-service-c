package com.trl.userservicec.cucumber;

import com.trl.userservicec.AbstractIntegrationTest;
import com.trl.userservicec.UserServiceCApplication;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberContextConfiguration
@SpringBootTest(
        classes = {
                UserServiceCApplication.class,
//                UserServiceCApplicationTests.class,
                CucumberIt.class
        },
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@CucumberOptions(
        plugin = {"pretty"},
        tags = "",
        features = "src/test/resources/features"
)
public class CucumberIt extends AbstractIntegrationTest {
}
