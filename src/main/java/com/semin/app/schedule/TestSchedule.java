package com.semin.app.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.semin.app.member.MemberMapper;

@Component
public class TestSchedule {
	
	@Autowired
	private MemberMapper memberMapper;
	
//	@Scheduled(fixedRate = 2000, initialDelay = 1000)
//	public void useFixRate() throws Exception{
//		System.out.println("고정 간격으로 반복 할 코드");
//	}
//	
//	@Scheduled(fixedDelay = 2000, initialDelayString = "2000")
//	public void useFixDeley() throws Exception {
//		System.out.println("고정 간격으로 반복 Deley");
//	}
	
	@Scheduled(cron = "0 0 0 * * *")
	public void useCron() throws Exception {
		System.out.println("Cron");
	}

}
