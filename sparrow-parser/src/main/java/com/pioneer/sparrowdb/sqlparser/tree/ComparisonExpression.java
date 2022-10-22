package com.pioneer.sparrowdb.sqlparser.tree;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class ComparisonExpression extends Expression {

    private final Operator operator;
    private final Expression left;
    private final Expression right;

    public ComparisonExpression(Operator operator, Expression left, Expression right) {
        requireNonNull(operator, "type is null");
        requireNonNull(left, "left is null");
        requireNonNull(right, "right is null");

        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    @Override
    public List<? extends Node> getChildren() {
        return ImmutableList.of(left, right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operator, left, right);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        ComparisonExpression that = (ComparisonExpression) obj;
        return (operator == that.operator) && Objects.equals(left, that.left) && Objects.equals(right, that.right);
    }

    @Override
    public String toString() {
        return left.toString() + operator.value + right.toString();
    }

    public enum Operator {
        EQUAL("="), NOT_EQUAL("<>"), LESS_THAN("<"), LESS_THAN_OR_EQUAL("<="), GREATER_THAN(">"),
        GREATER_THAN_OR_EQUAL(">="), IS_DISTINCT_FROM("IS DISTINCT FROM");

        private final String value;

        Operator(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public Operator flip() {
            switch (this) {
                case EQUAL:
                    return EQUAL;
                case NOT_EQUAL:
                    return NOT_EQUAL;
                case LESS_THAN:
                    return GREATER_THAN;
                case LESS_THAN_OR_EQUAL:
                    return GREATER_THAN_OR_EQUAL;
                case GREATER_THAN:
                    return LESS_THAN;
                case GREATER_THAN_OR_EQUAL:
                    return LESS_THAN_OR_EQUAL;
                case IS_DISTINCT_FROM:
                    return IS_DISTINCT_FROM;
                default:
                    throw new IllegalArgumentException("Unsupported comparison: " + this);
            }
        }

        public Operator negate() {
            switch (this) {
                case EQUAL:
                    return NOT_EQUAL;
                case NOT_EQUAL:
                    return EQUAL;
                case LESS_THAN:
                    return GREATER_THAN_OR_EQUAL;
                case LESS_THAN_OR_EQUAL:
                    return GREATER_THAN;
                case GREATER_THAN:
                    return LESS_THAN_OR_EQUAL;
                case GREATER_THAN_OR_EQUAL:
                    return LESS_THAN;
                default:
                    throw new IllegalArgumentException("Unsupported comparison: " + this);
            }
        }
    }
}
