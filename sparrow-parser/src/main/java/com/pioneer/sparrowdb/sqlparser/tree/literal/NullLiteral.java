package com.pioneer.sparrowdb.sqlparser.tree.literal;

import com.pioneer.sparrowdb.sqlparser.tree.Literal;

public class NullLiteral extends Literal {

    @Override
    public String toString() {
        return "null";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
