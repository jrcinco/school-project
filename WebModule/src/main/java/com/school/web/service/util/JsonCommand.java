
package com.school.web.service.util;

import java.util.Date;

/**
 *
 * @author jhonny
 */
public class JsonCommand extends MessageCommand{
    private long timestamp = new Date().getTime();
    private String observation;        
    private String result;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }   

    @Override
    public String toString() {
        return "{" + super.toString() + ", \"timestamp\":\"" + timestamp + 
                "\", \"observation\":\""+observation+"\", \"result\":\" "+result+
                "\"}";
    }    
}
