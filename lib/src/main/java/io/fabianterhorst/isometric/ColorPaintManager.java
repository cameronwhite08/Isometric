package io.fabianterhorst.isometric;

import android.graphics.Paint;
import android.util.SparseArray;

import java.util.HashMap;

class ColorPaintManager {

    private SparseArray<Object[]> paints;

    public ColorPaintManager(){
        this.paints = new SparseArray<>();
    }

    public Object[] getPaint(Path path, Color color) {
        int hash = path.hashCode() ^ color.hashCode();
        //get the paint if it already exists
        Object[] cp  = this.paints.get(hash);

        //create paint and store for reuse if doesn't already exist
        if (cp == null){
            cp = new Object[2];

            Color baseColor = Color.transformColor(path, color);

            Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
            p.setStyle(Paint.Style.FILL_AND_STROKE);
            p.setStrokeWidth(1);
            p.setColor(android.graphics.Color.argb((int) baseColor.a, (int) baseColor.r, (int) baseColor.g, (int) baseColor.b));

            cp[0] = baseColor;
            cp[1] = p;

            this.paints.put(hash, cp);
        }

        return cp;
    }

    public void clear(){
        this.paints.clear();
    }
}
