package bozecps.viewBoard.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "view_board_status_name")
public class ViewBoardStatusName {
    @TableId(value = "id",type = IdType.AUTO)
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
