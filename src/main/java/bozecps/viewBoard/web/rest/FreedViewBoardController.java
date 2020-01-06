package bozecps.viewBoard.web.rest;

import bozecps.viewBoard.domain.vo.FreedViewBoardVO;
import bozecps.viewBoard.service.FreedViewBoardService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(tags = "FreedViewBoard")
@RequestMapping("/freedViewBoard")
public class FreedViewBoardController {
    @Resource(name = "freeViewBoardServiceImpl")
    private FreedViewBoardService freedViewBoardService;

    @ApiOperation("")
    @PostMapping("/freedViewBoard")
    public JSONObject freedViewBoard(@RequestBody FreedViewBoardVO freedViewBoardVO){
        return freedViewBoardService.freedViewBoardToNextStatus(freedViewBoardVO);
    }
}
