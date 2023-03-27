package ooad.uml.editor.graphics.UML.connectionLine;

import java.awt.Graphics;
import java.awt.Graphics2D;

import ooad.uml.editor.graphics.Canvas;
import ooad.uml.editor.graphics.UML.ConnectionPort;

public class GeneralizationLine extends ConnectionLine {

    public GeneralizationLine(Canvas canvas, ConnectionPort start, ConnectionPort end) {
        super(canvas, start, end);
        //TODO Auto-generated constructor stub
    }

    @Override
    protected void paintHead(Graphics2D g2) {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        this.paintLine(g2);
        this.paintHead(g2);
    }
    
}
