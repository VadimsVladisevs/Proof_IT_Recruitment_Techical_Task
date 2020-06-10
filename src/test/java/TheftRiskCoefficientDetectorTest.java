import businesslogic.TheftRiskCoefficientDetector;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TheftRiskCoefficientDetectorTest {

    @Test
    public void detectTestV1() {                                                                                        //Insured Sub-Objects SUM < 15
        TheftRiskCoefficientDetector theftRiskCoefficientDetector = new TheftRiskCoefficientDetector();

        BigDecimal actual = theftRiskCoefficientDetector.detect(new BigDecimal("10.00"));
        BigDecimal expected = new BigDecimal("0.11");
        assertEquals(expected, actual);
    }

    @Test
    public void detectTestV2() {                                                                                        //Insured Sub-Objects SUM = 15
        TheftRiskCoefficientDetector theftRiskCoefficientDetector = new TheftRiskCoefficientDetector();

        BigDecimal actual = theftRiskCoefficientDetector.detect(new BigDecimal("15.00"));
        BigDecimal expected = new BigDecimal("0.05");
        assertEquals(expected, actual);
    }

    @Test
    public void detectTestV3() {                                                                                        //Insured Sub-Objects SUM > 15
        TheftRiskCoefficientDetector theftRiskCoefficientDetector = new TheftRiskCoefficientDetector();

        BigDecimal actual = theftRiskCoefficientDetector.detect(new BigDecimal("20.00"));
        BigDecimal expected = new BigDecimal("0.05");
        assertEquals(expected, actual);
    }

}