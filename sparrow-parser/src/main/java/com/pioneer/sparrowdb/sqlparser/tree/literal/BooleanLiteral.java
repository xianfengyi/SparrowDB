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

import com.google.common.base.Preconditions;
import com.pioneer.sparrowdb.sqlparser.tree.Literal;

import java.util.Objects;

import static java.util.Locale.ENGLISH;
import static java.util.Objects.requireNonNull;

public class BooleanLiteral extends Literal {
    public static final BooleanLiteral TRUE_LITERAL = new BooleanLiteral("true");
    public static final BooleanLiteral FALSE_LITERAL = new BooleanLiteral("false");

    private final boolean value;

    public BooleanLiteral(String value) {
        requireNonNull(value, "value is null");
        Preconditions.checkArgument(value.toLowerCase(ENGLISH).equals("true") || value.toLowerCase(ENGLISH).equals(
                "false"));

        this.value = value.toLowerCase(ENGLISH).equals("true");
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BooleanLiteral other = (BooleanLiteral) obj;
        return Objects.equals(this.value, other.value);
    }
}
