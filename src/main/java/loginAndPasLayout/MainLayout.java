package loginAndPasLayout;

import java.awt.EventQueue;	

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.JLayeredPane;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import Test.Login2;
import loginAndPasLayout.LoginAndForgotPass;
import loginAndPasLayout.PanelCover;

import java.awt.Dimension;



public class MainLayout extends JFrame {



	    private static final long serialVersionUID = 1L;
	    private final DecimalFormat df = new DecimalFormat("##0.###", DecimalFormatSymbols.getInstance(Locale.US));
	    private JPanel contentPane;
	    private JLayeredPane bg;
	    private MigLayout layout;
	    private PanelCover cover;
	    private final double addSize = 30;
	    private final double coverSize = 40;
	    private final double loginSize = 60;
	    private boolean isLogin = true;
	    private LoginAndForgotPass loginAndForgotPass;

	    public static void main(String[] args) {
	       
	        EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						MainLayout frame = new MainLayout();
		                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		                frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	    } 

	    public MainLayout() {
	    	setSize(new Dimension(865, 573));
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 839, 540);
	        setLocationRelativeTo(null);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);

	        bg = new JLayeredPane();
	        GroupLayout gl_contentPane = new GroupLayout(contentPane);
	        gl_contentPane.setHorizontalGroup(
	            gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
	                .addComponent(bg, GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
	        );
	        gl_contentPane.setVerticalGroup(
	            gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
	                .addComponent(bg, GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
	        );
	        contentPane.setLayout(gl_contentPane);

	        initComponents(); // Call initComponents after bg and panel have been initialized
	        init();
	    }

	    private void initComponents() {
	        // Components to be initialized if needed
	    }

	    private void init() {
	    	 layout = new MigLayout("fill, insets 0");
	         cover = new PanelCover();
	         cover.setPreferredSize(new Dimension(250, 170));
	         TimingTarget target = new TimingTargetAdapter() {
	             @Override
	             public void timingEvent(float fraction) {
	                 double fractionCover;
	                 double fractionLogin;
	                 double size = coverSize;
	                 if (fraction <= 0.5f) {
	                     size += fraction * addSize;
	                 } else {
	                     size += addSize - fraction * addSize;
	                 }
	                 if (isLogin) {
	                     fractionCover = 1f - fraction;
	                     fractionLogin = fraction;
	                     if (fraction >= 0.5f) {
	                         cover.registerRight(fractionCover * 100);
	                     } else {
	                         cover.loginRight(fractionLogin * 100);
	                     }
	                 } else {
	                     fractionCover = fraction;
	                     fractionLogin = 1f - fraction;
	                     if (fraction <= 0.5f) {
	                         cover.registerLeft(fraction * 100);
	                     } else {
	                         cover.loginLeft((1f - fraction) * 100);
	                     }
	                 }
	                 if (fraction >= 0.5f) {
	                	 loginAndForgotPass.showForgotPass(isLogin);
	                 }
	                 fractionCover = Double.valueOf(df.format(fractionCover));
	                 fractionLogin = Double.valueOf(df.format(fractionLogin));
	                 layout.setComponentConstraints(cover, "width " + size + "%, pos " + fractionCover + "al 0 n 100%");
	                 layout.setComponentConstraints(loginAndForgotPass, "width " + loginSize + "%, pos " + fractionLogin + "al 0 n 100%");
	                 bg.revalidate();
	             }

	             @Override
	             public void end() {
	                 isLogin = !isLogin;
	             }
	         };
	         Animator animator = new Animator(800, target);
	         animator.setAcceleration(0.5f);
	         animator.setDeceleration(0.5f);
	         animator.setResolution(0);  //  for smooth animation
	         bg.setLayout(layout);
	         loginAndForgotPass = new LoginAndForgotPass();
	         bg.add(loginAndForgotPass, "pos 0al 0 null 100%,cell 0 0,width 60%"); //  1al as 100%
	         loginAndForgotPass.showForgotPass(!isLogin);
	         bg.add(cover, "pos 1al 0 null 100%,cell 0 0,width 40%");
	         cover.login(isLogin);
	         cover.addEvent(new ActionListener() {
	             @Override
	             public void actionPerformed(ActionEvent ae) {
	                 if (!animator.isRunning()) {
	                     animator.start();
	                 }
	             }
	         });
	    }

	
}

