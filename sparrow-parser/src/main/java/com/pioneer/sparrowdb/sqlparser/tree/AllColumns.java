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
package com.pioneer.sparrowdb.sqlparser.tree;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class AllColumns extends SelectItem {
    private final Optional<QualifiedName> prefix;

    public AllColumns() {
        prefix = Optional.empty();
    }

    public AllColumns(QualifiedName prefix) {
        this.prefix =Optional.of(prefix);
    }

    public Optional<QualifiedName> getPrefix() {
        return prefix;
    }

    @Override
    public List<Node> getChildren() {
        return ImmutableList.of();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AllColumns that = (AllColumns) o;
        return Objects.equals(prefix, that.prefix);
    }

    @Override
    public int hashCode() {
        return prefix.hashCode();
    }

    @Override
    public String toString() {
        if (prefix.isPresent()) {
            return prefix.get() + ".*";
        }

        return "*";
    }
}
