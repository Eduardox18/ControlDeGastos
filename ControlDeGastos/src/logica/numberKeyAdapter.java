package logica;

import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author lalo
 */
public class numberKeyAdapter extends KeyAdapter{
    
    @Override
    public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (!(Character.isDigit(c) || 
                    (c == KeyEvent.VK_BACK_SPACE) || 
                    (c == KeyEvent.VK_DELETE) || 
                    (c == '.'))) {
                Toolkit.getDefaultToolkit().beep();
                e.consume();
            }
        }
}
