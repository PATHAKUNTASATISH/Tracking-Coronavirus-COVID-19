package io.springboot2.x.service.impl;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.springboot2.x.model.CoronaVirusStatsModel;
import io.springboot2.x.service.ICoronavirus_COVID_19Service;

@Service
public class Coronavirus_COVID_19ServiceImpl implements ICoronavirus_COVID_19Service {
	private static String CASES_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Confirmed.csv";
	private List<CoronaVirusStatsModel> mainList = new ArrayList<>();

	@Override
	public List<CoronaVirusStatsModel> getMainList() {
		// TODO Auto-generated method stub
		return mainList;
	}
	
	@PostConstruct
	@Scheduled(cron = "* * 1 * * *")
	@Override
	public void getVirusData() throws IOException {
		// TODO Auto-generated method stub
		List<CoronaVirusStatsModel> tempList = new ArrayList<>();
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<String> response = restTemplate.getForEntity(CASES_DATA_URL, String.class);

		StringReader csvbodyReader = new StringReader(response.getBody());
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvbodyReader);
		
		
		for (CSVRecord record : records) {

			CoronaVirusStatsModel cvst = new CoronaVirusStatsModel();
			cvst.setState(record.get("Province/State"));
			cvst.setCountry(record.get("Country/Region"));
			cvst.setLatitude(record.get("Lat"));
			cvst.setLongitude(record.get("Long"));
			cvst.setLatestTotalCases(record.get(record.size() - 1));

			tempList.add(cvst);
		}
		
		this.mainList=tempList;
		

	}

}
