package bozecps.viewBoard.serviceImpl;

import bozecps.viewBoard.domain.ViewBoardInfo;
import bozecps.viewBoard.domain.ViewBoardStatus;
import bozecps.viewBoard.domain.vo.FreedViewBoardVO;
import bozecps.viewBoard.repository.ViewBoardInfoMapper;
import bozecps.viewBoard.repository.ViewBoardStatusMapper;
import bozecps.viewBoard.repository.ViewBoardStatusNameMapper;
import bozecps.viewBoard.service.FreedViewBoardService;
import bozecps.viewBoard.utils.ResponseToFront;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static bozecps.viewBoard.utils.StatusCustom.*;

@Service
public class FreeViewBoardServiceImpl implements FreedViewBoardService {
    @Autowired
    private ViewBoardInfoMapper viewBoardInfoMapper;
    @Autowired
    private ViewBoardStatusMapper viewBoardStatusMapper;
    @Autowired
    private ViewBoardStatusNameMapper viewBoardStatusNameMapper;
    @Override
    /**
     * viewBoardStatus1:当前状态
     * viewBoardStatus2:下个状态
     * viewBoardStatus3:其他
     */
    public JSONObject freedViewBoardToNextStatus(FreedViewBoardVO freedViewBoardVO) {
        StringBuffer stringBuffer = new StringBuffer();
        long nextStatus = freedViewBoardVO.getNextStatus();
        try{
            /*修改当前状态下的数据*/
            freedViewBoardVO.setStatus(freedViewBoardVO.getPresentStatus());
            ViewBoardStatus viewBoardStatus1 = viewBoardStatusMapper.selectByTypeAndStatusName(freedViewBoardVO);
            String[] quantities = viewBoardStatus1.getCurrentStatusQuantities().split(",");
            switch (freedViewBoardVO.getPresentStatus()){
                //不需要考虑先后顺序
                case LINE7:
                case LINE9:
                case LINE7_TRANSPORTING:
                case LINE9_TRANSPORTING:
                case RECYCLING:
                    List<String> list1 = new ArrayList<>(Arrays.asList(quantities));
                    list1.remove(freedViewBoardVO.getFreedViewBoardQuantity());
                    String[] quantities1 = new String[list1.size()];
                    list1.toArray(quantities1);
                    viewBoardStatus1.setCurrentStatusQuantities(String.join(",",quantities1));
                    viewBoardStatusMapper.updateByPrimaryKey(viewBoardStatus1);
                    break;
                //遵循先进先出
                case BEFORE_CLEAN:
                case CLEANING:
                case AFTER_CLEAN:
                    if (!StringUtils.equalsAnyIgnoreCase(quantities[0],freedViewBoardVO.getFreedViewBoardQuantity())){
                        return ResponseToFront.responseMsg(0,"不可释放");
                    }
                    List<String> list2 = new ArrayList<>(Arrays.asList(quantities));
                    list2.remove(freedViewBoardVO.getFreedViewBoardQuantity());
                    String[] quantities2 = new String[list2.size()];
                    list2.toArray(quantities2);
                    viewBoardStatus1.setCurrentStatusQuantities(String.join(",",quantities2));
                    viewBoardStatusMapper.updateByPrimaryKey(viewBoardStatus1);
                    break;
            }
            /*下个状态的数据修改*/
            freedViewBoardVO.setStatus(freedViewBoardVO.getNextStatus());
            ViewBoardStatus viewBoardStatus2 = viewBoardStatusMapper.selectByTypeAndStatusName(freedViewBoardVO);
            if (viewBoardStatus2==null){
                ViewBoardStatus viewBoardStatus3 = new ViewBoardStatus();
                ViewBoardInfo viewBoardInfo = viewBoardInfoMapper.selectByViewBoardType(freedViewBoardVO.getFreedViewBoardType());
                viewBoardStatus3.setViewBoardInfoId(viewBoardInfo.getId());
                viewBoardStatus3.setViewBoardStatusNameId(nextStatus);
                viewBoardStatus3.setCurrentStatusQuantities(freedViewBoardVO.getFreedViewBoardQuantity());
                viewBoardStatusMapper.insert(viewBoardStatus3);
                return ResponseToFront.responseMsg(1,"成功释放");
            }
            if (!StringUtils.isEmpty(viewBoardStatus2.getCurrentStatusQuantities())){
                stringBuffer.append(viewBoardStatus2.getCurrentStatusQuantities());
                stringBuffer.append(",");
                stringBuffer.append(freedViewBoardVO.getFreedViewBoardQuantity());
            }else {
                stringBuffer.append(freedViewBoardVO.getFreedViewBoardQuantity());
            }
            viewBoardStatus2.setCurrentStatusQuantities(stringBuffer.toString());
            viewBoardStatusMapper.updateByPrimaryKey(viewBoardStatus2);
            return ResponseToFront.responseMsg(1,"成功释放");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseToFront.responseMsg(0,e.getMessage());
        }
    }

    @Override
    public JSONObject freedViewBoardsToNextStatus(String viewBoardType) {
        FreedViewBoardVO freedViewBoardVO = new FreedViewBoardVO();
        try{
            freedViewBoardVO.setStatus(0);
            if (StringUtils.isEmpty(viewBoardType)){
                freedViewBoardVO.setFreedViewBoardType(viewBoardType);
                List<ViewBoardStatus> viewBoardStatusList = viewBoardStatusMapper.selectListByTypeAndStatusName(freedViewBoardVO);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        return null;
    }
}
