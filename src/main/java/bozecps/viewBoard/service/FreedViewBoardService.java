package bozecps.viewBoard.service;

import bozecps.viewBoard.domain.vo.FreedViewBoardVO;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface FreedViewBoardService {
    JSONObject freedViewBoardToNextStatus(FreedViewBoardVO freedViewBoardVO);
    JSONObject freedViewBoardsToNextStatus(String viewBoardType);
}
