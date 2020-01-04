package bozecps.viewBoard.repository;

import bozecps.viewBoard.domain.ViewBoardInfo;

public interface ViewBoardInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ViewBoardInfo record);

    int insertSelective(ViewBoardInfo record);

    ViewBoardInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ViewBoardInfo record);

    int updateByPrimaryKey(ViewBoardInfo record);
}