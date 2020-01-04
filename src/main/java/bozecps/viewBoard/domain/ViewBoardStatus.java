package bozecps.viewBoard.domain;

public class ViewBoardStatus {
    private Long id;

    private Long viewBoardInfoId;

    private Long viewBoardStatusNameId;

    private String currentStatusQuantities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getViewBoardInfoId() {
        return viewBoardInfoId;
    }

    public void setViewBoardInfoId(Long viewBoardInfoId) {
        this.viewBoardInfoId = viewBoardInfoId;
    }

    public Long getViewBoardStatusNameId() {
        return viewBoardStatusNameId;
    }

    public void setViewBoardStatusNameId(Long viewBoardStatusNameId) {
        this.viewBoardStatusNameId = viewBoardStatusNameId;
    }

    public String getCurrentStatusQuantities() {
        return currentStatusQuantities;
    }

    public void setCurrentStatusQuantities(String currentStatusQuantities) {
        this.currentStatusQuantities = currentStatusQuantities == null ? null : currentStatusQuantities.trim();
    }
}