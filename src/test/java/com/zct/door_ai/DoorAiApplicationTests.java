package com.zct.door_ai;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DoorAiApplicationTests {

	@Test
	public void contextLoads() {
		System.out.print(4/0+"");
		/*final Logger logger = Logger.getLogger("TestErrOut");
		logger.debug(" This is debug!!!");
		logger.info(" This is info!!!");
		logger.warn(" This is warn!!!");
		logger.error(" This is error!!!");
		logger.fatal(" This is fatal!!!");*/
	}

}
