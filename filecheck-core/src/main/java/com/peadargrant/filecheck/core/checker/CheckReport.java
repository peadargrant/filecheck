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
public interface CheckReport {
    
    /**
     * Blanks the report for a new check run
     */
    public void clear();
    
    /**
     * Posts a result to the report
     * @param checkResult 
     */
    public void post(CheckResult checkResult);
    
    /**
     * Set assignment name
     * @param assignmentName
     */
    public void setAssignmentName(String assignmentName);
}
