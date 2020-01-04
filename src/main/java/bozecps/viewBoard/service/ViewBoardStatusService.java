package bozecps.viewBoard.service;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public interface ViewBoardStatusService {
    JSONObject getViewBoardStatusListByStatus(Map<String,Object> map);
}
