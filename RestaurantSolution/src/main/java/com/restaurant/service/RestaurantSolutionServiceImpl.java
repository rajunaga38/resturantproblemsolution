package com.restaurant.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class RestaurantSolutionServiceImpl implements RestaurantSolutionService {

	@Autowired
    private ResourceLoader resourceLoader;
	Resource resource;
    
	@PostConstruct
	public void init() {
		resource = resourceLoader.getResource("classpath:data.txt");
	}
	
	@Override
	public Long findSolution() {
		
		BufferedReader br = null;
		FileReader fr = null;
		String sCurrentLine = null;
		long satisfactionSum = 0;
		int timeInMinuteSum = 0;
		try {
			File fileName = resource.getFile();
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			ArrayList<Integer> timeList = new ArrayList<>();
			Map<Integer,Long> satisTimeMap = new HashMap<>();
			while ((sCurrentLine = br.readLine()) != null) {
				String[] str = sCurrentLine.split(" ");
				int value = Integer.parseInt(str[1]);
				timeList.add(value);
				satisTimeMap.put(value,Long.parseLong(str[0]));
			}
			Collections.sort(timeList);
			
			for(int timeInMinute:timeList){
				timeInMinuteSum = timeInMinuteSum+timeInMinute;
				if(timeInMinuteSum <= 10000){
					long satisfaction = satisTimeMap.get(timeInMinute);
					satisfactionSum = satisfactionSum+satisfaction;
				}
			}
			
			return satisfactionSum;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		return null;
	}

}
