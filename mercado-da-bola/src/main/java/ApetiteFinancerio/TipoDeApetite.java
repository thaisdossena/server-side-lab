package ApetiteFinancerio;

import java.math.BigDecimal;

//RN03
public enum TipoDeApetite implements ApetiteFinanceiro {
    INDIFERENTE {
        @Override
        public BigDecimal getPercentual() {
            return BigDecimal.valueOf(1);
        }
    },
    CONSERVADOR {
        @Override
        public BigDecimal getPercentual() {
            return BigDecimal.valueOf(1.40);
        }
    },
    MERCENARIO {
        @Override
        public BigDecimal getPercentual() {
            return BigDecimal.valueOf(1.80);
        }
    };
}