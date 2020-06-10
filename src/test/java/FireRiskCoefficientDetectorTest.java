import businesslogic.FireRiskCoefficientDetector;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class FireRiskCoefficientDetectorTest {

    @Test
    public void detectTestV1() {                                                                                        //Insured Sub-Objects SUM < 100
        FireRiskCoefficientDetector fireRiskCoefficientDetector = new FireRiskCoefficientDetector();
        BigDecimal actual = fireRiskCoefficientDetector.detect(new BigDecimal("50.00"));
        BigDecimal expected = new BigDecimal("0.014");
        assertEquals(expected, actual);
    }

    @Test
    public void detectTestV2() {                                                                                        //Insured Sub-Objects SUM = 100
        FireRiskCoefficientDetector fireRiskCoefficientDetector = new FireRiskCoefficientDetector();
        BigDecimal actual = fireRiskCoefficientDetector.detect(new BigDecimal("100.00"));
        BigDecimal expected = new BigDecimal("0.014");
        assertEquals(expected, actual);
    }

    @Test
    public void detectTestV3() {                                                                                        //Insured Sub-Objects SUM > 100
        FireRiskCoefficientDetector fireRiskCoefficientDetector = new FireRiskCoefficientDetector();
        BigDecimal actual = fireRiskCoefficientDetector.detect(new BigDecimal("150"));
        BigDecimal expected = new BigDecimal("0.024");
        assertEquals(expected, actual);
    }

}