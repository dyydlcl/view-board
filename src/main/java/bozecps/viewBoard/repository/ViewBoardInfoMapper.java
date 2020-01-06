package bozecps.viewBoard.repository;

import bozecps.viewBoard.domain.ViewBoardInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface ViewBoardInfoMapper extends BaseMapper<ViewBoardInfo> {
    int deleteByPrimaryKey(Long id);

    int insert(ViewBoardInfo record);

    int insertSelective(ViewBoardInfo record);

    ViewBoardInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ViewBoardInfo record);

    int updateByPrimaryKey(ViewBoardInfo record);

    ViewBoardInfo selectByViewBoardType(String viewBoardInfo);
}
