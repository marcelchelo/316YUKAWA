/**

This class is a top-down, recursive-descent parser for the following
syntactic categories:

<statement> --> <assignment> | <increment> | <decrement> |
                <block> | <cond> | <while> | <do>
<assignment> --> <id> "=" <expr> ";"
<increment> --> <id> "++" ";" 
<decrement> --> <id> "--" ";" 
<block> --> "{" <S list> "}"
<cond> --> "if" "(" <expr> ")" <statement> [ "else" <statement> ]
<while> --> "while" "(" <expr> ")" <statement>
<do> --> "do" <statement> "while" "(" <expr> ")"
<slist> --> <statement> | <statement> <slist>
<expr> --> <boolTerm> | <boolTerm> || <expr>
<boolTerm> --> <boolPrimary> | <boolPrimary> && <boolTerm>
<boolPrimary> --> <E> [ <rel op> <E> ]
<rel op> --> "<" | "<=" | ">" | ">=" | "==" | "!="
<E> --> <term> | <term> + <E> | <term> - <E>
<term> --> <primary> | <primary> * <term> | <primary> / <term>
<primary> --> <id> | <int> | <float> | <floatE> | <boolLiteral>
                   "(" <expr> ")" | - <primary> | ! <primary> 
<boolLiteral> --> "False" | "True" 

The definitions of the tokens are given in the lexical analyzer 
class file "LexAnalyzer.java". 

The following variables and functions of the "LexAnalyzer" class are used:

static String t // holds an extracted token
static State state // the current state of the finite automaton
static int getToken() // extracts the next token
static void display(String s)
static void displayln(String s)
static void setIO(String inFile, String outFile)
static void closeIO()

The program will display the parse tree in linearly indented form.
Each syntactic category name labeling a node is displayed on a separate line, 
prefixed with the integer i representing the node's depth and indented by i blanks. 
The string variable "indent" will keep track of the correct number of blanks for indentation and
will be passed to parse functions corresponding to syntactic categories.

**/


import java.io.*;

public abstract class Parser extends LexAnalyzer
{
	static boolean errorFound = false;

	public static Statement statement()

	// <statement> --> <assignment> | <increment> | <decrement> |
	//                 <block> | <cond> | <while> | <do>
	// <assignment> --> <id> "=" <expr> ";"
	// <increment> --> <id> "++" ";" 
	// <decrement> --> <id> "--" ";" 
	// <block> --> "{" <slist> "}"
	// <cond> --> "if" "(" <expr> ")" <statement> [ "else" <statement> ]
	// <while> --> "while" "(" <expr> ")" <statement>
	// <do> --> "do" <statement> "while" "(" <expr> ")"
	
	{
		switch ( state )
		{
		case Id:
		{
			String id = t;
			getToken();
			
			if ( state == State.Assign )
			{
				getToken();								
				Expr expr = expr();
				if ( state == State.Semicolon )
				{
					getToken();
					return new Assignment(id, expr);
				}
				else
					errorMsg(4);
			}
			else if ( state == State.Incr )
			{
				getToken();
				if ( state == State.Semicolon )
				{
					getToken();
					return new Increment(id);
				}
				else 
					errorMsg(4);
			}
			else if ( state == State.Decr )
			{
				getToken();
				if ( state == State.Semicolon )
				{
					getToken();
					return new Decrement(id);
				}
				else
					errorMsg(4);
			}
			else
				errorMsg(5);
			return null;
		}
		case LBrace:
		{
			getToken();
			SList slist = slist();
			if ( state == State.RBrace )
			{
				getToken();
				return new Block(slist);
			}
			else
				errorMsg(3);
			return null;
		}
		case If:
		{
			getToken();
			if ( state == State.LParen )
			{
				getToken();
				Expr expr = expr();
				if ( state == State.RParen )
				{
					getToken();
					Statement statement1 = statement();
					if ( state == State.Else )
					{
						getToken();
						Statement statement2 = statement();
						return new If2(expr, statement1, statement2);
					}
					else
						return new If1(expr, statement1);
				}
				else
					errorMsg(7);
			}
			else
				errorMsg(8);
			return null;
		}
		case While:
		{
			getToken();
			if ( state == State.LParen )
			{
				getToken();
				Expr expr = expr();
				if ( state == State.RParen )
				{
					getToken();
					Statement statement = statement();
					return new While(expr, statement);
				}
				else
					errorMsg(7);
			}
			else
				errorMsg(8);
			return null;
		}
		case Do:
		{
			getToken();
			Statement statement = statement();
			if ( state == State.While )
			{
				getToken();
				if ( state == State.LParen )
				{
					getToken();
					Expr expr = expr();
					if ( state == State.RParen )
					{
						getToken();
						return new Do(statement, expr);
					}
					else
						errorMsg(7);
				}
				else
					errorMsg(8);
			}
			else
				errorMsg(9);
			return null;
		}	
		default:

			errorMsg(6);
			return null;
		}
	}

