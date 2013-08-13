/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package checker;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class CheckResult {
    
    private String path;
    private String description;
    private String resultText;
    private Outcome outcome;

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
