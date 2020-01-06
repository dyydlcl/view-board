package bozecps.viewBoard.domain;

public class ViewBoardInfo {
    private Long id;

    private String viewBoardType;

    private String viewBoardQuantities;

    private String viewBoardName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getViewBoardType() {
        return viewBoardType;
    }

    public void setViewBoardType(String viewBoardType) {
        this.viewBoardType = viewBoardType == null ? null : viewBoardType.trim();
    }

    public String getViewBoardQuantities() {
        return viewBoardQuantities;
    }

    public void setViewBoardQuantities(String viewBoardQuantities) {
        this.viewBoardQuantities = viewBoardQuantities == null ? null : viewBoardQuantities.trim();
    }

    public String getViewBoardName() {
        return viewBoardName;
    }

    public void setViewBoardName(String viewBoardName) {
        this.viewBoardName = viewBoardName == null ? null : viewBoardName.trim();
    }
}