package kr.co.mash_up.vo;

import kr.co.mash_up.util.Constant;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 응답코드/메시지 + 여러개의 데이터(엔티티, VO)가 있는 경우
 */
@Getter
@Setter
@ToString
public class DataListResponseVO<T> extends ResponseVO {

    private List<T> list;

    public DataListResponseVO(Integer resultCode, String message) {
        super(resultCode, message);
    }

    public DataListResponseVO(List<T> list) {
        this(Constant.ResultCodes.OK, "success");
        this.list = list;
    }

    public static DataListResponseVO badRequest(){
        return new DataListResponseVO(Constant.ResultCodes.BAD_REQUEST, null);
    }
}
