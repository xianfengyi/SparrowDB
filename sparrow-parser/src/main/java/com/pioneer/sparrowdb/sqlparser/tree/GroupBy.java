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

import java.util.List;
import java.util.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;

public class GroupBy extends Node
{
    private List<GroupingElement> groupingElements;

    public GroupBy(List<GroupingElement> groupingElements) {
        this.groupingElements = groupingElements;
    }

    public List<GroupingElement> getGroupingElements()
    {
        return groupingElements;
    }

    @Override
    public List<? extends Node> getChildren()
    {
        return groupingElements;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GroupBy groupBy = (GroupBy) o;
        return Objects.equals(groupingElements, groupBy.groupingElements);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(groupingElements);
    }

    @Override
    public String toString()
    {
        return toStringHelper(this)
                .add("groupingElements", groupingElements)
                .toString();
    }
}
