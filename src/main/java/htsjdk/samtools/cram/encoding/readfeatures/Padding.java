/**
 * ****************************************************************************
 * Copyright 2013 EMBL-EBI
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ****************************************************************************
 */
package htsjdk.samtools.cram.encoding.readfeatures;

import java.io.Serializable;
import java.util.Objects;

/**
 * A read feature representing padding, similar to {@link htsjdk.samtools.CigarOperator#P}.
 */
public class Padding implements Serializable, ReadFeature {

    private int position;
    private int length;
    public static final byte operator = 'P';

    public Padding(final int position, final int length) {
        this.position = position;
        this.length = length;
    }

    @Override
    public byte getOperator() {
        return operator;
    }

    @Override
    public int getPosition() {
        return position;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return String.valueOf((char) operator) + '@' + position + '+' + length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Padding padding = (Padding) o;
        return position == padding.position &&
                length == padding.length;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, length);
    }
}
