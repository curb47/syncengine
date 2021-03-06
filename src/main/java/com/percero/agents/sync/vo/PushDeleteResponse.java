package com.percero.agents.sync.vo;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;



public class PushDeleteResponse extends SyncResponse {

	private List<RemovedClassIDPair> objectList;
	public List<RemovedClassIDPair> getObjectList() {
		return objectList;
	}
	public void setObjectList(List<RemovedClassIDPair> value) {
		objectList = value;
	}
	
	public String toJson(ObjectMapper objectMapper) {
		if (objectJson == null) {
			String objectListJson = "";
			int objectCounter = 0;
			for(RemovedClassIDPair nextObject : getObjectList()) {
				if (objectCounter > 0)
					objectListJson += ",";
				objectListJson += nextObject.toEmbeddedJson();
				objectCounter++;
			}
			return toJson(objectListJson, objectMapper);
		}
		else {
			return toJson(objectJson, objectMapper);
		}
	}
	
	private String objectJson = null;
	public void setObjectJson(String value) {
		objectJson = value;
	}
	
	public String toJson(String objectListJson, ObjectMapper objectMapper) {
		String objectJson = "{" + super.retrieveJson(objectMapper) + ",\"objectList\":[";
		objectJson += objectListJson + "]}";
		return objectJson;
	}
}
