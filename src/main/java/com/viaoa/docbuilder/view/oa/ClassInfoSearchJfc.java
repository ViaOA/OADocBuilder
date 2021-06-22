// Generated by OABuilder 
package com.viaoa.docbuilder.view.oa;

import java.awt.*;
import java.awt.Dialog.*;
import java.awt.event.*;
import java.net.URL;
import java.util.logging.*;

import javax.swing.*;
import javax.swing.SwingWorker.StateValue;
import javax.swing.text.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.text.*;

import com.viaoa.object.*;
import com.viaoa.hub.*;
import com.viaoa.jfc.*;
import com.viaoa.jfc.OAButton.*;
import com.viaoa.jfc.control.*;
import com.viaoa.image.*;
import com.viaoa.jfc.text.*;
import com.viaoa.jfc.table.*;
import com.viaoa.util.*;
import com.viaoa.datasource.*;

import com.viaoa.docbuilder.delegate.*;
import com.viaoa.docbuilder.delegate.oa.*;
import com.viaoa.docbuilder.model.*;
import com.viaoa.docbuilder.model.oa.*;
import com.viaoa.docbuilder.model.oa.propertypath.*;
import com.viaoa.docbuilder.model.oa.search.*;
import com.viaoa.docbuilder.model.search.*;
import com.viaoa.docbuilder.resource.Resource;
import com.viaoa.docbuilder.view.*;

public class ClassInfoSearchJfc {
    private static Logger LOG = Logger.getLogger(ClassInfoSearchJfc.class.getName());
    
    private ClassInfoSearchModel model;
    private JDialog dialog;
    protected ClassInfoJfc jfcClassInfo;
    
    protected boolean bShowResults;
    protected boolean bMultiSelect;
    protected ClassInfo classInfoSelected;
    protected boolean bSelected;
    
    public ClassInfoSearchJfc() {
        this(null, true, false);
    }
    public ClassInfoSearchJfc(ClassInfoSearchModel model) {
        this(model, true, false);
    }
    public ClassInfoSearchJfc(ClassInfoSearchModel model, boolean bShowResults, boolean bMultiSelect) {
        this.model = model;
        this.bShowResults = bShowResults;
        this.bMultiSelect = bMultiSelect;
    }
    public ClassInfoSearchJfc(boolean bShowResults) {
        this(null, bShowResults, false);
    }
    
    public ClassInfoSearchModel getModel() {
        if (model == null) {
            model = new ClassInfoSearchModel();
            model.getClassInfoSearch().setMaxResults(100); // default for UI searches
        }
        return model;
    }
    public Hub<ClassInfo> getHub() {
        return getModel().getHub();
    }
    
