package kr.co.mash_up.vo;

import kr.co.mash_up.util.Constant;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 응답코드/메시지 + 1개의 데이터(엔티티, VO)가 있는 경우
 *
 * @param <T> data 클래스
 */
@Setter
@Getter
@ToString
public class DataResponseVO<T> extends ResponseVO {

    private T item;

    public DataResponseVO(Integer resultCode) {
        super(resultCode);
    }

    public DataResponseVO(Integer resultCode, String message) {
        super(resultCode, message);
    }

    public DataResponseVO(T item) {
        this(Constant.ResultCodes.OK, "success");
        this.item = item;
    }

    public static DataResponseVO badRequest(){
        return new DataResponseVO(Constant.ResultCodes.BAD_REQUEST, "bad request");
    }
}
