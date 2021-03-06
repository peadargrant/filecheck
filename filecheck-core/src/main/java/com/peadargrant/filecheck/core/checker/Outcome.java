/* 
 * Copyright (C) 2014 Peadar Grant
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.peadargrant.filecheck.core.checker;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public enum Outcome {

    PASS(Color.GREEN, false),
    FAIL(Color.RED, true),
    CHECK_FAILURE(Color.YELLOW, true),
    SKIPPED(Color.YELLOW, false),
    ADVISORY(Color.YELLOW, false);

    private final Color color;
    private final Color saturatedColor;
    private final boolean fails;

    private Color clampedColour(Color color, int min, int max) {
        ArrayList<Integer> rgb = new ArrayList<>();

        rgb.add(color.getRed());
        rgb.add(color.getGreen());
        rgb.add(color.getBlue());

        for (int k = 0; k < rgb.size(); k++) {
            if (rgb.get(k) < min) {
                rgb.set(k, min);
            } else if (rgb.get(k) > max) {
                rgb.set(k, max);
            }
        }

        return new Color(rgb.get(0), rgb.get(1), rgb.get(2));
    }

    private Outcome(Color color, boolean fails) {

        this.saturatedColor = this.clampedColour(color, 0, 100);
        this.color = this.clampedColour(color, 150, 3000);
        this.fails = fails;
    }

    public Color getColor() {
        return this.color;
    }

    public Color getSaturatedColor() {
        return this.saturatedColor;
    }

    public boolean causesFailure() {
        return this.fails;
    }

}
