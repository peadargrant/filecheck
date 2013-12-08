/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package checker;

import assignments.Parameter;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public abstract class CheckImplementation {
    
    protected HashMap<String,String> stringParameters;
    
    /**
     * Applies parameters specified in XML file to HashMap
     * @param parameters 
     */
    public void applyParameters(List<Parameter> parameters)
    {
        if ( null == this.stringParameters )
        {
            this.stringParameters = new HashMap<>(); 
        }
        
        for ( Parameter p : parameters )
        {
            stringParameters.put(p.getName(), p.getValue());
        }
    }
    
    /**
     * Runs the check on the InputStream given
     * @param input
     * @return 
     */
    public abstract void runCheck(InputStream input, CheckResult cr);
    
    /**
     * Returns the printable description 
     * @return the printable description
     */
    public abstract String getDescription();
    
    @Override
    public String toString()
    {
        return getDescription(); 
    }
}
