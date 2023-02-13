package arquitectura.software.currency.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class InfoDto {
    private BigDecimal rate;
    private BigInteger timestamp;

    public InfoDto() {
    }

    public InfoDto(BigDecimal rate, BigInteger timestamp) {
        this.rate = rate;
        this.timestamp = timestamp;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigInteger getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(BigInteger timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "InfoDto{" +
                "rate=" + rate +
                ", timestamp=" + timestamp +
                '}';
    }
}
