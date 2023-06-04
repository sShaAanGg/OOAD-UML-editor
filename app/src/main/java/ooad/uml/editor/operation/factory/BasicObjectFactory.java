package ooad.uml.editor.operation.factory;

import ooad.uml.editor.graphics.UML.basicObject.BasicObject;

/**
 * Factory for basic objects, only used in strategy(s).
 */
@FunctionalInterface
public interface BasicObjectFactory {
    BasicObject createBasicObject(int coordinateX, int coordinateY);
}
