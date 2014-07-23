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

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class CheckResult {
    
    private String path = "";
    private String description = "";
    private String resultText = "";
    private Outcome outcome = Outcome.CHECK_FAILURE;
    private String details = "";

    /**
     * Get the value of details
     *
     * @return the value of details
     */
    public String getDetails() {
        return details;
    }

    /**
     * Set the value of details
     *
     * @param details new value of details
     */
    public void setDetails(String details) {
        this.details = details;
    }


    /**
     * Get the value of description
     *
     * @return the value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the value of description
     *
     * @param description new value of description
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * Get the value of path
     *
     * @return the value of path
     */
    public String getPath() {
        return path;
    }

    /**
     * Set the value of path
     *
     * @param path new value of path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Get the value of outcome
     *
     * @return the value of outcome
     */
    public Outcome getOutcome() {
        return outcome;
    }

    /**
     * Set the value of outcome
     *
     * @param outcome new value of outcome
     */
    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }


    /**
     * Get the value of resultText
     *
     * @return the value of resultText
     */
    public String getResultText() {
        return resultText;
    }

    /**
     * Set the value of resultText
     *
     * @param resultText new value of resultText
     */
    public void setResultText(String resultText) {
        this.resultText = resultText;
    }

    
}