	public static SList slist()

	// <slist> --> <statement> | <statement> <slist>

	{
		Statement statement = statement();

		if ( state == State.Id || state == State.LBrace ||
		     state == State.If || state == State.While || state == State.Do )
		{
			SList slist = slist();
			return new MultipleStatement(statement, slist);
		}
		else
			return new SingleStatement(statement);
	}

	public static Expr expr()

	// <expr> --> <boolTerm> | <boolTerm> || <expr>

	{
		BoolTerm boolterm = boolTerm();
		if ( state == State.Or )
		{			
			getToken();
			Expr expr = expr();
			return new OrExpr(boolterm, expr);
		}
		else
			return new SingleBoolTerm(boolterm);
	}

	public static BoolTerm boolTerm()

	// <boolTerm> --> <boolPrimary> | <boolPrimary> && <boolTerm>

	{
		BoolPrimary boolprimary = boolPrimary();
		if ( state == State.And )
		{
			getToken();
			BoolTerm boolterm = boolTerm();
			return new AndBoolTerm(boolprimary, boolterm); 
		}
		else
			return new SingleBoolPrimary(boolprimary);
	}

	public static BoolPrimary boolPrimary()

	// <boolPrimary> --> <E> [ <relop> <E> ]

	{
		E e1 = E();
		if ( state.compareTo(State.Lt)  >= 0 &&
                     state.compareTo(State.Neq) <= 0 )

		// state = Lt, Le, Gt, Ge, Eq, or Neq

		{			
			State relop = state;
			getToken();
			E e2 = E();
			return new RelPrimary(e1, e2, relop);
		}
		else
			return new SingleE(e1);
	}

	public static E E()

	// <E> --> <term> | <term> + <E> | <term> - <E>

	{
		Term term = term();
		if ( state == State.Add )
		{			
			getToken();
			E e = E();
			return new AddE(term, e);
		}
		else if ( state == State.Sub )
		{
			getToken();
			E e = E();
			return new SubE(term, e);
		}
		else
			return new SingleTerm(term);
	}

	public static Term term()

	// <term> --> <primary> | <primary> * <term> | <primary> / <term>

	{
		Primary primary = primary();
		if ( state == State.Mul )
		{			
			getToken();
			Term term = term();
			return new MulTerm(primary, term);
		}
		else if ( state == State.Div )
		{
			getToken();
			Term term = term();
			return new DivTerm(primary, term);
		}
		else
			return new SinglePrimary(primary);
	}

	public static Primary primary()

	// <primary> --> <id> | <int> | <float> | <floatE> | <boolLiteral> | "(" <expr> ")" | - <primary> | ! <primary>

	{
		switch ( state )
		{
			case Id:
				
				Id id = new Id(t); 
				getToken();
				return id;

			case Int:

				Int intElem = new Int(Integer.parseInt(t));
				getToken();
				return intElem;

			case Float: case FloatE:

				Floatp floatElem = new Floatp(Float.parseFloat(t));
				getToken();
				return floatElem;

			case False:

				getToken();
				return new Bool(false);

			case True:

				getToken();
				return new Bool(true);

			case LParen:
				
				getToken();
				Expr expr = expr();
				if ( state == State.RParen )
				{
					getToken();
					Parenthesized paren = new Parenthesized(expr);
					return paren;
				}
				else
				{
					errorMsg(1);
					return null;
				}

			case Sub:
				
				getToken();
				Primary prim = primary();
				NegPrimary negprim = new NegPrimary(prim);
				return negprim;

			case Inv:
				
				getToken();
				Primary prim_ = primary();
				InvPrimary invprim = new InvPrimary(prim_);
				return invprim;

			default:

				errorMsg(2);
				return null;
		}
	}

	public static void errorMsg(int i)
	{
		errorFound = true;
		
		display(t + ": unexpected symbol where");

		switch( i )
		{
		case 1:	displayln(" arith op or ) expected"); return;
		case 2: displayln(" id, int, float, (, -, or ! expected"); return;
		case 3:	displayln(" } expected"); return;
		case 4:	displayln(" ; expected"); return;
		case 5:	displayln(" =, ++, or -- expected"); return;
		case 6:	displayln(" id, {, if, while, or do expected"); return;
		case 7:	displayln(" ) expected"); return;
		case 8: displayln(" ( expected"); return;
		case 9: displayln(" while expected"); return;
		}
	}

	public static void main(String argv[])
	{
		setLex( argv[0], argv[1] );

		getToken();
		Statement statement = statement();
		if ( ! t.isEmpty() )
			displayln(t + "  -- unexpected symbol");
		else if ( ! errorFound )
			displayln(statement.toString(""));

		closeIO();
	}
}
