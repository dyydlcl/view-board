package bozecps.viewBoard.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("FreedViewBoardVO")
public class FreedViewBoardVO {
    @ApiModelProperty(example = "当前待释放的状态",required = true)
    private int presentStatus;

    @ApiModelProperty(example = "待释放的看板类型编码",required = true)
    private String freedViewBoardType;

    @ApiModelProperty(example = "待释放的看板",required = true)
    private String freedViewBoardQuantity;

    @ApiModelProperty(example = "待释放后下一个的状态",required = true)
    private int nextStatus;

    @ApiModelProperty(hidden = true)
    private  int status;
}
