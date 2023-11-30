package easygl;

import com.jogamp.opengl.util.Animator;
import easygl.tools.ToolManager;

public class Scene {
    public Animator animator;
    public Renderer renderer;
    public ToolManager toolManager;

    public Scene() {
        animator = new Animator();
        animator.setRunAsFastAsPossible(true);
        renderer = new Renderer(this);
        toolManager = new ToolManager(this);
        animator.start();
    }
}
