package bozecps.viewBoard.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViewBoardStatusDTO {
    private Long id;

    private String viewBoardName;

    private String viewBoardStatusName;

    private String currentStatusQuantities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getViewBoardName() {
        return viewBoardName;
    }

    public void setViewBoardName(String viewBoardName) {
        this.viewBoardName = viewBoardName;
    }

    public String getViewBoardStatusName() {
        return viewBoardStatusName;
    }

    public void setViewBoardStatusName(String viewBoardStatusName) {
        this.viewBoardStatusName = viewBoardStatusName;
    }

    public String getCurrentStatusQuantities() {
        return currentStatusQuantities;
    }

    public void setCurrentStatusQuantities(String currentStatusQuantities) {
        this.currentStatusQuantities = currentStatusQuantities;
    }
}
