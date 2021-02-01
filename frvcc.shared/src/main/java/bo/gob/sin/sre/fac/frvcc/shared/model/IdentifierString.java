package bo.gob.sin.sre.fac.frvcc.shared.model;

import java.util.Objects;
import java.util.UUID;

public abstract  class IdentifierString {
    final protected String value;

    public IdentifierString(String value) {
        ensureValidUuid(value);

        this.value = value;
    }

    protected IdentifierString() {
        this.value = null;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Identifier that = (Identifier) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    private void ensureValidUuid(String value) throws IllegalArgumentException {
        UUID.fromString(value);
    }
}
