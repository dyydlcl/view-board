package bozecps.viewBoard.web.rest;

import bozecps.viewBoard.service.ViewBoardStatusService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api(tags = "ViewBoardStatus")
@RequestMapping("/viewBoardStatus")
public class ViewBoardStatusController {
    @Resource(name = "viewBoardStatusServiceImpl")
    private ViewBoardStatusService viewBoardStatusService;

    @ApiOperation("test")
    @GetMapping("/getViewBoardStatusListByStatus")
    public JSONObject getViewBoardStatusListByStatus(@RequestParam String status){
        Map<String,Object> map = new HashMap<>();
        map.put("status",status);
        return viewBoardStatusService.getViewBoardStatusListByStatus(map);
    }
}
