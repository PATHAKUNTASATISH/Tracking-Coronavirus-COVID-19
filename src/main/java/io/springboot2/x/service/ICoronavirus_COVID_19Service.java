package io.springboot2.x.service;

import java.io.IOException;
import java.util.List;

import io.springboot2.x.model.CoronaVirusStatsModel;

public interface ICoronavirus_COVID_19Service {
	
	public List<CoronaVirusStatsModel> getMainList();
    public void getVirusData() throws IOException;

}
