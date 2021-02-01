package bo.gob.sin.sre.fac.frvcc.shared.model.criteria;

public enum FilterOperator {
    EQUAL("="),
    NOT_EQUAL("!="),
    GT(">"),
    LT("<"),
    GT_EQUAL(">="),
    LT_ECUAL("<="),
    CONTAINS("CONTAINS"),
    NOT_CONTAINS("NOT_CONTAINS"),
    IN("IN"),
    NOT_IN("NOT_IN"),
	IS_NULL("IS NULL"),
    IS_NOT_NULL("IS NOT NULL");


    private final String operator;

    FilterOperator(String operator) {
        this.operator = operator;
    }

    public static FilterOperator fromValue(String value) {
        switch (value) {
            case "=": return FilterOperator.EQUAL;
            case "!=": return FilterOperator.NOT_EQUAL;
            case ">": return FilterOperator.GT;
            case "<": return FilterOperator.LT;
            case ">=": return FilterOperator.GT_EQUAL;
            case "<=": return FilterOperator.LT_ECUAL;
            case "CONTAINS": return FilterOperator.CONTAINS;
            case "NOT_CONTAINS": return FilterOperator.NOT_CONTAINS;
            case "IN": return FilterOperator.IN;
            case "NOT_IN": return FilterOperator.NOT_IN;
            case "IS NULL": return FilterOperator.IS_NULL;
            case "IS NOT NULL": return FilterOperator.IS_NOT_NULL;
            default: return null;
        }
    }

    public boolean isPositive() {
        return this != NOT_EQUAL && this != NOT_CONTAINS;
    }

    public String value() {
        return operator;
    }
}
