package May2021GoogLeetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _0736ParseLispExpression {
	public static void main(String[] args) {
		System.out.println(evaluate("(add 1 2)"));
		System.out.println(evaluate("(mult 3 (add 2 3))"));
		System.out.println(evaluate("(let x 2 (mult x 5))"));
		System.out.println(evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))"));
		System.out.println(evaluate("(let x 3 x 2 x)"));
		System.out.println(evaluate("(let x 1 y 2 x (add x y) (add x y))"));
		System.out.println(evaluate("(let x 2 (add (let x 3 (let x 4 x)) x))"));
		System.out.println(evaluate("(let a1 3 b2 (add a1 1) b2)"));
	}

	public static int evaluate(String expression) {
		
	}
}
