package easygl;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLJPanel;

public class EasyGLPanel extends GLJPanel {
    Scene scene;
    public EasyGLPanel(){
        super(new GLCapabilities(GLProfile.get(GLProfile.GL2)));
        scene = new Scene();
        addGLEventListener(scene.renderer);
        addMouseListener(scene.toolManager);
        addMouseMotionListener(scene.toolManager);
        addMouseWheelListener(scene.toolManager);
    }
}
