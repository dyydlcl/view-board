package bozecps.viewBoard.domain;

public class ViewBoardStatusName {
    private Long id;

    private String viewBoardStatusName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getViewBoardStatusName() {
        return viewBoardStatusName;
    }

    public void setViewBoardStatusName(String viewBoardStatusName) {
        this.viewBoardStatusName = viewBoardStatusName == null ? null : viewBoardStatusName.trim();
    }
}