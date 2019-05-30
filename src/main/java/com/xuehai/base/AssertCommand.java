package com.xuehai.base;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class AssertCommand {
	private JSONObject command;

	public AssertCommand(String assertion) {
		command = JSONObject.parseObject(assertion);
	}
	
	public int getInvokeType() {
		return command.getIntValue("invokeType");
	}
	
	public String expectResult() {
		return command.getString("expectResult");
	}
	
	public String action() {
		return command.getString("action");
	}
	
	public int assertType () {
		return command.getIntValue("assertType");
	}
	
	public String[] assertKey() {
		JSONArray keys = command.getJSONArray("assertKey");
		String[] assertKey = new String[keys.size()];
		for (int i = 0; i < keys.size(); i++) {
			assertKey[i] = keys.getString(i);
		}
		return assertKey;
	}
}
