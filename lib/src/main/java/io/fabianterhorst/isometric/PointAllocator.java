package io.fabianterhorst.isometric;

import stormpot.Allocator;
import stormpot.Slot;

public class PointAllocator implements Allocator<Point> {

    @Override
    public Point allocate(Slot slot) throws Exception {
        return new Point(slot);
    }

    @Override
    public void deallocate(Point poolable) throws Exception {

    }
}
