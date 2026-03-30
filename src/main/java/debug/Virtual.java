/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package debug;

import coms.Command;
import coms.CommandTree;
import contractor.entities.names.Full;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * <p></p>
 * @author rash4
 */
public class Virtual extends coms.Commanding{
    private final static Virtual VC = new Virtual();
    public static Virtual vc(){return VC;}
    public Virtual(){
        super(new Ver());
    }
    public void initialize(){
        this.getConsole().initialize();
        this.addCommand(new CommandTree()
                .setDirectCom(new Command(super::getHelp))
                .setCom("list", new Command(super::fullHelpList))
            , "help")
            .addCommand(new CommandTree()
                .setDirectCom(new Command(grr->{System.exit(0); return true;}))
                .setCom("console", new Command(grr->{// keep this or the tree won't add to root.
                    /*this.getFrame().dispose();*/ 
                    return true;
                }))
            , "exit")
            .addCommand(new CommandTree()
                .setDirectCom(new Command(arg->{
                    this.getConsole().clear(); 
                    return true;
                }))
                .setCom("names", new Command(arg->{
                    Full.names().clear();
                    this.getConsole().appendl(">> local names has been cleared.");
                    return true;
                }))
            , "clear")
            .addCommand(new CommandTree()
                .setCom("name", new Command(arg->{
                    if(arg == null || arg.isBlank())return false;
                    final var parts = arg.trim().split("\\s+");
                    final int len = parts.length;
                    if(len < 2){
                        this.getConsole().append(">> not enough inputs, need e.g. <first name> <last name ....etc>\n");
                        return false;
                    }
                    try{
                        final var last = new StringBuilder(parts[1]);
                        for(int i = 2; i < len; i++){// len==2 auto skip this block.
                            last.append(" ").append(parts[i]);
                        }
                        final var name = Full.make(parts[0], last.toString());
                        this.getConsole().appends(">> Name \"")
                                .appends(name.fullName())
                                .append("\"has been created successfully.");
                    }catch(RuntimeException e){
                        this.getConsole().append(e.getMessage());
                        return false;
                    }
                    return true;
                }))
            , "create")
            .addCommand(new CommandTree()
                .setCom("names", new Command(arg->{
                    final ArrayList<Full> ns = Full.names();
                    final int len = ns.size();
                    if(len < 1) {
                        this.getConsole().appendl(">> names list is empty.");
                        return false;
                    }
                    this.getConsole().append(
                            ">> current local names [" + len + "] :\n");
                    final int frm = ("" + len).length();
                    for(int i = 0; i < len; i++){
                        this.getConsole().appends(("[%0" + frm + "d]").formatted(i))
                                .appendl(ns.get(i).fullName());
                    }
                    return true;
                }))
            , "list")
        ;
        
        this.getConsole().setCommands(this);
    }
//    public JFrame getFrame(){return this.getConsole().frame;}
//    public JPanel getPanel(){return this.getConsole().panel;}
    private static class Ver extends coms.Console{
        private Ver(){super();}
        @Override public void initialize(){
            super.initialize(false);
            this.append("- Ready set.. Go.\n");
            
            this.frame = new JFrame("Debug.");
            this.panel = new JPanel(null);
            this.panel.setPreferredSize(new Dimension(740, 680));
            this.panel.addComponentListener(new ComponentAdapter(){
                @Override public void componentResized(ComponentEvent e) {
                    Ver.this.resizing(Ver.this.panel.getSize());
                }
            });
            this.setup(this.panel);
            this.setStats(false);
            
            this.frame.setContentPane(this.panel);
            this.frame.pack();
            this.frame.setLocationRelativeTo(null);
            this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.frame.setResizable(true);
            this.setStats(true);
            this.frame.addWindowFocusListener(new WindowFocusListener(){
                @Override public void windowGainedFocus(WindowEvent e) {
                    Ver.this.panel.requestFocusInWindow();
                }
                @Override public void windowLostFocus(WindowEvent e) {}
            });
            this.frame.setVisible(true);
        }
    public void dispose(){
        this.frame.dispose();
        this.frame = null;
        this.panel = null;
    }
        private JPanel panel;
        private JFrame frame;
    }
}