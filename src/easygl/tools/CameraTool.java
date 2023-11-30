package easygl.tools;

import com.jogamp.opengl.GL2;
import easygl.util.Vector2;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;



public class CameraTool extends Tool{

    public static class Anchor{
        private float left = -1;
        private float right = 1;
        private float top = 1;
        private float bottom = -1;

        private Preset preset;

        public enum Preset {
            TOP_LEFT_Y_UP, TOP_LEFT_Y_DOWN, CENTER_Y_UP, CENTER_Y_DOWN,CUSTOM
        }
        public void setPreset(Preset preset){
            this.preset = preset;
        }
        public void setCustom(float left, float right, float bottom, float top){
            preset = Preset.CUSTOM;
            this.left = left;
            this.right = right;
            this.bottom = bottom;
            this.top = top;
        }

        public Preset getPreset(){
            return preset;
        }
    }
    public Vector2 position;
    public float zoom = 1;
    public boolean zoomEnable = true;
    public float zoomSensitivity = 1.1F;
    public float zoomMax = 10000;
    public float zoomMin = 0.0001f;
    public boolean panEnable = true;

    private boolean panning = false;
    private Vector2 panOffset = new Vector2();
    public CameraTool(ToolManager toolManager)
    {
        super(toolManager);
        enable = true;
        position = new Vector2(0,0);
    }
    public void applyTransform(GL2 gl){
        gl.glTranslatef(position.x, position.y, 0);
        gl.glScalef(zoom, zoom, 1);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (panEnable){
            panning = true;
            panOffset = new Vector2(e.getX(), -e.getY()).sub(position);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (panEnable && panning){
            position = new Vector2(e.getX(), -e.getY()).sub(panOffset);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        panning = false;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        var width = toolManager.scene.renderer.width/2;
        var height = toolManager.scene.renderer.height/2;
        Vector2 pointer = new Vector2(e.getX()-width, -(e.getY()-height))
                .sub(position)
                .div(zoom);
        zoom = e.getWheelRotation()<0 ? zoom*zoomSensitivity : zoom/zoomSensitivity;
        if (zoom<zoomMin){
            zoom = zoomMin;
        }
        else if (zoom>zoomMax){
            zoom = zoomMax;
        }
        position = new Vector2(e.getX()-width, -(e.getY()-height))
                .sub(pointer.mult(zoom));
    }

    public Vector2 screenToWorld(float x, float y){
        var width = toolManager.scene.renderer.width/2;
        var height = toolManager.scene.renderer.height/2;
        return new Vector2(x-width,-(y-height))
                .sub(position)
                .div(zoom);
    }

}
