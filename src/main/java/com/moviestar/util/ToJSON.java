package com.moviestar.util;

import java.util.Map;

import org.codehaus.jettison.json.JSONObject;

public class ToJSON {

	public JSONObject toJSONArray(Map<String, Object> map){
		JSONObject jo = new JSONObject(map);
		return jo;
	}
}
