package bozecps.viewBoard.utils;

import com.alibaba.fastjson.JSONObject;

public class ResponseToFront {
	public static JSONObject responseMsg(int code,Object object) {
		JSONObject responseJsonObject = new JSONObject();
		responseJsonObject.put("code", code);
		if(code == 1) {
			responseJsonObject.put("message", "请求成功");
			responseJsonObject.put("data", object);
		}else if(code == 0) {
			responseJsonObject.put("message", object);
		}
		return responseJsonObject;
	}
}
