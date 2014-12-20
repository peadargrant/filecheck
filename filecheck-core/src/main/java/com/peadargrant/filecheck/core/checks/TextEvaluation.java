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
package com.peadargrant.filecheck.core.checks;

import com.peadargrant.filecheck.core.checker.CheckImplementation;
import com.peadargrant.filecheck.core.checker.CheckResult;
import com.peadargrant.filecheck.core.checker.Outcome;
import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class TextEvaluation extends CheckImplementation {

    private int requestedLine() {
        return new Integer(this.stringParameters.get("line"));
    }

    @Override
    public void runCheck(InputStream inputStream, CheckResult cr) {

        Scanner scanner = new Scanner(inputStream).useDelimiter("\n");

        String outputLine = "";
        int k = 0;
        while (scanner.hasNext()) {
            k = k + 1;
            outputLine = scanner.next();
            if (k == this.requestedLine()) {
                cr.setResultText(outputLine);
                cr.setOutcome(Outcome.PASS);
                return;
            }
        }

        cr.setResultText("(end reached)");
        cr.setOutcome(Outcome.FAIL);

    }

    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append("Line ");
        sb.append(this.requestedLine());
        return sb.toString();
    }

}
