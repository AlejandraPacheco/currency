package arquitectura.software.currency.dto;

import java.math.BigDecimal;

public class ResponseDto {
    private InfoDto infoDto;
    private RequestDto requestDto;
    private BigDecimal result;

    public ResponseDto() {
    }

    public InfoDto getInfoDto() {
        return infoDto;
    }

    public void setInfoDto(InfoDto infoDto) {
        this.infoDto = infoDto;
    }

    public RequestDto getRequestDto() {
        return requestDto;
    }

    public void setRequestDto(RequestDto requestDto) {
        this.requestDto = requestDto;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "infoDto=" + infoDto +
                ", requestDto=" + requestDto +
                ", result=" + result +
                '}';
    }
}
