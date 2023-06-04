package ooad.uml.editor.operation.factory;

import ooad.uml.editor.graphics.Canvas;
import ooad.uml.editor.graphics.UML.ConnectionPort;
import ooad.uml.editor.graphics.UML.connectionLine.ConnectionLine;

/**
 * Factory for connection lines, only used in strategy(s).
 */
@FunctionalInterface
public interface ConnectionLineFactory {
    ConnectionLine createConnectionLine(Canvas canvas, ConnectionPort start, ConnectionPort end);
}
