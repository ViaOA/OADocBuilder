// Copied from OATemplate project by OABuilder 06/20/21 11:44 AM
package com.viaoa.docbuilder.remote;

import java.io.File;

import com.viaoa.remote.multiplexer.annotation.OARemoteInterface;

@OARemoteInterface
public interface RemoteFileInterface {

    public final static String BindName = "RemoteFile";

    public boolean saveFile(File file, byte[] bytes);
    public long getFileTime(String fname);
    public boolean getDoesFileExist(String fname);
    public byte[] getFile(String fname);
    public byte[] getNewerFile(String fname, long ltime);
    public boolean deleteFile(String fname);

    
}
