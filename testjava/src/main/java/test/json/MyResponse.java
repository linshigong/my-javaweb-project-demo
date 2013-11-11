package test.json;

import java.util.List;
import java.util.Map;

public class MyResponse {
	
	private List<Map<String,String>> getMetricData;
	
	private Map<String,String> error;
	
	public Map<String, String> getError() {
		return error;
	}

	public void setError(Map<String, String> error) {
		this.error = error;
	}

	public List<Map<String, String>> getGetMetricData() {
		return getMetricData;
	}

	public void setGetMetricData(List<Map<String, String>> getMetricData) {
		this.getMetricData = getMetricData;
	}

}
