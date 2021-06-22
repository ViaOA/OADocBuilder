// Copied from OATemplate project by OABuilder 06/20/21 11:44 AM
package com.viaoa.docbuilder.view;

import java.net.URL;

import javax.swing.*;

import com.viaoa.docbuilder.resource.Resource;

/**
 *  This is used as a base Frame for dialogs that
 *  are used before the main Frame is displayed.
 */
public class DummyFrame extends JFrame {
	public DummyFrame() {
        this.setIconImage(Resource.getJarIcon(Resource.getValue(Resource.IMG_AppClientIcon)).getImage());
	}
}

