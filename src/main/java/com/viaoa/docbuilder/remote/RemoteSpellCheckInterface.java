// Copied from OATemplate project by OABuilder 06/20/21 11:44 AM
package com.viaoa.docbuilder.remote;

import com.viaoa.remote.multiplexer.annotation.OARemoteInterface;

@OARemoteInterface
public interface RemoteSpellCheckInterface {

    public final static String BindName = "RemoteSpellCheck";
    
    public String[] getMatchingWords(String word);
    public String[] getSoundexMatchingWords(String word);
    public void addNewWord(String word);
    public boolean isWordFound(String word);
    
}
