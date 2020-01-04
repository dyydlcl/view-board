package bozecps.viewBoard.domain;

public class ViewBoardInfo {
    private Long id;

    private Byte viewBoardType;

    private String viewBoardQuantities;

    private String viewBoardName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getViewBoardType() {
        return viewBoardType;
    }

    public void setViewBoardType(Byte viewBoardType) {
        this.viewBoardType = viewBoardType;
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