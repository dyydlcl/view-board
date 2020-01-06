package bozecps.viewBoard.repository;

import bozecps.viewBoard.domain.ViewBoardStatusName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface ViewBoardStatusNameMapper extends BaseMapper<ViewBoardStatusName> {
    int deleteByPrimaryKey(Long id);

    int insert(ViewBoardStatusName record);

    int insertSelective(ViewBoardStatusName record);

    ViewBoardStatusName selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ViewBoardStatusName record);

    int updateByPrimaryKey(ViewBoardStatusName record);

    ViewBoardStatusName selectByViewBoardStatusName(String viewBoardStatusName);
}
