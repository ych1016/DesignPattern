package com.wangzai.study.behavior.interpreter;

import lombok.AllArgsConstructor;

import java.util.Stack;

/**
 * @author 杨灿杭
 * @Description
 * @create 2025-04-02 20:19
 */
public class InterpreterDemo {
    public static void main(String[] args) {
        String statement = "3 * 2 * 4 / 6 % 5";

        Calculator calculator = new Calculator();

        calculator.build(statement);

        int result = calculator.compute();

        System.out.println(statement + " = " + result);
    }
}

interface Node {
    public int interpreter();
}

@AllArgsConstructor
class ValueNode implements Node {
    private int value;

    @Override
    public int interpreter() {
        return this.value;
    }
}

abstract class SymbolNode implements Node {
    protected Node left;
    protected Node right;

    public SymbolNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }
}

class AddNode extends SymbolNode {
    public AddNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public int interpreter() {
        return left.interpreter() + right.interpreter();
    }
}


class SubNode extends SymbolNode {
    public SubNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public int interpreter() {
        return left.interpreter() - right.interpreter();
    }
}

class MulNode extends SymbolNode {

    public MulNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public int interpreter() {
        return left.interpreter() * right.interpreter();
    }
}

class DivNode extends SymbolNode {

    public DivNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public int interpreter() {
        return left.interpreter() / right.interpreter();
    }
}

class ModNode extends SymbolNode {
    public ModNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public int interpreter() {
        return left.interpreter() % right.interpreter();
    }
}

class Calculator {
    private String statement;
    private Node node;

    public void build(String statement) {
        Node left = null, right = null;
        Stack stack = new Stack();

        String[] statementArr = statement.split(" ");

        for (int i = 0; i < statementArr.length; i++) {
            if (statementArr[i].equalsIgnoreCase("*")) {
                left = (Node) stack.pop();
                int val = Integer.parseInt(statementArr[++i]);
                right = new ValueNode(val);
                stack.push(new MulNode(left, right));
            } else if (statementArr[i].equalsIgnoreCase("/")) {
                left = (Node) stack.pop();
                int val = Integer.parseInt(statementArr[++i]);
                right = new ValueNode(val);
                stack.push(new DivNode(left, right));
            } else if (statementArr[i].equalsIgnoreCase("%")) {
                left = (Node) stack.pop();
                int val = Integer.parseInt(statementArr[++i]);
                right = new ValueNode(val);
                stack.push(new ModNode(left, right));
            } else {
                stack.push(new ValueNode(Integer.parseInt(statementArr[i])));
            }
        }
        this.node = (Node) stack.pop();
    }

    public int compute() {
        return node.interpreter();
    }

}


