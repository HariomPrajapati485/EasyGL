package easygl.tools;

import easygl.Scene;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class ToolManager implements MouseListener, MouseMotionListener, MouseWheelListener {

    public Scene scene;
    public List<Tool> tools ;
    public CameraTool cameraTool;

    public ToolManager(Scene scene) {
        this.scene = scene;
        tools = new ArrayList<Tool>();
        cameraTool = new CameraTool(this);
        tools.add(cameraTool);

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        for (Tool tool : tools) {
            if (tool.enable){
                tool.mouseClicked(mouseEvent);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        for (Tool tool : tools) {
            if (tool.enable){
                tool.mousePressed(mouseEvent);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        for (Tool tool : tools) {
            if (tool.enable){
                tool.mouseReleased(mouseEvent);
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        for (Tool tool : tools) {
            if (tool.enable){
                tool.mouseEntered(mouseEvent);
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        for (Tool tool : tools) {
            if (tool.enable){
                tool.mouseExited(mouseEvent);
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        for (Tool tool : tools) {
            if (tool.enable){
                tool.mouseDragged(mouseEvent);
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        for (Tool tool : tools) {
            if (tool.enable){
                tool.mouseMoved(mouseEvent);
            }
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent) {
        for (Tool tool : tools) {
            if (tool.enable){
                tool.mouseWheelMoved(mouseWheelEvent);
            }
        }
    }
}
