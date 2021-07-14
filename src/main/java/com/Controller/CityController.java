package com.Controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Bean.CityBean;
import com.Config.DBConfig;
import com.Dao.CityDao;

public class CityController {


	@Autowired
	static CityDao cityDao;
	
	public static void main(String[] args) {
		
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(DBConfig.class);	
		cityDao = (CityDao) ctx.getBean("cityDao");
		
		while(true) {
		Scanner sc =new Scanner(System.in);
		System.out.println("CityApp");
		System.out.println("1-user cann add city first and then add temprature for the city");
		System.out.println("2-user can delete city ,");
		System.out.println("3-update city temprature");
		System.out.println("4-user can able to get city temprature from city name ");
		System.out.println("5-user can able to get average day temprature by city name");
		System.out.println("6-Exit");
		
		System.out.println("Enter your choice");
		int choice=sc.nextInt();
		
		
		switch(choice) {
			
		
				case 1:
						int res = cityDao.addCity();
						
						if(res>0) {
							
							System.out.println("Record inserted...");
						}
						else {
							System.out.println("Record not inserted...");
						}
						break;
				
				case 2:
						System.out.println(cityDao.deleteCity()+"City deleted");
						break;
				
				case 3:
						System.out.println(cityDao.updateCity()+"City Temperature updated");
						
						break;
						
				case 4:
						CityBean cityBean = cityDao.getCityBeanByName();
						System.out.println("Morning :- "+cityBean.getMorntemp());
						System.out.println("Evening :- "+cityBean.getEventemp());
						System.out.println("Night :- "+cityBean.getNighttemp());
						break;
						
				case 5:
						CityBean cityBean1 = cityDao.getAvgTempByName();
						System.out.println("Average:- "+cityBean1.getAvgtemp());
						break;
					
				case 6:
						System.exit(0);
						
						
		
			}
		}
		
	}
}
