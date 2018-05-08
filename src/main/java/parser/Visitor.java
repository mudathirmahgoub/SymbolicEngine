package parser;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import parser.antlr.CBaseVisitor;
import parser.antlr.CParser;
import parser.antlr.CVisitor;
import parser.syntaxtree.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Visitor extends CBaseVisitor<CNode>
{
}
