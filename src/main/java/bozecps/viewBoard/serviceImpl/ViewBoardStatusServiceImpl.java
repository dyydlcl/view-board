package bozecps.viewBoard.serviceImpl;

import bozecps.viewBoard.domain.dto.ViewBoardStatusDTO;
import bozecps.viewBoard.repository.ViewBoardStatusMapper;
import bozecps.viewBoard.service.ViewBoardStatusService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Service
public class ViewBoardStatusServiceImpl  implements ViewBoardStatusService {
    @Autowired
    private ViewBoardStatusMapper viewBoardStatusMapper;
    @Override
    public JSONObject getViewBoardStatusListByStatus(Map<String, Object> map) {
        JSONObject jsonObject = new JSONObject();
        try{
            List<ViewBoardStatusDTO> viewBoardStatusDTOList =
                viewBoardStatusMapper.getViewBoardStatusListByStatus(map);
            if (viewBoardStatusDTOList == null){
                viewBoardStatusDTOList = new ArrayList<>();
            }
            jsonObject.put("viewBoardStatusDTOList",viewBoardStatusDTOList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject;
    }
}
