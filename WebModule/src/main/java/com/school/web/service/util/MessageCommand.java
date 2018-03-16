
package com.school.web.service.util;

import com.school.web.service.util.BaseObject;
import java.util.Objects;

/**
 *
 * @author jhonny
 */
public class MessageCommand extends BaseObject{
    private String cmd;    
    private String content;    

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MessageCommand other = (MessageCommand) obj;
        if (!Objects.equals(this.cmd, other.cmd)) {
            return false;
        }
        if (!Objects.equals(this.content, other.content)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\"cmd\":\"" + cmd +
                "\", \"content\":" + content;       
    }
}
