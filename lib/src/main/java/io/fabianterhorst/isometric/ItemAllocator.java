package io.fabianterhorst.isometric;

import stormpot.Allocator;
import stormpot.Slot;

public class ItemAllocator implements Allocator<Isometric.Item> {

    @Override
    public Isometric.Item allocate(Slot slot) throws Exception {
        return new Isometric.Item(slot);
    }

    @Override
    public void deallocate(Isometric.Item poolable) throws Exception {
        for (Point p : poolable.getTransformedPoints()){
            p.release();
        }
    }
}
