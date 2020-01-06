package bozecps.viewBoard.repository;

import bozecps.viewBoard.domain.ViewBoardStatus;
import bozecps.viewBoard.domain.dto.ViewBoardStatusDTO;
import bozecps.viewBoard.domain.vo.FreedViewBoardVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

public interface ViewBoardStatusMapper extends BaseMapper<ViewBoardStatus> {
    int deleteByPrimaryKey(Long id);

    int insert(ViewBoardStatus record);

    int insertSelective(ViewBoardStatus record);

    ViewBoardStatus selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ViewBoardStatus record);

    int updateByPrimaryKey(ViewBoardStatus record);

    List<ViewBoardStatusDTO> getViewBoardStatusListByStatus(Map<String,Object> map);

    ViewBoardStatus selectByTypeAndStatusName(FreedViewBoardVO freedViewBoardVO);

    List<ViewBoardStatus> selectListByTypeAndStatusName(FreedViewBoardVO freedViewBoardVO);
}
