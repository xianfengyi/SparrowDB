/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pioneer.sparrowdb.sqlparser.tree.literal;

import com.pioneer.sparrowdb.sqlparser.ParsingException;
import com.pioneer.sparrowdb.sqlparser.tree.Literal;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public final class GenericLiteral extends Literal {
    private final String type;
    private final String value;

    private GenericLiteral(String type, String value) {
        requireNonNull(type, "type is null");
        requireNonNull(value, "value is null");
        if (type.equalsIgnoreCase("X")) {
            // we explicitly disallow "X" as type name, so if the user arrived here,
            // it must be because that he intended to give a binaryLiteral instead, but
            // added whitespace between the X and quote
            throw new ParsingException("Spaces are not allowed between 'X' and the starting quote of a binary literal");
        }
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, type);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        GenericLiteral other = (GenericLiteral) obj;
        return Objects.equals(this.value, other.value) &&
                Objects.equals(this.type, other.type);
    }
}