    public JPanel createMainPanel() {
        JPanel panMain = new JPanel(new BorderLayout());
    
        JPanel panSearchFrom = createSearchFromPanel();
        JPanel panSearchTree = createSearchTreePanel();
        JPanel panSearch = createSearchPanel();
    
        int cnt = 0;
        if (panSearchFrom != null) cnt++;
        if (panSearchTree != null) cnt++;
        if (panSearch != null) cnt++;
        if (cnt == 0) return panMain;
    
        JTabbedPane tabbedPane = null;
        if (cnt > 1) {
            tabbedPane = new JTabbedPane();
            tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
            tabbedPane.setFocusable(true);
    
            Icon icon = Resource.getJarIcon("classInfo.gif");
            if (panSearch != null) {
                icon = new ScaledImageIcon(icon, 32, 20);
                tabbedPane.addTab("Search", icon, panSearch);
            }
            if (panSearchFrom != null) {
                icon = new ScaledImageIcon(icon, 32, 20);
                tabbedPane.addTab("Selection List", icon, panSearchFrom);
            }
            if (panSearchTree != null) {
                icon = new ScaledImageIcon(icon, 32, 20);
                tabbedPane.addTab("Selection Tree", icon, panSearchTree);
            }
        }
    
        JPanel panMultiSelect = null;
        if (bShowResults && bMultiSelect) panMultiSelect = createMultiSelectPanel();
    
        if (tabbedPane != null) panMain.add(tabbedPane, BorderLayout.CENTER);
        else {
            if (panSearchFrom != null) panMain.add(panSearchFrom, BorderLayout.CENTER);
            else if (panSearchTree != null) panMain.add(panSearchTree, BorderLayout.CENTER);
            else if (panSearch != null) panMain.add(panSearch, BorderLayout.CENTER);
        }
    
        if (panMultiSelect != null) {
            final JComponent compx = panMain;
            final JSplitPane sp = new OASplitPane(JSplitPane.VERTICAL_SPLIT, panMain, panMultiSelect);
            sp.setDividerSize(10);
            sp.setOneTouchExpandable(true);
    
            panMain = new JPanel(new BorderLayout());
            panMain.add(sp, BorderLayout.CENTER);
        }
    
        String cmdName = "Cancel";
        panMain.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false), cmdName);
        panMain.getActionMap().put(cmdName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });
    
        panMain.setBorder(new EmptyBorder(5,5,5,5));
        return panMain;
    }
    
    public JPanel createSearchFromPanel() {
        final Hub<ClassInfo> hub = getModel().getSearchFromHub();
        if (hub == null || !bShowResults) return null;
    
        final JPanel pan = new JPanel(new BorderLayout(0,0));
        pan.setBorder(new EmptyBorder(5,5,5,5));
        OATable table = createReadOnlyTable(hub);
        OATableScrollPane spTable = new OATableScrollPane(table, 1);
        pan.add(spTable, BorderLayout.CENTER);
    
        if (bMultiSelect) table.setMultiSelectControlKey(true);
        else {
            JPanel panx = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
            panx.add(createSelectOneButton(hub));
            panx.add(createCancelButton());
            pan.add(panx, BorderLayout.SOUTH);
    
            String cmdName = "select";
            pan.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true), cmdName);
            pan.getActionMap().put(cmdName, new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    ClassInfo classInfo = hub.getAO();
                    if (classInfo != null) onSelect(classInfo, hub);
                }
            });
        }
        return pan;
    }
    
    public JPanel createMultiSelectPanel() {
        final Hub<ClassInfo> hub = getModel().getMultiSelectHub();
        JPanel pan = new JPanel(new BorderLayout(0,0));
        pan.setBorder(new EmptyBorder(5,5,5,5));
    
        JLabel lbl = new JLabel("ClassInfos to add");
        lbl.setFont(lbl.getFont().deriveFont(14.0f));
        lbl.setBorder(new EmptyBorder(5, 10, 5, 5));
        pan.add(lbl, BorderLayout.NORTH);
    
        OATable table = createReadOnlyTable(hub);
        OATableScrollPane spTable = new OATableScrollPane(table, 1);
        pan.add(spTable, BorderLayout.CENTER);
    
        JPanel panx = new JPanel(new GridLayout());
        panx.add(createGotoEditButton(hub));
        panx.add(createSelectManyButton());
        panx.add(createCancelButton());
        JButton cmdRemove = createRemoveButton(hub);
        panx.add(cmdRemove);
        JButton cmdRemoveAll = createRemoveAllButton(hub);
        panx.add(cmdRemoveAll);
        JPanel panz = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        panz.add(panx);
        pan.add(panz, BorderLayout.SOUTH);
    
        String cmdName = "Ok";
        pan.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true), cmdName);
        pan.getActionMap().put(cmdName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                onSelect(getModel().getMultiSelectHub());
            }
        });
    
        cmdName = "Remove";
        pan.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0, true), cmdName);
        pan.getActionMap().put(cmdName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                hub.remove(hub.getPos());
            }
        });
        return pan;
    }
    
    public JPanel createSearchTreePanel() {
        // no tree properties defined in model, for ClassInfo
        if (true || false) return null;
        // if (!bShowResults) return null;
        final JPanel pan = new JPanel(new BorderLayout(0,0));
        pan.setBorder(new EmptyBorder(5,5,5,5));
    
        final ClassInfoModel model = new ClassInfoModel();
        if (bMultiSelect) {
            model.setAllowMultiSelect(true);
            model.getMultiSelectHub().setSharedHub(getModel().getMultiSelectHub());
        }
    
        if (!bMultiSelect) {
            JPanel panx = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
            panx.add(createSelectOneButton(model.getHub()));
            panx.add(createCancelButton());
    
            String cmdName = "select";
            pan.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true), cmdName);
            pan.getActionMap().put(cmdName, new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    ClassInfo classInfo = model.getHub().getAO(); 
                    if (classInfo != null) onSelect(classInfo, model.getHub());
                }
            });
            pan.add(panx, BorderLayout.SOUTH);
        }
    
        final JLabel jlbl = new JLabel("loading ...", Resource.getJarIcon("wait.png"), JLabel.CENTER);
        pan.add(jlbl, BorderLayout.CENTER);
        SwingWorker<OATree, Void> sw = new SwingWorker<OATree, Void>() {
            @Override
            protected OATree doInBackground() throws Exception {
                ClassInfoJfc jfcClassInfo = new ClassInfoJfc(model);
                OATree tree = jfcClassInfo.createSearchTree();
                tree.preload();
                return tree;
            }
            @Override
            protected void done() {
                jlbl.setText(null);
                jlbl.setIcon(null);
                try {
                    OATree tree = get();
                    pan.add(new JScrollPane(tree), BorderLayout.CENTER);
                }
                catch (Exception e) {
                }
            }
        };
        sw.execute();
        return pan;
    }
    
    protected JPanel createSearchPanel() {
        // no search properties defined in model, for "+objectDef.getName()
        if (getModel().getSearchFromHub() != null) return null;
        final JPanel panTop = new JPanel(new BorderLayout(0,0));
        panTop.add(new JScrollPane(createSearchInputPanel()), BorderLayout.CENTER);
        panTop.setBorder(new EmptyBorder(5,5,5,5));
    
        String cmdName = "search";
        panTop.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true), cmdName);
        panTop.getActionMap().put(cmdName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                onSearch(panTop);
            }
        });
    
        JPanel panx = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        panx.add(createSearchButton());
        panx.add(createResetButton());
        panTop.add(panx, BorderLayout.SOUTH);
    
        if (!bShowResults) return panTop;
        JPanel panBottom = createSearchResultsPanel();
        JSplitPane sp = new OASplitPane(JSplitPane.VERTICAL_SPLIT, panTop, panBottom);
        sp.setDividerSize(10);
        sp.setOneTouchExpandable(true);
    
        JPanel pan = new JPanel(new BorderLayout());
        pan.setBorder(new EmptyBorder(5,5,5,5));
        pan.add(sp);
        return pan;
    }
    protected JPanel createSearchInputPanel() {
        final JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(2, 2, 2, 2);
        gc.anchor = gc.WEST;
    
        JPanel panx;
        JLabel lbl;
        JButton cmd;
        OATextField txt;
        
        lbl = new JLabel("Max Results:");
        txt = createMaxResultsTextField();
        txt.setLabel(lbl);
        panel.add(lbl, gc);
        gc.gridwidth = gc.REMAINDER;
        panel.add(txt, gc);
        gc.gridwidth = 1;
        
        // filler
        gc.weightx = gc.weighty = 1f;
        gc.gridwidth = gc.REMAINDER;
        panel.add(new JLabel(""), gc);
        
        InputMap im = panel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true), "search");
        panel.getActionMap().put("search", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                onSearch(panel);
            }
        });
        
        panel.setBorder(new EmptyBorder(5,5,5,5));
        return panel;
    }
    
    protected JPanel createSearchResultsPanel() {
        JPanel panel = new JPanel(new BorderLayout(0,0));
        panel.setBorder(new EmptyBorder(5,5,5,5));
    
        JLabel lbl = new JLabel("Search Results");
        lbl.setFont(lbl.getFont().deriveFont(14.0f));
        lbl.setBorder(new EmptyBorder(5, 10, 5, 5));
        panel.add(lbl, BorderLayout.NORTH);
    
        final Hub<ClassInfo> hub = getHub();
        OATable table = createReadOnlyTable(hub);
        OATableScrollPane spTable = new OATableScrollPane(table, 1);
        panel.add(spTable, BorderLayout.CENTER);
    
        if (!bMultiSelect) {
            JPanel pan = new JPanel(new GridLayout(1, 0, 5, 0));
            pan.add(createGotoEditButton(getModel().getHub()));
            pan.add(createSelectOneButton(hub));
            pan.add(createCancelButton());
            JPanel panx = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
            panx.add(pan);
    
            String cmdName = "select";
            table.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), cmdName);
            table.getActionMap().put(cmdName, new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    ClassInfo classInfo = hub.getAO();
                    if (classInfo != null) onSelect(classInfo, hub);
                }
            });
            panel.add(panx, BorderLayout.SOUTH);
        }
        return panel;
    }
    
    
    public OATextField createMaxResultsTextField() {
        OATextField txt = new OATextField(getModel().getClassInfoSearchHub(), ClassInfoSearch.P_MaxResults, 5);
        txt.setToolTipText("set the maximum rows to return");
        return txt;
    }
    
    
    protected void setup(JTextComponent txt) {
        OATextController tc = new OATextController(txt, Resource.getSpellChecker(), true);
        String s = txt.getToolTipText();
        if (!OAString.isEmpty(s)) s = "<html>]"+s+"<br>";
        else s = "<html>";
        s += "<small><i>Right click for more options";
        txt.setToolTipText(s);
    }
    
    public JButton createSearchButton() {
        URL url = OAButton.class.getResource("icons/search.gif");
        if (url == null) return null;
        Icon icon = new ImageIcon(url);
        final JButton cmdSearch = new JButton("Run Search", icon);
        cmdSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSearch(cmdSearch);
            }
        });
        OAButton.setup(cmdSearch);
        cmdSearch.setFocusPainted(true);
        return cmdSearch;
    }
    public JButton createResetButton() {
        URL url = OAButton.class.getResource("icons/cancel.gif");
        if (url == null) return null;
        Icon icon = new ImageIcon(url);
        JButton cmdReset = new JButton("Reset", icon);
        cmdReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onReset();
            }
        });
        OAButton.setup(cmdReset);
        cmdReset.setFocusPainted(true);
        return cmdReset;
    }
    
    public OATable createReadOnlyTable(final Hub<ClassInfo> hubClassInfo) {
        Hub<ClassInfo> hubx = new Hub(ClassInfo.class);
        OATable table = new OATable(hubx) {
            @Override
            public void onDoubleClick() {
                if (ClassInfoSearchJfc.this.getModel().getMultiSelectHub() != hubClassInfo) {
                    ClassInfo classInfo = hubClassInfo.getAO();
                    if (classInfo != null) onSelect(classInfo, hubClassInfo);
                }
            }
        };
        table.setFilterMasterHub(hubClassInfo);
        table.setAllowDnD(false);
        table.setAllowSorting(true);
        table.addCounterColumn();
    
        if (bMultiSelect && getModel().getMultiSelectHub() != hubClassInfo) {
            table.addSelectionColumn(getModel().getMultiSelectHub(), "Select", 5);
        }
        createTableColumns(table);
        table.setPreferredSize(8, 3, true);
        return table;
    }
    protected void createTableColumns(OATable table) {
        getClassInfoJfc().createReadOnlyTableColumns(table);
    }
    public OAButton createSelectOneButton(final Hub<ClassInfo> hub) {
        OAButton cmd = new OAButton(hub, "Select", OAButton.SELECT) {
            @Override
            public void afterActionPerformed() {
                onSelect(hub.getAO(), hub);
            }
        };
        cmd.setToolTipText("Add selected ClassInfo");
        OAButton.setup(cmd);
        cmd.setFocusPainted(true);
        return cmd;
    }
    public JButton createSelectManyButton() {
        URL url = OAButton.class.getResource("icons/add.gif");
        if (url == null) return null;
        Icon icon = new ImageIcon(url);
        JButton cmd = new JButton("Ok", icon);
        new ButtonController(getModel().getMultiSelectHub(), cmd, OAButton.HubIsNotEmpty, ButtonCommand.Other);
        
        cmd.setToolTipText("Add selected ClassInfos");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSelect(getModel().getMultiSelectHub());
            }
        });
        OAButton.setup(cmd);
        cmd.setFocusPainted(true);
        return cmd;
    }
    public OAButton createRemoveButton(Hub<ClassInfo> hub) {
        OAButton cmd = new OAButton(hub, OAButton.REMOVE);
        cmd.setText("Remove");
        cmd.setup();
        cmd.setToolTipText("Remove selected ClassInfo");
        return cmd;
    }
    public OAButton createRemoveAllButton(Hub<ClassInfo> hub) {
        OAButton cmd = new OAButton(hub, "Remove All", OAButton.SelectHubIsNotEmpty, OAButton.REMOVE);
        cmd.setMultiSelectHub(getModel().getMultiSelectHub());
        cmd.setup();
        cmd.setToolTipText("Remove all ClassInfos from the select list");
        return cmd;
    }
    public JButton createCancelButton() {
        URL url = OAButton.class.getResource("icons/cancel.gif");
        if (url == null) return null;
        Icon icon = new ImageIcon(url);
        JButton cmd = new JButton("Cancel", icon);
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });
        OAButton.setup(cmd);
        cmd.setFocusPainted(true);
        return cmd;
    }
    
    public ClassInfoJfc getClassInfoJfc() {
        if (jfcClassInfo == null) {
            jfcClassInfo = new ClassInfoJfc(new Hub<ClassInfo>(ClassInfo.class));
            OAObjectModel om = jfcClassInfo.getModel();
            om.setAllowAdd(false);
            om.setAllowNew(false);
            om.setAllowRemove(false);
            om.setAllowSave(false);
            om.setAllowDelete(false);
            om.setAllowClear(false);
            om.setViewOnly(true);
        }
        return jfcClassInfo;
    }
    public OAButton createGotoEditButton(final Hub<ClassInfo> hub) {
        OAButton cmd = new OAButton(hub, "Details ...", Resource.getJarIcon(Resource.IMG_Goto), OAButton.GOTO) {
            @Override
            public void afterActionPerformed() {
                getClassInfoJfc().getHub().setSharedHub(hub, true);
                getClassInfoJfc().getEditDialog(this).setVisible(true);
                super.afterActionPerformed();
            }
        };
        OAButton.setup(cmd);
        return cmd;
    }
    
    public JDialog getDialog() {
        if (dialog != null) return dialog;
        Window win = JfcDelegate.getMainWindow();
        dialog = new JDialog(win, "Class Info Search", ModalityType.APPLICATION_MODAL);
        
        dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        dialog.setLayout(new BorderLayout());
        dialog.add(createMainPanel(), BorderLayout.CENTER);
        OAJfcUtil.pack(dialog);
        
        Dimension d = dialog.getSize();
        Dimension dScr = Toolkit.getDefaultToolkit().getScreenSize();
        int w = (int) Math.min((d.width * 1.25), (dScr.width * .75));
        int h = (int) Math.min((d.height * 1.25), (dScr.height * .75));
        dialog.setSize(w, h);
        
        Component compx = dialog.getParent();
        if (compx != null) dialog.setLocationRelativeTo(compx);
        
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                ClassInfoSearchJfc.this.bSelected = false;
                onShowDialog();
            }
            @Override
            public void windowClosing(WindowEvent e) {
                if (!ClassInfoSearchJfc.this.bSelected) {
                    ClassInfoSearchJfc.this.onCancel();
                }
                onHideDialog();
            }
        });
        return dialog;
    }
    
    protected void onShowDialog() {
    }
    
    protected void onHideDialog() {
    }
    
    
    protected void onReset() {
        getHub().cancelSelect();
        getHub().clear();
        getModel().getClassInfoSearch().reset();
    }
    
    protected void onSelect(ClassInfo classInfo, Hub<ClassInfo> hubFrom) {
        classInfoSelected = classInfo;
        bSelected = true;
        getHub().cancelSelect();
        getModel().onSelect(classInfo, hubFrom);
        if (dialog != null) dialog.setVisible(false);
    }
    protected void onSelect(Hub<ClassInfo> hub) {
        bSelected = true;
        getHub().cancelSelect();
        getModel().onSelect(hub); 
        if (dialog != null) dialog.setVisible(false);
    }
    protected void onCancel() {
        bSelected = false;
        classInfoSelected = null;
        getHub().cancelSelect();
        if (dialog != null) dialog.setVisible(false);
    }
    
    protected void onSearch(final JComponent compFrom) {
        /*
        if (!getModel().getClassInfoSearch().isDataEntered()) {
            String msg = "Please enter selection data.";
            JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(compFrom), msg, "ClassInfo Search", JOptionPane.WARNING_MESSAGE);
            return;
        }
        */
        
        Component compFocus = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
        if (compFrom != null) compFrom.requestFocusInWindow();
        final OAWaitDialog dlgWait = new OAWaitDialog(SwingUtilities.getWindowAncestor(compFrom)) {
            @Override
            protected void onCancel() {
                getHub().cancelSelect();
            }
        };
        dlgWait.setStatus("Selecting ClassInfos ... please wait ...");
        dlgWait.setTitle("ClassInfo Search");
        
        SwingWorker<Void, Void> sw = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                getModel().performSearch();
                for (int i=0;;i+=50) {
                    if (dlgWait.wasCancelled()) {
                        getHub().cancelSelect();
                        break;
                    }
                    if (getHub().getAt(i) == null) break;
                }
                return null;
            }
            @Override
            protected void done() {
                try {
                    for (int i=0; i<10; i++) {
                        if (dlgWait.isVisible() || dlgWait.wasCancelled() ) break;
                        Thread.sleep(5);
                    }
                }
                catch (Exception e) {}
                dlgWait.setVisible(false);
            }
        };
        sw.execute();
        dlgWait.setVisible(true); // note: this is modal, code wont continue until search is done or cancelled.
        if (dlgWait.wasCancelled()) {
        }
        else if (getHub().getSize() == 0) {
            String msg = "No ClassInfos were found.";
            try {
                sw.get();
            }
            catch (Exception e) {
                LOG.log(Level.WARNING, "Search error", e);
                msg = "Search error: "+OAString.fmt(e.getMessage(), "45L");
            }
            JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(compFrom),
                msg, "ClassInfo Search",
                JOptionPane.WARNING_MESSAGE
            );
            if (compFocus != null) compFocus.requestFocus();
        }
        else {
            int max = getModel().getClassInfoSearch().getMaxResults();
            if (max > 0 && getHub().getSize() == max) {
                String msg = "Selected the first (max="+max+") Class Infos.";
                JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(compFrom),
                    msg, "ClassInfo Search",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
            if (!bShowResults) {
                onSelect(getHub());
                getDialog().setVisible(false);
            }
            else {
                if (!bMultiSelect && getHub().getSize() == 1) getHub().setPos(0);
                if (compFrom != null) compFrom.requestFocusInWindow();
            }
        }
    }
    
    protected void performSearch() {
        getModel().performSearch();
    }
    
    public boolean wasSelected() {
        return bSelected;
    }
    public ClassInfo getSelected() {
        return classInfoSelected;
    }
    
    private int level;
    public int getLevel() {
        return this.level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
}
