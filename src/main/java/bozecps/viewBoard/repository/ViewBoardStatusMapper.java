package bozecps.viewBoard.repository;

import bozecps.viewBoard.domain.ViewBoardStatus;
import bozecps.viewBoard.domain.dto.ViewBoardStatusDTO;

import java.util.List;
import java.util.Map;

public interface ViewBoardStatusMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ViewBoardStatus record);

    int insertSelective(ViewBoardStatus record);

    ViewBoardStatus selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ViewBoardStatus record);

    int updateByPrimaryKey(ViewBoardStatus record);

    public List<ViewBoardStatusDTO> getViewBoardStatusListByStatus(Map<String,Object> map);
}
