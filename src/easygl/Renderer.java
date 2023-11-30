package easygl;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class Renderer implements GLEventListener {
    public Scene scene;
    public int width = 1;
    public int height = 1;

    public Renderer(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        scene.animator.add(drawable);
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {

    }

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        gl.glLoadIdentity();
        scene.toolManager.cameraTool.applyTransform(gl);
        render(gl);
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        final GL2 gl = drawable.getGL().getGL2();
        this.width = width;
        this.height = height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-width/2.0f, width/2.0f, -height/2.0f, height/2.0f, -1, 1);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
    }
    void render(GL2 gl)
    {
        gl.glBegin(GL2.GL_LINE_LOOP);
        gl.glVertex2f(100,100);
        gl.glVertex2f(100,-100);
        gl.glVertex2f(-100,-100);
        gl.glVertex2f(-100,100);
        gl.glEnd();

        var p = scene.toolManager.cameraTool.screenToWorld(10,10);
        gl.glTranslatef(p.x, p.y, 0);
        gl.glBegin(GL2.GL_LINE_LOOP);
        gl.glVertex2f(0,0);
        gl.glVertex2f(100,0);
        gl.glVertex2f(100,-100);
        gl.glVertex2f(0,-100);
        gl.glEnd();
    }
}
