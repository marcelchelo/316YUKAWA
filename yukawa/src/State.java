public enum State 
{ 
// final states    ordinal number  token accepted 

	Add,             // 0          +
	Sub,             // 1          -
	Mul,             // 2          *
	Div,	         // 3          /
	Incr,            // 4          ++
	Decr,            // 5          --
	Or,              // 6          ||
	And,             // 7          &&
	Inv,             // 8          !
	Lt,              // 9          <
	Le,              // 10         <=
	Gt,              // 11         >
	Ge,              // 12         >=
	Eq,              // 13         ==
	Neq,             // 14         !=
	Assign,          // 15         = 
	Id,              // 16         identifiers
	Int,             // 17         integers
	Float,           // 18         floats without exponentiation part
	FloatE,          // 19         floats with exponentiation part
	LParen,          // 20         (
	RParen,          // 21         )
	LBrace,          // 22         {
	RBrace,          // 23         }
	Semicolon,       // 24         ;

// non-final states                string recognized    

	Start,           // 25      the empty string
	Bar,             // 26         |
	Ampersand,       // 27         &
	Period,          // 28        "."
	E,               // 29      float parts ending with E or e
	EPlusMinus,      // 30      float parts ending with + or - in exponentiation part

	UNDEF,

// keyword states

	If,
	Else,
	While,
	Do,
	False,
	True
}

// By enumerating the final states first and then the non-final states,
// test for a final state can be done by testing if the state's ordinal number
// is less than or equal to that of Semicolon.
