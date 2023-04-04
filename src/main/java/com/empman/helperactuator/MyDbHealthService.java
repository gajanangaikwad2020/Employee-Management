package com.empman.helperactuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Controller;

@Controller
public class MyDbHealthService implements HealthIndicator
{
	public static final String DB_SERVICE="Database Service";
	public boolean isHealthGood()
	{
		//Custom Logic
		return false;
		
	}
	@Override
	public Health health() 
	{
		if(isHealthGood())
		{
			return Health.up().withDetail(DB_SERVICE, "Database service is running").build();
		}
		else
		{
			return Health.down().withDetail(DB_SERVICE, "Database service is running down").build();
		}
	}
	
	
	


}
