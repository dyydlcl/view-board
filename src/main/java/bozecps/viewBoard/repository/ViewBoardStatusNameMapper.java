package bozecps.viewBoard.repository;

import bozecps.viewBoard.domain.ViewBoardStatusName;

public interface ViewBoardStatusNameMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ViewBoardStatusName record);

    int insertSelective(ViewBoardStatusName record);

    ViewBoardStatusName selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ViewBoardStatusName record);

    int updateByPrimaryKey(ViewBoardStatusName record);
}