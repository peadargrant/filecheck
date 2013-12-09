/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package com.peadargrant.sw.filecheck.guiservices;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class ClipboardUtils {
    
    public static void copyHtmlToClipboard(String htmlString)
    {
            HtmlSelection htmlSelection = new HtmlSelection (htmlString);
            
            Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
            
            clpbrd.setContents (htmlSelection, null);
    }
    
}
