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

import static com.google.common.base.MoreObjects.toStringHelper;
import static java.util.Objects.requireNonNull;

public class Select extends Node {
    private final boolean distinct;
    private final List<SelectItem> selectItems;

    public Select(boolean distinct, List<SelectItem> selectItems) {
        this.distinct = distinct;
        this.selectItems = ImmutableList.copyOf(requireNonNull(selectItems, "selectItems"));
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<SelectItem> getSelectItems() {
        return selectItems;
    }

    @Override
    public List<? extends Node> getChildren() {
        return selectItems;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distinct, selectItems);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Select select = (Select) obj;
        return (distinct == select.distinct) && Objects.equals(selectItems, select.selectItems);

    }

    @Override
    public String toString() {
        return toStringHelper(this).add("distinct", distinct).add("selectItems", selectItems).omitNullValues().toString();
    }
}
