import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Win extends JFrame implements Runnable{


  static final int WORLD_WIDTH = 500;
  static final int WORLD_HEIGHT = 500;
  Thread renderThread;
  static volatile boolean running = true;
  World world;

  public Win(){
    setSize(WORLD_WIDTH, WORLD_HEIGHT);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    world = new World();
    addWindowListener(new WindowAdapter(){
      @Override
      public void windowClosing(WindowEvent event){
        dispose();
        System.exit(0);
      }
    });
    add(world);
    setVisible(true);
    Thread closeableThread = new Thread(this);
    closeableThread.start();
  }

  @Override
  public void run(){
    while(running);
    dispose();
  }

}
