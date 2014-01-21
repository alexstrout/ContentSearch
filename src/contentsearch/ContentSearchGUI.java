package contentsearch;

/**
 * Main application entry point
 * @author Alex
 */
public class ContentSearchGUI extends javax.swing.JFrame {

    /**
     * output stream class for the GUI console, also handles output to file
     */
    private GUIOut out;

    /**
     * Create a new ContentSearchGUI, assumed run from main
     * @param args Command line arguments from main
     */
    public ContentSearchGUI(String args[]) {
        initComponents();
//        System.out.println("Command Line:");
//        for (int i=0; i<args.length; i++)
//            System.out.println(i + " \"" + args[i] + "\"");

        if (args.length > 0) {
            this.dir.setText(args[0]);
            for (int i=1; i<args.length; i++) {
                if (!this.incSub.isSelected() && args[i].equalsIgnoreCase("-s"))
                    this.incSub.setSelected(true);
                if (!this.mCase.isSelected() && args[i].equalsIgnoreCase("-m"))
                    this.mCase.setSelected(true);
                if (!this.outCheck.isSelected() && args[i].equalsIgnoreCase("-o") && i+1<args.length && args[i+1] != null) {
                    this.outCheck.setSelected(true);
                    this.outFile.setEditable(true);
                    this.outFile.setText(args[i+1]);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dirTxt = new javax.swing.JLabel();
        dir = new javax.swing.JTextField();
        filterTxt = new javax.swing.JLabel();
        filter = new javax.swing.JTextField();
        incSub = new javax.swing.JCheckBox();
        targetTxt = new javax.swing.JLabel();
        targetPane = new javax.swing.JScrollPane();
        target = new javax.swing.JTextArea();
        mCase = new javax.swing.JCheckBox();
        outCheck = new javax.swing.JCheckBox();
        outFile = new javax.swing.JTextField();
        goBtn = new javax.swing.JButton();
        outputTxt = new javax.swing.JLabel();
        outputPane = new javax.swing.JScrollPane();
        output = new javax.swing.JTextArea();
        skipResults = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Content Search");

        dirTxt.setText("Search Directory:");

        dir.setToolTipText("Search the following directory. Subfolders will be searched if option checked.");

        filterTxt.setText("File Filter:");

        filter.setText("*");
        filter.setToolTipText("Filter to apply to files (Note: wildcard * supported, multiple filters separated with \",\") - ex. tools.ini,to*.ini");

        incSub.setText("Include Subfolders");
        incSub.setToolTipText("Include subfolders if checked.");

        targetTxt.setText("Search Target:");

        target.setColumns(20);
        target.setRows(1);
        target.setTabSize(4);
        target.setToolTipText("String to search file for.");
        targetPane.setViewportView(target);

        mCase.setText("Match Case");
        mCase.setToolTipText("Match Case for Search Target");

        outCheck.setText("Output to File:");
        outCheck.setToolTipText("Stream output to file if checked.");
        outCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outCheckActionPerformed(evt);
            }
        });

        outFile.setEditable(false);
        outFile.setText("Output.txt");
        outFile.setToolTipText("File to stream output to.");

        goBtn.setText("Go!");
        goBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBtnActionPerformed(evt);
            }
        });

        outputTxt.setFont(new java.awt.Font("Tahoma", 1, 11));
        outputTxt.setText("Output");

        output.setColumns(20);
        output.setEditable(false);
        output.setRows(5);
        outputPane.setViewportView(output);

        skipResults.setText("Skip Result Output");
        skipResults.setToolTipText("Skip result output in console / file (for search time testing).");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(outputPane, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(outputTxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(skipResults))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mCase)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(outCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(outFile, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(goBtn))
                    .addComponent(targetPane, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                    .addComponent(dir, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                    .addComponent(dirTxt)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(filterTxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filter, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(incSub))
                    .addComponent(targetTxt))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dirTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterTxt)
                    .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(incSub))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(targetTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(targetPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mCase)
                    .addComponent(outCheck)
                    .addComponent(outFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(outputTxt)
                    .addComponent(skipResults))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outputPane, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void outCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outCheckActionPerformed
        this.outFile.setEditable(this.outCheck.isSelected());
    }//GEN-LAST:event_outCheckActionPerformed

    private void goBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBtnActionPerformed
        if (this.filter.getText().equals(""))
            this.filter.setText("*");
        if (this.outCheck.isSelected()) {
            this.out = new GUIOut(this.output, new java.io.File(this.outFile.getText()));
        }
        else
            this.out = new GUIOut(this.output, null);
        String tgt = this.target.getText();
        if (!this.mCase.isSelected()) {
            tgt = tgt.toLowerCase();
        }
        //this.output.setText(null);
        if (tgt.equals("")) {
            this.output.append("ERR: Must have a search target!");
            return;
        }

        //Conduct and log time of actual search
        long sStartTime = System.currentTimeMillis();
        FileIterator fileIter = new FileIterator(this.out);
        java.util.List<SearchResult> searchResults = fileIter.IterateDirectory(this.dir.getText(), this.incSub.isSelected(), this.filter.getText(), tgt, this.mCase.isSelected());
        long sEndTime = System.currentTimeMillis();

        //Conduct and log time of console printout
        long pStartTime = System.currentTimeMillis();
        if (!this.skipResults.isSelected()) {
            for (SearchResult x : searchResults) {
                this.out.println(x.toString());
            }
        }
        long pEndTime = System.currentTimeMillis();
        this.out.println("Enumerated " + fileIter.getFileCount() + " files.");
        this.out.println("Found " + fileIter.getNumFinds() + " matches.");
        this.out.println("Search took " + (sEndTime - sStartTime)/1000.0 + " seconds.");
        this.out.println("Printout took " + (pEndTime - pStartTime)/1000.0 + " seconds.");
        this.out.println("----------------");
    }//GEN-LAST:event_goBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(final String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ContentSearchGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContentSearchGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContentSearchGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContentSearchGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ContentSearchGUI(args).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dir;
    private javax.swing.JLabel dirTxt;
    private javax.swing.JTextField filter;
    private javax.swing.JLabel filterTxt;
    private javax.swing.JButton goBtn;
    private javax.swing.JCheckBox incSub;
    private javax.swing.JCheckBox mCase;
    private javax.swing.JCheckBox outCheck;
    private javax.swing.JTextField outFile;
    private javax.swing.JTextArea output;
    private javax.swing.JScrollPane outputPane;
    private javax.swing.JLabel outputTxt;
    private javax.swing.JCheckBox skipResults;
    private javax.swing.JTextArea target;
    private javax.swing.JScrollPane targetPane;
    private javax.swing.JLabel targetTxt;
    // End of variables declaration//GEN-END:variables
}
