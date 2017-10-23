package fr.curie.cd2sbgnml.model;

import fr.curie.cd2sbgnml.graphics.CdShape;
import fr.curie.cd2sbgnml.graphics.Glyph;
import fr.curie.cd2sbgnml.graphics.SbgnShape;
import fr.curie.cd2sbgnml.xmlcdwrappers.LogicGateWrapper;
import fr.curie.cd2sbgnml.xmlcdwrappers.LogicGateWrapper.LogicGateType;
import fr.curie.cd2sbgnml.xmlcdwrappers.StyleInfo;

import java.awt.geom.Point2D;

public class LogicGate extends ReactionNodeModel{

    private static final float LOGICGATE_SIZE = 20;
    private static final float PORT_DISTANCE_RATIO = 0.5f;

    private LogicGateType type;

    public LogicGate(Glyph glyph, String id, LogicGateType type, StyleInfo styleInfo) {
        super(glyph, id, LOGICGATE_SIZE, PORT_DISTANCE_RATIO, styleInfo);
        this.type = type;
    }

    public LogicGate(Point2D.Float centerCoords, String id, LogicGateType type, StyleInfo styleInfo) {
        super(new Glyph(
                        centerCoords,
                        LOGICGATE_SIZE,
                        LOGICGATE_SIZE,
                        CdShape.CIRCLE,
                        SbgnShape.CIRCLE),
                id, LOGICGATE_SIZE, PORT_DISTANCE_RATIO, styleInfo);
        this.type = type;
    }

    public static String getSbgnClass(LogicGateType logicType) {
        switch(logicType) {
            case OR: return "or";
            case AND: return "and";
            case NOT: return "not";
            //case UNKNOWN: break; // TODO what to do ?
        }
        throw new IllegalArgumentException("Could not infer SBGN class from logic type: "+logicType);
    }

    public LogicGateType getType() {
        return type;
    }
}
