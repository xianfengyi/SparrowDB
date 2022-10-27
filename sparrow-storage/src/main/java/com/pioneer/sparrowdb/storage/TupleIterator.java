package com.pioneer.sparrowdb.storage;

import java.util.Iterator;

/**
 * Implements a DbIterator by wrapping an Iterable<Tuple>.
 */
public class TupleIterator implements DbIterator {
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    Iterator<Tuple> iterator = null;
    TupleDesc tupleDesc = null;
    Iterable<Tuple> tuples = null;

    /**
     * Constructs an iterator from the specified Iterable, and the specified
     * descriptor.
     * 
     * @param tuples
     *            The set of tuples to iterate over
     */
    public TupleIterator(TupleDesc td, Iterable<Tuple> tuples) {
        this.tupleDesc = td;
        this.tuples = tuples;

        // check that all tuples are the right TupleDesc
        for (Tuple t : tuples) {
            if (!t.getTupleDesc().equals(td))
                throw new IllegalArgumentException(
                        "incompatible tuple in tuple set");
        }
        open();
    }

    public void open() {
        iterator = tuples.iterator();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public Tuple next() {
        return iterator.next();
    }

    public void rewind() {
        close();
        open();
    }

    public TupleDesc getTupleDesc() {
        return tupleDesc;
    }

    public void close() {
        iterator = null;
    }
}
