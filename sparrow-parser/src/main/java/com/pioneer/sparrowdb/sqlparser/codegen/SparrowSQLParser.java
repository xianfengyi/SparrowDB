package com.pioneer.sparrowdb.sqlparser.codegen;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SparrowSQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, ADD=6, ALL=7, ALTER=8, AND=9, 
		AS=10, ASC=11, BERNOULLI=12, BETWEEN=13, BY=14, CASE=15, COLUMN=16, COMMENT=17, 
		CREATE=18, CROSS=19, DELETE=20, DESC=21, DISTINCT=22, DROP=23, ELSE=24, 
		END=25, EXISTS=26, FALSE=27, FROM=28, FULL=29, GROUP=30, JOIN=31, IF=32, 
		IN=33, INNER=34, INSERT=35, INTO=36, IS=37, LEFT=38, LIMIT=39, LIKE=40, 
		NATURAL=41, NOT=42, NULL=43, OFFSET=44, ON=45, OR=46, ORDER=47, OUTER=48, 
		RENAME=49, RIGHT=50, ROW=51, ROWS=52, SELECT=53, SYSTEM=54, TABLE=55, 
		TABLESAMPLE=56, THEN=57, TO=58, TRUE=59, VALUES=60, WHEN=61, WHERE=62, 
		EQ=63, NEQ=64, LT=65, LTE=66, GT=67, GTE=68, PLUS=69, MINUS=70, ASTERISK=71, 
		SLASH=72, PERCENT=73, CONCAT=74, STRING=75, UNICODE_STRING=76, BINARY_LITERAL=77, 
		INTEGER_VALUE=78, DECIMAL_VALUE=79, DOUBLE_VALUE=80, IDENTIFIER=81, DIGIT_IDENTIFIER=82, 
		QUOTED_IDENTIFIER=83, BACKQUOTED_IDENTIFIER=84, TIME_WITH_TIME_ZONE=85, 
		TIMESTAMP_WITH_TIME_ZONE=86, DOUBLE_PRECISION=87, SIMPLE_COMMENT=88, BRACKETED_COMMENT=89, 
		WS=90, UNRECOGNIZED=91, DELIMITER=92;
	public static final int
		RULE_singleStatement = 0, RULE_statement = 1, RULE_tableElement = 2, RULE_columnDefinition = 3, 
		RULE_likeClause = 4, RULE_query = 5, RULE_queryNoWith = 6, RULE_queryTerm = 7, 
		RULE_queryPrimary = 8, RULE_sortItem = 9, RULE_querySpecification = 10, 
		RULE_groupBy = 11, RULE_groupingElement = 12, RULE_groupingSet = 13, RULE_setQuantifier = 14, 
		RULE_selectItem = 15, RULE_relation = 16, RULE_joinType = 17, RULE_joinCriteria = 18, 
		RULE_sampledRelation = 19, RULE_sampleType = 20, RULE_aliasedRelation = 21, 
		RULE_columnAliases = 22, RULE_relationPrimary = 23, RULE_expression = 24, 
		RULE_booleanExpression = 25, RULE_predicated = 26, RULE_predicate = 27, 
		RULE_valueExpression = 28, RULE_primaryExpression = 29, RULE_string = 30, 
		RULE_type = 31, RULE_typeParameter = 32, RULE_comparisonOperator = 33, 
		RULE_booleanValue = 34, RULE_qualifiedName = 35, RULE_identifier = 36, 
		RULE_number = 37;
	private static String[] makeRuleNames() {
		return new String[] {
			"singleStatement", "statement", "tableElement", "columnDefinition", "likeClause", 
			"query", "queryNoWith", "queryTerm", "queryPrimary", "sortItem", "querySpecification", 
			"groupBy", "groupingElement", "groupingSet", "setQuantifier", "selectItem", 
			"relation", "joinType", "joinCriteria", "sampledRelation", "sampleType", 
			"aliasedRelation", "columnAliases", "relationPrimary", "expression", 
			"booleanExpression", "predicated", "predicate", "valueExpression", "primaryExpression", 
			"string", "type", "typeParameter", "comparisonOperator", "booleanValue", 
			"qualifiedName", "identifier", "number"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "','", "')'", "'.'", "'?'", "'ADD'", "'ALL'", "'ALTER'", 
			"'AND'", "'AS'", "'ASC'", "'BERNOULLI'", "'BETWEEN'", "'BY'", "'CASE'", 
			"'COLUMN'", "'COMMENT'", "'CREATE'", "'CROSS'", "'DELETE'", "'DESC'", 
			"'DISTINCT'", "'DROP'", "'ELSE'", "'END'", "'EXISTS'", "'FALSE'", "'FROM'", 
			"'FULL'", "'GROUP'", "'JOIN'", "'IF'", "'IN'", "'INNER'", "'INSERT'", 
			"'INTO'", "'IS'", "'LEFT'", "'LIMIT'", "'LIKE'", "'NATURAL'", "'NOT'", 
			"'NULL'", "'OFFSET'", "'ON'", "'OR'", "'ORDER'", "'OUTER'", "'RENAME'", 
			"'RIGHT'", "'ROW'", "'ROWS'", "'SELECT'", "'SYSTEM'", "'TABLE'", "'TABLESAMPLE'", 
			"'THEN'", "'TO'", "'TRUE'", "'VALUES'", "'WHEN'", "'WHERE'", "'='", null, 
			"'<'", "'<='", "'>'", "'>='", "'+'", "'-'", "'*'", "'/'", "'%'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "ADD", "ALL", "ALTER", "AND", "AS", 
			"ASC", "BERNOULLI", "BETWEEN", "BY", "CASE", "COLUMN", "COMMENT", "CREATE", 
			"CROSS", "DELETE", "DESC", "DISTINCT", "DROP", "ELSE", "END", "EXISTS", 
			"FALSE", "FROM", "FULL", "GROUP", "JOIN", "IF", "IN", "INNER", "INSERT", 
			"INTO", "IS", "LEFT", "LIMIT", "LIKE", "NATURAL", "NOT", "NULL", "OFFSET", 
			"ON", "OR", "ORDER", "OUTER", "RENAME", "RIGHT", "ROW", "ROWS", "SELECT", 
			"SYSTEM", "TABLE", "TABLESAMPLE", "THEN", "TO", "TRUE", "VALUES", "WHEN", 
			"WHERE", "EQ", "NEQ", "LT", "LTE", "GT", "GTE", "PLUS", "MINUS", "ASTERISK", 
			"SLASH", "PERCENT", "CONCAT", "STRING", "UNICODE_STRING", "BINARY_LITERAL", 
			"INTEGER_VALUE", "DECIMAL_VALUE", "DOUBLE_VALUE", "IDENTIFIER", "DIGIT_IDENTIFIER", 
			"QUOTED_IDENTIFIER", "BACKQUOTED_IDENTIFIER", "TIME_WITH_TIME_ZONE", 
			"TIMESTAMP_WITH_TIME_ZONE", "DOUBLE_PRECISION", "SIMPLE_COMMENT", "BRACKETED_COMMENT", 
			"WS", "UNRECOGNIZED", "DELIMITER"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SparrowSQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SparrowSQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SingleStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SparrowSQLParser.EOF, 0); }
		public SingleStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterSingleStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitSingleStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitSingleStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleStatementContext singleStatement() throws RecognitionException {
		SingleStatementContext _localctx = new SingleStatementContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_singleStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			statement();
			setState(77);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AddColumnContext extends StatementContext {
		public QualifiedNameContext tableName;
		public ColumnDefinitionContext column;
		public TerminalNode ALTER() { return getToken(SparrowSQLParser.ALTER, 0); }
		public TerminalNode TABLE() { return getToken(SparrowSQLParser.TABLE, 0); }
		public TerminalNode ADD() { return getToken(SparrowSQLParser.ADD, 0); }
		public TerminalNode COLUMN() { return getToken(SparrowSQLParser.COLUMN, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public ColumnDefinitionContext columnDefinition() {
			return getRuleContext(ColumnDefinitionContext.class,0);
		}
		public List<TerminalNode> IF() { return getTokens(SparrowSQLParser.IF); }
		public TerminalNode IF(int i) {
			return getToken(SparrowSQLParser.IF, i);
		}
		public List<TerminalNode> EXISTS() { return getTokens(SparrowSQLParser.EXISTS); }
		public TerminalNode EXISTS(int i) {
			return getToken(SparrowSQLParser.EXISTS, i);
		}
		public TerminalNode NOT() { return getToken(SparrowSQLParser.NOT, 0); }
		public AddColumnContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterAddColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitAddColumn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitAddColumn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreateTableContext extends StatementContext {
		public TerminalNode CREATE() { return getToken(SparrowSQLParser.CREATE, 0); }
		public TerminalNode TABLE() { return getToken(SparrowSQLParser.TABLE, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public List<TableElementContext> tableElement() {
			return getRuleContexts(TableElementContext.class);
		}
		public TableElementContext tableElement(int i) {
			return getRuleContext(TableElementContext.class,i);
		}
		public TerminalNode IF() { return getToken(SparrowSQLParser.IF, 0); }
		public TerminalNode NOT() { return getToken(SparrowSQLParser.NOT, 0); }
		public TerminalNode EXISTS() { return getToken(SparrowSQLParser.EXISTS, 0); }
		public TerminalNode COMMENT() { return getToken(SparrowSQLParser.COMMENT, 0); }
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public CreateTableContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterCreateTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitCreateTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitCreateTable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementDefaultContext extends StatementContext {
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public StatementDefaultContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterStatementDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitStatementDefault(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitStatementDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InsertIntoContext extends StatementContext {
		public TerminalNode INSERT() { return getToken(SparrowSQLParser.INSERT, 0); }
		public TerminalNode INTO() { return getToken(SparrowSQLParser.INTO, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public ColumnAliasesContext columnAliases() {
			return getRuleContext(ColumnAliasesContext.class,0);
		}
		public InsertIntoContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterInsertInto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitInsertInto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitInsertInto(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RenameTableContext extends StatementContext {
		public QualifiedNameContext from;
		public QualifiedNameContext to;
		public TerminalNode ALTER() { return getToken(SparrowSQLParser.ALTER, 0); }
		public TerminalNode TABLE() { return getToken(SparrowSQLParser.TABLE, 0); }
		public TerminalNode RENAME() { return getToken(SparrowSQLParser.RENAME, 0); }
		public TerminalNode TO() { return getToken(SparrowSQLParser.TO, 0); }
		public List<QualifiedNameContext> qualifiedName() {
			return getRuleContexts(QualifiedNameContext.class);
		}
		public QualifiedNameContext qualifiedName(int i) {
			return getRuleContext(QualifiedNameContext.class,i);
		}
		public TerminalNode IF() { return getToken(SparrowSQLParser.IF, 0); }
		public TerminalNode EXISTS() { return getToken(SparrowSQLParser.EXISTS, 0); }
		public RenameTableContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterRenameTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitRenameTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitRenameTable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RenameColumnContext extends StatementContext {
		public QualifiedNameContext tableName;
		public IdentifierContext from;
		public IdentifierContext to;
		public TerminalNode ALTER() { return getToken(SparrowSQLParser.ALTER, 0); }
		public TerminalNode TABLE() { return getToken(SparrowSQLParser.TABLE, 0); }
		public TerminalNode RENAME() { return getToken(SparrowSQLParser.RENAME, 0); }
		public TerminalNode COLUMN() { return getToken(SparrowSQLParser.COLUMN, 0); }
		public TerminalNode TO() { return getToken(SparrowSQLParser.TO, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> IF() { return getTokens(SparrowSQLParser.IF); }
		public TerminalNode IF(int i) {
			return getToken(SparrowSQLParser.IF, i);
		}
		public List<TerminalNode> EXISTS() { return getTokens(SparrowSQLParser.EXISTS); }
		public TerminalNode EXISTS(int i) {
			return getToken(SparrowSQLParser.EXISTS, i);
		}
		public RenameColumnContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterRenameColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitRenameColumn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitRenameColumn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DropColumnContext extends StatementContext {
		public QualifiedNameContext tableName;
		public QualifiedNameContext column;
		public TerminalNode ALTER() { return getToken(SparrowSQLParser.ALTER, 0); }
		public TerminalNode TABLE() { return getToken(SparrowSQLParser.TABLE, 0); }
		public TerminalNode DROP() { return getToken(SparrowSQLParser.DROP, 0); }
		public TerminalNode COLUMN() { return getToken(SparrowSQLParser.COLUMN, 0); }
		public List<QualifiedNameContext> qualifiedName() {
			return getRuleContexts(QualifiedNameContext.class);
		}
		public QualifiedNameContext qualifiedName(int i) {
			return getRuleContext(QualifiedNameContext.class,i);
		}
		public List<TerminalNode> IF() { return getTokens(SparrowSQLParser.IF); }
		public TerminalNode IF(int i) {
			return getToken(SparrowSQLParser.IF, i);
		}
		public List<TerminalNode> EXISTS() { return getTokens(SparrowSQLParser.EXISTS); }
		public TerminalNode EXISTS(int i) {
			return getToken(SparrowSQLParser.EXISTS, i);
		}
		public DropColumnContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterDropColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitDropColumn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitDropColumn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeleteContext extends StatementContext {
		public TerminalNode DELETE() { return getToken(SparrowSQLParser.DELETE, 0); }
		public TerminalNode FROM() { return getToken(SparrowSQLParser.FROM, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(SparrowSQLParser.WHERE, 0); }
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public DeleteContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterDelete(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitDelete(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitDelete(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DropTableContext extends StatementContext {
		public TerminalNode DROP() { return getToken(SparrowSQLParser.DROP, 0); }
		public TerminalNode TABLE() { return getToken(SparrowSQLParser.TABLE, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode IF() { return getToken(SparrowSQLParser.IF, 0); }
		public TerminalNode EXISTS() { return getToken(SparrowSQLParser.EXISTS, 0); }
		public DropTableContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterDropTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitDropTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitDropTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		int _la;
		try {
			setState(183);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new StatementDefaultContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				query();
				}
				break;
			case 2:
				_localctx = new CreateTableContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				match(CREATE);
				setState(81);
				match(TABLE);
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(82);
					match(IF);
					setState(83);
					match(NOT);
					setState(84);
					match(EXISTS);
					}
				}

				setState(87);
				qualifiedName();
				setState(88);
				match(T__0);
				setState(89);
				tableElement();
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(90);
					match(T__1);
					setState(91);
					tableElement();
					}
					}
					setState(96);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(97);
				match(T__2);
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMENT) {
					{
					setState(98);
					match(COMMENT);
					setState(99);
					string();
					}
				}

				}
				break;
			case 3:
				_localctx = new DropTableContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(102);
				match(DROP);
				setState(103);
				match(TABLE);
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(104);
					match(IF);
					setState(105);
					match(EXISTS);
					}
				}

				setState(108);
				qualifiedName();
				}
				break;
			case 4:
				_localctx = new InsertIntoContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(109);
				match(INSERT);
				setState(110);
				match(INTO);
				setState(111);
				qualifiedName();
				setState(113);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(112);
					columnAliases();
					}
					break;
				}
				setState(115);
				query();
				}
				break;
			case 5:
				_localctx = new DeleteContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(117);
				match(DELETE);
				setState(118);
				match(FROM);
				setState(119);
				qualifiedName();
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(120);
					match(WHERE);
					setState(121);
					booleanExpression(0);
					}
				}

				}
				break;
			case 6:
				_localctx = new RenameTableContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(124);
				match(ALTER);
				setState(125);
				match(TABLE);
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(126);
					match(IF);
					setState(127);
					match(EXISTS);
					}
				}

				setState(130);
				((RenameTableContext)_localctx).from = qualifiedName();
				setState(131);
				match(RENAME);
				setState(132);
				match(TO);
				setState(133);
				((RenameTableContext)_localctx).to = qualifiedName();
				}
				break;
			case 7:
				_localctx = new RenameColumnContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(135);
				match(ALTER);
				setState(136);
				match(TABLE);
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(137);
					match(IF);
					setState(138);
					match(EXISTS);
					}
				}

				setState(141);
				((RenameColumnContext)_localctx).tableName = qualifiedName();
				setState(142);
				match(RENAME);
				setState(143);
				match(COLUMN);
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(144);
					match(IF);
					setState(145);
					match(EXISTS);
					}
				}

				setState(148);
				((RenameColumnContext)_localctx).from = identifier();
				setState(149);
				match(TO);
				setState(150);
				((RenameColumnContext)_localctx).to = identifier();
				}
				break;
			case 8:
				_localctx = new DropColumnContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(152);
				match(ALTER);
				setState(153);
				match(TABLE);
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(154);
					match(IF);
					setState(155);
					match(EXISTS);
					}
				}

				setState(158);
				((DropColumnContext)_localctx).tableName = qualifiedName();
				setState(159);
				match(DROP);
				setState(160);
				match(COLUMN);
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(161);
					match(IF);
					setState(162);
					match(EXISTS);
					}
				}

				setState(165);
				((DropColumnContext)_localctx).column = qualifiedName();
				}
				break;
			case 9:
				_localctx = new AddColumnContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(167);
				match(ALTER);
				setState(168);
				match(TABLE);
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(169);
					match(IF);
					setState(170);
					match(EXISTS);
					}
				}

				setState(173);
				((AddColumnContext)_localctx).tableName = qualifiedName();
				setState(174);
				match(ADD);
				setState(175);
				match(COLUMN);
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(176);
					match(IF);
					setState(177);
					match(NOT);
					setState(178);
					match(EXISTS);
					}
				}

				setState(181);
				((AddColumnContext)_localctx).column = columnDefinition();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableElementContext extends ParserRuleContext {
		public ColumnDefinitionContext columnDefinition() {
			return getRuleContext(ColumnDefinitionContext.class,0);
		}
		public LikeClauseContext likeClause() {
			return getRuleContext(LikeClauseContext.class,0);
		}
		public TableElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterTableElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitTableElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitTableElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableElementContext tableElement() throws RecognitionException {
		TableElementContext _localctx = new TableElementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_tableElement);
		try {
			setState(187);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
			case DIGIT_IDENTIFIER:
			case QUOTED_IDENTIFIER:
			case BACKQUOTED_IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(185);
				columnDefinition();
				}
				break;
			case LIKE:
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				likeClause();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnDefinitionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SparrowSQLParser.NOT, 0); }
		public TerminalNode NULL() { return getToken(SparrowSQLParser.NULL, 0); }
		public TerminalNode COMMENT() { return getToken(SparrowSQLParser.COMMENT, 0); }
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public ColumnDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterColumnDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitColumnDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitColumnDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnDefinitionContext columnDefinition() throws RecognitionException {
		ColumnDefinitionContext _localctx = new ColumnDefinitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_columnDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			identifier();
			setState(190);
			type();
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(191);
				match(NOT);
				setState(192);
				match(NULL);
				}
			}

			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMENT) {
				{
				setState(195);
				match(COMMENT);
				setState(196);
				string();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LikeClauseContext extends ParserRuleContext {
		public TerminalNode LIKE() { return getToken(SparrowSQLParser.LIKE, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public LikeClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_likeClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterLikeClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitLikeClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitLikeClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LikeClauseContext likeClause() throws RecognitionException {
		LikeClauseContext _localctx = new LikeClauseContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_likeClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(LIKE);
			setState(200);
			qualifiedName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryContext extends ParserRuleContext {
		public QueryNoWithContext queryNoWith() {
			return getRuleContext(QueryNoWithContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			queryNoWith();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryNoWithContext extends ParserRuleContext {
		public Token offset;
		public Token limit;
		public QueryTermContext queryTerm() {
			return getRuleContext(QueryTermContext.class,0);
		}
		public TerminalNode ORDER() { return getToken(SparrowSQLParser.ORDER, 0); }
		public TerminalNode BY() { return getToken(SparrowSQLParser.BY, 0); }
		public List<SortItemContext> sortItem() {
			return getRuleContexts(SortItemContext.class);
		}
		public SortItemContext sortItem(int i) {
			return getRuleContext(SortItemContext.class,i);
		}
		public TerminalNode OFFSET() { return getToken(SparrowSQLParser.OFFSET, 0); }
		public TerminalNode LIMIT() { return getToken(SparrowSQLParser.LIMIT, 0); }
		public List<TerminalNode> INTEGER_VALUE() { return getTokens(SparrowSQLParser.INTEGER_VALUE); }
		public TerminalNode INTEGER_VALUE(int i) {
			return getToken(SparrowSQLParser.INTEGER_VALUE, i);
		}
		public TerminalNode ROW() { return getToken(SparrowSQLParser.ROW, 0); }
		public TerminalNode ROWS() { return getToken(SparrowSQLParser.ROWS, 0); }
		public QueryNoWithContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryNoWith; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterQueryNoWith(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitQueryNoWith(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitQueryNoWith(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryNoWithContext queryNoWith() throws RecognitionException {
		QueryNoWithContext _localctx = new QueryNoWithContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_queryNoWith);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			queryTerm();
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(205);
				match(ORDER);
				setState(206);
				match(BY);
				setState(207);
				sortItem();
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(208);
					match(T__1);
					setState(209);
					sortItem();
					}
					}
					setState(214);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OFFSET) {
				{
				setState(217);
				match(OFFSET);
				setState(218);
				((QueryNoWithContext)_localctx).offset = match(INTEGER_VALUE);
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ROW || _la==ROWS) {
					{
					setState(219);
					_la = _input.LA(1);
					if ( !(_la==ROW || _la==ROWS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				}
			}

			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(224);
				match(LIMIT);
				setState(225);
				((QueryNoWithContext)_localctx).limit = match(INTEGER_VALUE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryTermContext extends ParserRuleContext {
		public QueryTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryTerm; }
	 
		public QueryTermContext() { }
		public void copyFrom(QueryTermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class QueryTermDefaultContext extends QueryTermContext {
		public QueryPrimaryContext queryPrimary() {
			return getRuleContext(QueryPrimaryContext.class,0);
		}
		public QueryTermDefaultContext(QueryTermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterQueryTermDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitQueryTermDefault(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitQueryTermDefault(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryTermContext queryTerm() throws RecognitionException {
		QueryTermContext _localctx = new QueryTermContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_queryTerm);
		try {
			_localctx = new QueryTermDefaultContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			queryPrimary();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryPrimaryContext extends ParserRuleContext {
		public QueryPrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryPrimary; }
	 
		public QueryPrimaryContext() { }
		public void copyFrom(QueryPrimaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SubqueryContext extends QueryPrimaryContext {
		public QueryNoWithContext queryNoWith() {
			return getRuleContext(QueryNoWithContext.class,0);
		}
		public SubqueryContext(QueryPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterSubquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitSubquery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitSubquery(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QueryPrimaryDefaultContext extends QueryPrimaryContext {
		public QuerySpecificationContext querySpecification() {
			return getRuleContext(QuerySpecificationContext.class,0);
		}
		public QueryPrimaryDefaultContext(QueryPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterQueryPrimaryDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitQueryPrimaryDefault(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitQueryPrimaryDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TableContext extends QueryPrimaryContext {
		public TerminalNode TABLE() { return getToken(SparrowSQLParser.TABLE, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TableContext(QueryPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitTable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InlineTableContext extends QueryPrimaryContext {
		public TerminalNode VALUES() { return getToken(SparrowSQLParser.VALUES, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public InlineTableContext(QueryPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterInlineTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitInlineTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitInlineTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryPrimaryContext queryPrimary() throws RecognitionException {
		QueryPrimaryContext _localctx = new QueryPrimaryContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_queryPrimary);
		int _la;
		try {
			setState(246);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELECT:
				_localctx = new QueryPrimaryDefaultContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(230);
				querySpecification();
				}
				break;
			case TABLE:
				_localctx = new TableContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(231);
				match(TABLE);
				setState(232);
				qualifiedName();
				}
				break;
			case VALUES:
				_localctx = new InlineTableContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(233);
				match(VALUES);
				setState(234);
				expression();
				setState(239);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(235);
					match(T__1);
					setState(236);
					expression();
					}
					}
					setState(241);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__0:
				_localctx = new SubqueryContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(242);
				match(T__0);
				setState(243);
				queryNoWith();
				setState(244);
				match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SortItemContext extends ParserRuleContext {
		public Token ordering;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ASC() { return getToken(SparrowSQLParser.ASC, 0); }
		public TerminalNode DESC() { return getToken(SparrowSQLParser.DESC, 0); }
		public SortItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sortItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterSortItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitSortItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitSortItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SortItemContext sortItem() throws RecognitionException {
		SortItemContext _localctx = new SortItemContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_sortItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			expression();
			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(249);
				((SortItemContext)_localctx).ordering = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ASC || _la==DESC) ) {
					((SortItemContext)_localctx).ordering = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuerySpecificationContext extends ParserRuleContext {
		public BooleanExpressionContext where;
		public TerminalNode SELECT() { return getToken(SparrowSQLParser.SELECT, 0); }
		public List<SelectItemContext> selectItem() {
			return getRuleContexts(SelectItemContext.class);
		}
		public SelectItemContext selectItem(int i) {
			return getRuleContext(SelectItemContext.class,i);
		}
		public SetQuantifierContext setQuantifier() {
			return getRuleContext(SetQuantifierContext.class,0);
		}
		public TerminalNode FROM() { return getToken(SparrowSQLParser.FROM, 0); }
		public List<RelationContext> relation() {
			return getRuleContexts(RelationContext.class);
		}
		public RelationContext relation(int i) {
			return getRuleContext(RelationContext.class,i);
		}
		public TerminalNode WHERE() { return getToken(SparrowSQLParser.WHERE, 0); }
		public TerminalNode GROUP() { return getToken(SparrowSQLParser.GROUP, 0); }
		public TerminalNode BY() { return getToken(SparrowSQLParser.BY, 0); }
		public GroupByContext groupBy() {
			return getRuleContext(GroupByContext.class,0);
		}
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public QuerySpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_querySpecification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterQuerySpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitQuerySpecification(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitQuerySpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuerySpecificationContext querySpecification() throws RecognitionException {
		QuerySpecificationContext _localctx = new QuerySpecificationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_querySpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(SELECT);
			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(253);
				setQuantifier();
				}
			}

			setState(256);
			selectItem();
			setState(261);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(257);
				match(T__1);
				setState(258);
				selectItem();
				}
				}
				setState(263);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(264);
				match(FROM);
				setState(265);
				relation(0);
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(266);
					match(T__1);
					setState(267);
					relation(0);
					}
					}
					setState(272);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(275);
				match(WHERE);
				setState(276);
				((QuerySpecificationContext)_localctx).where = booleanExpression(0);
				}
			}

			setState(282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==GROUP) {
				{
				setState(279);
				match(GROUP);
				setState(280);
				match(BY);
				setState(281);
				groupBy();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupByContext extends ParserRuleContext {
		public List<GroupingElementContext> groupingElement() {
			return getRuleContexts(GroupingElementContext.class);
		}
		public GroupingElementContext groupingElement(int i) {
			return getRuleContext(GroupingElementContext.class,i);
		}
		public SetQuantifierContext setQuantifier() {
			return getRuleContext(SetQuantifierContext.class,0);
		}
		public GroupByContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupBy; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterGroupBy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitGroupBy(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitGroupBy(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupByContext groupBy() throws RecognitionException {
		GroupByContext _localctx = new GroupByContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_groupBy);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(284);
				setQuantifier();
				}
			}

			setState(287);
			groupingElement();
			setState(292);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(288);
				match(T__1);
				setState(289);
				groupingElement();
				}
				}
				setState(294);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupingElementContext extends ParserRuleContext {
		public GroupingElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupingElement; }
	 
		public GroupingElementContext() { }
		public void copyFrom(GroupingElementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SingleGroupingSetContext extends GroupingElementContext {
		public GroupingSetContext groupingSet() {
			return getRuleContext(GroupingSetContext.class,0);
		}
		public SingleGroupingSetContext(GroupingElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterSingleGroupingSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitSingleGroupingSet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitSingleGroupingSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupingElementContext groupingElement() throws RecognitionException {
		GroupingElementContext _localctx = new GroupingElementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_groupingElement);
		try {
			_localctx = new SingleGroupingSetContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			groupingSet();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupingSetContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public GroupingSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupingSet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterGroupingSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitGroupingSet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitGroupingSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupingSetContext groupingSet() throws RecognitionException {
		GroupingSetContext _localctx = new GroupingSetContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_groupingSet);
		int _la;
		try {
			setState(310);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(297);
				match(T__0);
				setState(306);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__4) | (1L << FALSE) | (1L << NOT) | (1L << NULL) | (1L << TRUE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (PLUS - 69)) | (1L << (MINUS - 69)) | (1L << (STRING - 69)) | (1L << (INTEGER_VALUE - 69)) | (1L << (DECIMAL_VALUE - 69)) | (1L << (DOUBLE_VALUE - 69)) | (1L << (IDENTIFIER - 69)) | (1L << (DIGIT_IDENTIFIER - 69)) | (1L << (QUOTED_IDENTIFIER - 69)) | (1L << (BACKQUOTED_IDENTIFIER - 69)))) != 0)) {
					{
					setState(298);
					expression();
					setState(303);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(299);
						match(T__1);
						setState(300);
						expression();
						}
						}
						setState(305);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(308);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(309);
				expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetQuantifierContext extends ParserRuleContext {
		public TerminalNode DISTINCT() { return getToken(SparrowSQLParser.DISTINCT, 0); }
		public TerminalNode ALL() { return getToken(SparrowSQLParser.ALL, 0); }
		public SetQuantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setQuantifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterSetQuantifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitSetQuantifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitSetQuantifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetQuantifierContext setQuantifier() throws RecognitionException {
		SetQuantifierContext _localctx = new SetQuantifierContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_setQuantifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			_la = _input.LA(1);
			if ( !(_la==ALL || _la==DISTINCT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectItemContext extends ParserRuleContext {
		public SelectItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectItem; }
	 
		public SelectItemContext() { }
		public void copyFrom(SelectItemContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SelectAllContext extends SelectItemContext {
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode ASTERISK() { return getToken(SparrowSQLParser.ASTERISK, 0); }
		public SelectAllContext(SelectItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterSelectAll(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitSelectAll(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitSelectAll(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SelectSingleContext extends SelectItemContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode AS() { return getToken(SparrowSQLParser.AS, 0); }
		public SelectSingleContext(SelectItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterSelectSingle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitSelectSingle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitSelectSingle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectItemContext selectItem() throws RecognitionException {
		SelectItemContext _localctx = new SelectItemContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_selectItem);
		int _la;
		try {
			setState(326);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				_localctx = new SelectSingleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(314);
				expression();
				setState(319);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (IDENTIFIER - 81)) | (1L << (DIGIT_IDENTIFIER - 81)) | (1L << (QUOTED_IDENTIFIER - 81)) | (1L << (BACKQUOTED_IDENTIFIER - 81)))) != 0)) {
					{
					setState(316);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(315);
						match(AS);
						}
					}

					setState(318);
					identifier();
					}
				}

				}
				break;
			case 2:
				_localctx = new SelectAllContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(321);
				qualifiedName();
				setState(322);
				match(T__3);
				setState(323);
				match(ASTERISK);
				}
				break;
			case 3:
				_localctx = new SelectAllContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(325);
				match(ASTERISK);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationContext extends ParserRuleContext {
		public RelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation; }
	 
		public RelationContext() { }
		public void copyFrom(RelationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RelationDefaultContext extends RelationContext {
		public SampledRelationContext sampledRelation() {
			return getRuleContext(SampledRelationContext.class,0);
		}
		public RelationDefaultContext(RelationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterRelationDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitRelationDefault(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitRelationDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class JoinRelationContext extends RelationContext {
		public RelationContext left;
		public SampledRelationContext right;
		public RelationContext rightRelation;
		public List<RelationContext> relation() {
			return getRuleContexts(RelationContext.class);
		}
		public RelationContext relation(int i) {
			return getRuleContext(RelationContext.class,i);
		}
		public TerminalNode CROSS() { return getToken(SparrowSQLParser.CROSS, 0); }
		public TerminalNode JOIN() { return getToken(SparrowSQLParser.JOIN, 0); }
		public JoinTypeContext joinType() {
			return getRuleContext(JoinTypeContext.class,0);
		}
		public JoinCriteriaContext joinCriteria() {
			return getRuleContext(JoinCriteriaContext.class,0);
		}
		public TerminalNode NATURAL() { return getToken(SparrowSQLParser.NATURAL, 0); }
		public SampledRelationContext sampledRelation() {
			return getRuleContext(SampledRelationContext.class,0);
		}
		public JoinRelationContext(RelationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterJoinRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitJoinRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitJoinRelation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationContext relation() throws RecognitionException {
		return relation(0);
	}

	private RelationContext relation(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelationContext _localctx = new RelationContext(_ctx, _parentState);
		RelationContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_relation, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new RelationDefaultContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(329);
			sampledRelation();
			}
			_ctx.stop = _input.LT(-1);
			setState(349);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new JoinRelationContext(new RelationContext(_parentctx, _parentState));
					((JoinRelationContext)_localctx).left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_relation);
					setState(331);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(345);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case CROSS:
						{
						setState(332);
						match(CROSS);
						setState(333);
						match(JOIN);
						setState(334);
						((JoinRelationContext)_localctx).right = sampledRelation();
						}
						break;
					case FULL:
					case JOIN:
					case INNER:
					case LEFT:
					case RIGHT:
						{
						setState(335);
						joinType();
						setState(336);
						match(JOIN);
						setState(337);
						((JoinRelationContext)_localctx).rightRelation = relation(0);
						setState(338);
						joinCriteria();
						}
						break;
					case NATURAL:
						{
						setState(340);
						match(NATURAL);
						setState(341);
						joinType();
						setState(342);
						match(JOIN);
						setState(343);
						((JoinRelationContext)_localctx).right = sampledRelation();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					} 
				}
				setState(351);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class JoinTypeContext extends ParserRuleContext {
		public TerminalNode INNER() { return getToken(SparrowSQLParser.INNER, 0); }
		public TerminalNode LEFT() { return getToken(SparrowSQLParser.LEFT, 0); }
		public TerminalNode OUTER() { return getToken(SparrowSQLParser.OUTER, 0); }
		public TerminalNode RIGHT() { return getToken(SparrowSQLParser.RIGHT, 0); }
		public TerminalNode FULL() { return getToken(SparrowSQLParser.FULL, 0); }
		public JoinTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterJoinType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitJoinType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitJoinType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinTypeContext joinType() throws RecognitionException {
		JoinTypeContext _localctx = new JoinTypeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_joinType);
		int _la;
		try {
			setState(367);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case JOIN:
			case INNER:
				enterOuterAlt(_localctx, 1);
				{
				setState(353);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INNER) {
					{
					setState(352);
					match(INNER);
					}
				}

				}
				break;
			case LEFT:
				enterOuterAlt(_localctx, 2);
				{
				setState(355);
				match(LEFT);
				setState(357);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTER) {
					{
					setState(356);
					match(OUTER);
					}
				}

				}
				break;
			case RIGHT:
				enterOuterAlt(_localctx, 3);
				{
				setState(359);
				match(RIGHT);
				setState(361);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTER) {
					{
					setState(360);
					match(OUTER);
					}
				}

				}
				break;
			case FULL:
				enterOuterAlt(_localctx, 4);
				{
				setState(363);
				match(FULL);
				setState(365);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTER) {
					{
					setState(364);
					match(OUTER);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JoinCriteriaContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(SparrowSQLParser.ON, 0); }
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public JoinCriteriaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinCriteria; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterJoinCriteria(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitJoinCriteria(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitJoinCriteria(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinCriteriaContext joinCriteria() throws RecognitionException {
		JoinCriteriaContext _localctx = new JoinCriteriaContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_joinCriteria);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			match(ON);
			setState(370);
			booleanExpression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SampledRelationContext extends ParserRuleContext {
		public ExpressionContext percentage;
		public AliasedRelationContext aliasedRelation() {
			return getRuleContext(AliasedRelationContext.class,0);
		}
		public TerminalNode TABLESAMPLE() { return getToken(SparrowSQLParser.TABLESAMPLE, 0); }
		public SampleTypeContext sampleType() {
			return getRuleContext(SampleTypeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SampledRelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sampledRelation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterSampledRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitSampledRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitSampledRelation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SampledRelationContext sampledRelation() throws RecognitionException {
		SampledRelationContext _localctx = new SampledRelationContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_sampledRelation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			aliasedRelation();
			setState(379);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				{
				setState(373);
				match(TABLESAMPLE);
				setState(374);
				sampleType();
				setState(375);
				match(T__0);
				setState(376);
				((SampledRelationContext)_localctx).percentage = expression();
				setState(377);
				match(T__2);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SampleTypeContext extends ParserRuleContext {
		public TerminalNode BERNOULLI() { return getToken(SparrowSQLParser.BERNOULLI, 0); }
		public TerminalNode SYSTEM() { return getToken(SparrowSQLParser.SYSTEM, 0); }
		public SampleTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sampleType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterSampleType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitSampleType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitSampleType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SampleTypeContext sampleType() throws RecognitionException {
		SampleTypeContext _localctx = new SampleTypeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_sampleType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			_la = _input.LA(1);
			if ( !(_la==BERNOULLI || _la==SYSTEM) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AliasedRelationContext extends ParserRuleContext {
		public RelationPrimaryContext relationPrimary() {
			return getRuleContext(RelationPrimaryContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode AS() { return getToken(SparrowSQLParser.AS, 0); }
		public ColumnAliasesContext columnAliases() {
			return getRuleContext(ColumnAliasesContext.class,0);
		}
		public AliasedRelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aliasedRelation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterAliasedRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitAliasedRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitAliasedRelation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AliasedRelationContext aliasedRelation() throws RecognitionException {
		AliasedRelationContext _localctx = new AliasedRelationContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_aliasedRelation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
			relationPrimary();
			setState(391);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				{
				setState(385);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(384);
					match(AS);
					}
				}

				setState(387);
				identifier();
				setState(389);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
				case 1:
					{
					setState(388);
					columnAliases();
					}
					break;
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnAliasesContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public ColumnAliasesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnAliases; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterColumnAliases(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitColumnAliases(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitColumnAliases(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnAliasesContext columnAliases() throws RecognitionException {
		ColumnAliasesContext _localctx = new ColumnAliasesContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_columnAliases);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(393);
			match(T__0);
			setState(394);
			identifier();
			setState(399);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(395);
				match(T__1);
				setState(396);
				identifier();
				}
				}
				setState(401);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(402);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationPrimaryContext extends ParserRuleContext {
		public RelationPrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationPrimary; }
	 
		public RelationPrimaryContext() { }
		public void copyFrom(RelationPrimaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SubqueryRelationContext extends RelationPrimaryContext {
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public SubqueryRelationContext(RelationPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterSubqueryRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitSubqueryRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitSubqueryRelation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesizedRelationContext extends RelationPrimaryContext {
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
		}
		public ParenthesizedRelationContext(RelationPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterParenthesizedRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitParenthesizedRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitParenthesizedRelation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TableNameContext extends RelationPrimaryContext {
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TableNameContext(RelationPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterTableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitTableName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitTableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationPrimaryContext relationPrimary() throws RecognitionException {
		RelationPrimaryContext _localctx = new RelationPrimaryContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_relationPrimary);
		try {
			setState(413);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				_localctx = new TableNameContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(404);
				qualifiedName();
				}
				break;
			case 2:
				_localctx = new SubqueryRelationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(405);
				match(T__0);
				setState(406);
				query();
				setState(407);
				match(T__2);
				}
				break;
			case 3:
				_localctx = new ParenthesizedRelationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(409);
				match(T__0);
				setState(410);
				relation(0);
				setState(411);
				match(T__2);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			booleanExpression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanExpressionContext extends ParserRuleContext {
		public BooleanExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanExpression; }
	 
		public BooleanExpressionContext() { }
		public void copyFrom(BooleanExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LogicalNotContext extends BooleanExpressionContext {
		public TerminalNode NOT() { return getToken(SparrowSQLParser.NOT, 0); }
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public LogicalNotContext(BooleanExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterLogicalNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitLogicalNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitLogicalNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanDefaultContext extends BooleanExpressionContext {
		public PredicatedContext predicated() {
			return getRuleContext(PredicatedContext.class,0);
		}
		public BooleanDefaultContext(BooleanExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterBooleanDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitBooleanDefault(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitBooleanDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicalBinaryContext extends BooleanExpressionContext {
		public BooleanExpressionContext left;
		public Token operator;
		public BooleanExpressionContext right;
		public List<BooleanExpressionContext> booleanExpression() {
			return getRuleContexts(BooleanExpressionContext.class);
		}
		public BooleanExpressionContext booleanExpression(int i) {
			return getRuleContext(BooleanExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(SparrowSQLParser.AND, 0); }
		public TerminalNode OR() { return getToken(SparrowSQLParser.OR, 0); }
		public LogicalBinaryContext(BooleanExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterLogicalBinary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitLogicalBinary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitLogicalBinary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanExpressionContext booleanExpression() throws RecognitionException {
		return booleanExpression(0);
	}

	private BooleanExpressionContext booleanExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BooleanExpressionContext _localctx = new BooleanExpressionContext(_ctx, _parentState);
		BooleanExpressionContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_booleanExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(421);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__4:
			case FALSE:
			case NULL:
			case TRUE:
			case PLUS:
			case MINUS:
			case STRING:
			case INTEGER_VALUE:
			case DECIMAL_VALUE:
			case DOUBLE_VALUE:
			case IDENTIFIER:
			case DIGIT_IDENTIFIER:
			case QUOTED_IDENTIFIER:
			case BACKQUOTED_IDENTIFIER:
				{
				_localctx = new BooleanDefaultContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(418);
				predicated();
				}
				break;
			case NOT:
				{
				_localctx = new LogicalNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(419);
				match(NOT);
				setState(420);
				booleanExpression(3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(431);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(429);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
					case 1:
						{
						_localctx = new LogicalBinaryContext(new BooleanExpressionContext(_parentctx, _parentState));
						((LogicalBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_booleanExpression);
						setState(423);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(424);
						((LogicalBinaryContext)_localctx).operator = match(AND);
						setState(425);
						((LogicalBinaryContext)_localctx).right = booleanExpression(3);
						}
						break;
					case 2:
						{
						_localctx = new LogicalBinaryContext(new BooleanExpressionContext(_parentctx, _parentState));
						((LogicalBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_booleanExpression);
						setState(426);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(427);
						((LogicalBinaryContext)_localctx).operator = match(OR);
						setState(428);
						((LogicalBinaryContext)_localctx).right = booleanExpression(2);
						}
						break;
					}
					} 
				}
				setState(433);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PredicatedContext extends ParserRuleContext {
		public ValueExpressionContext valueExpression;
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public PredicatedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicated; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterPredicated(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitPredicated(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitPredicated(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicatedContext predicated() throws RecognitionException {
		PredicatedContext _localctx = new PredicatedContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_predicated);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(434);
			((PredicatedContext)_localctx).valueExpression = valueExpression(0);
			setState(436);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				{
				setState(435);
				predicate(((PredicatedContext)_localctx).valueExpression);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateContext extends ParserRuleContext {
		public ParserRuleContext value;
		public PredicateContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public PredicateContext(ParserRuleContext parent, int invokingState, ParserRuleContext value) {
			super(parent, invokingState);
			this.value = value;
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
	 
		public PredicateContext() { }
		public void copyFrom(PredicateContext ctx) {
			super.copyFrom(ctx);
			this.value = ctx.value;
		}
	}
	public static class ComparisonContext extends PredicateContext {
		public ValueExpressionContext right;
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public ComparisonContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InSubqueryContext extends PredicateContext {
		public TerminalNode IN() { return getToken(SparrowSQLParser.IN, 0); }
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SparrowSQLParser.NOT, 0); }
		public InSubqueryContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterInSubquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitInSubquery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitInSubquery(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DistinctFromContext extends PredicateContext {
		public ValueExpressionContext right;
		public TerminalNode IS() { return getToken(SparrowSQLParser.IS, 0); }
		public TerminalNode DISTINCT() { return getToken(SparrowSQLParser.DISTINCT, 0); }
		public TerminalNode FROM() { return getToken(SparrowSQLParser.FROM, 0); }
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SparrowSQLParser.NOT, 0); }
		public DistinctFromContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterDistinctFrom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitDistinctFrom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitDistinctFrom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InListContext extends PredicateContext {
		public TerminalNode IN() { return getToken(SparrowSQLParser.IN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode NOT() { return getToken(SparrowSQLParser.NOT, 0); }
		public InListContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterInList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitInList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitInList(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullPredicateContext extends PredicateContext {
		public TerminalNode IS() { return getToken(SparrowSQLParser.IS, 0); }
		public TerminalNode NULL() { return getToken(SparrowSQLParser.NULL, 0); }
		public TerminalNode NOT() { return getToken(SparrowSQLParser.NOT, 0); }
		public NullPredicateContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterNullPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitNullPredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitNullPredicate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BetweenContext extends PredicateContext {
		public ValueExpressionContext lower;
		public ValueExpressionContext upper;
		public TerminalNode BETWEEN() { return getToken(SparrowSQLParser.BETWEEN, 0); }
		public TerminalNode AND() { return getToken(SparrowSQLParser.AND, 0); }
		public List<ValueExpressionContext> valueExpression() {
			return getRuleContexts(ValueExpressionContext.class);
		}
		public ValueExpressionContext valueExpression(int i) {
			return getRuleContext(ValueExpressionContext.class,i);
		}
		public TerminalNode NOT() { return getToken(SparrowSQLParser.NOT, 0); }
		public BetweenContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterBetween(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitBetween(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitBetween(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateContext predicate(ParserRuleContext value) throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState(), value);
		enterRule(_localctx, 54, RULE_predicate);
		int _la;
		try {
			setState(484);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				_localctx = new ComparisonContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(438);
				comparisonOperator();
				setState(439);
				((ComparisonContext)_localctx).right = valueExpression(0);
				}
				break;
			case 2:
				_localctx = new BetweenContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(442);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(441);
					match(NOT);
					}
				}

				setState(444);
				match(BETWEEN);
				setState(445);
				((BetweenContext)_localctx).lower = valueExpression(0);
				setState(446);
				match(AND);
				setState(447);
				((BetweenContext)_localctx).upper = valueExpression(0);
				}
				break;
			case 3:
				_localctx = new InListContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(450);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(449);
					match(NOT);
					}
				}

				setState(452);
				match(IN);
				setState(453);
				match(T__0);
				setState(454);
				expression();
				setState(459);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(455);
					match(T__1);
					setState(456);
					expression();
					}
					}
					setState(461);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(462);
				match(T__2);
				}
				break;
			case 4:
				_localctx = new InSubqueryContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(465);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(464);
					match(NOT);
					}
				}

				setState(467);
				match(IN);
				setState(468);
				match(T__0);
				setState(469);
				query();
				setState(470);
				match(T__2);
				}
				break;
			case 5:
				_localctx = new NullPredicateContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(472);
				match(IS);
				setState(474);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(473);
					match(NOT);
					}
				}

				setState(476);
				match(NULL);
				}
				break;
			case 6:
				_localctx = new DistinctFromContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(477);
				match(IS);
				setState(479);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(478);
					match(NOT);
					}
				}

				setState(481);
				match(DISTINCT);
				setState(482);
				match(FROM);
				setState(483);
				((DistinctFromContext)_localctx).right = valueExpression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueExpressionContext extends ParserRuleContext {
		public ValueExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueExpression; }
	 
		public ValueExpressionContext() { }
		public void copyFrom(ValueExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ValueExpressionDefaultContext extends ValueExpressionContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public ValueExpressionDefaultContext(ValueExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterValueExpressionDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitValueExpressionDefault(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitValueExpressionDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConcatenationContext extends ValueExpressionContext {
		public ValueExpressionContext left;
		public ValueExpressionContext right;
		public TerminalNode CONCAT() { return getToken(SparrowSQLParser.CONCAT, 0); }
		public List<ValueExpressionContext> valueExpression() {
			return getRuleContexts(ValueExpressionContext.class);
		}
		public ValueExpressionContext valueExpression(int i) {
			return getRuleContext(ValueExpressionContext.class,i);
		}
		public ConcatenationContext(ValueExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterConcatenation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitConcatenation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitConcatenation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithmeticBinaryContext extends ValueExpressionContext {
		public ValueExpressionContext left;
		public Token operator;
		public ValueExpressionContext right;
		public List<ValueExpressionContext> valueExpression() {
			return getRuleContexts(ValueExpressionContext.class);
		}
		public ValueExpressionContext valueExpression(int i) {
			return getRuleContext(ValueExpressionContext.class,i);
		}
		public TerminalNode ASTERISK() { return getToken(SparrowSQLParser.ASTERISK, 0); }
		public TerminalNode SLASH() { return getToken(SparrowSQLParser.SLASH, 0); }
		public TerminalNode PERCENT() { return getToken(SparrowSQLParser.PERCENT, 0); }
		public TerminalNode PLUS() { return getToken(SparrowSQLParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SparrowSQLParser.MINUS, 0); }
		public ArithmeticBinaryContext(ValueExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterArithmeticBinary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitArithmeticBinary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitArithmeticBinary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithmeticUnaryContext extends ValueExpressionContext {
		public Token operator;
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(SparrowSQLParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(SparrowSQLParser.PLUS, 0); }
		public ArithmeticUnaryContext(ValueExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterArithmeticUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitArithmeticUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitArithmeticUnary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueExpressionContext valueExpression() throws RecognitionException {
		return valueExpression(0);
	}

	private ValueExpressionContext valueExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ValueExpressionContext _localctx = new ValueExpressionContext(_ctx, _parentState);
		ValueExpressionContext _prevctx = _localctx;
		int _startState = 56;
		enterRecursionRule(_localctx, 56, RULE_valueExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(490);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__4:
			case FALSE:
			case NULL:
			case TRUE:
			case STRING:
			case INTEGER_VALUE:
			case DECIMAL_VALUE:
			case DOUBLE_VALUE:
			case IDENTIFIER:
			case DIGIT_IDENTIFIER:
			case QUOTED_IDENTIFIER:
			case BACKQUOTED_IDENTIFIER:
				{
				_localctx = new ValueExpressionDefaultContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(487);
				primaryExpression();
				}
				break;
			case PLUS:
			case MINUS:
				{
				_localctx = new ArithmeticUnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(488);
				((ArithmeticUnaryContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
					((ArithmeticUnaryContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(489);
				valueExpression(4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(503);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(501);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticBinaryContext(new ValueExpressionContext(_parentctx, _parentState));
						((ArithmeticBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_valueExpression);
						setState(492);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(493);
						((ArithmeticBinaryContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (ASTERISK - 71)) | (1L << (SLASH - 71)) | (1L << (PERCENT - 71)))) != 0)) ) {
							((ArithmeticBinaryContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(494);
						((ArithmeticBinaryContext)_localctx).right = valueExpression(4);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticBinaryContext(new ValueExpressionContext(_parentctx, _parentState));
						((ArithmeticBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_valueExpression);
						setState(495);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(496);
						((ArithmeticBinaryContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((ArithmeticBinaryContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(497);
						((ArithmeticBinaryContext)_localctx).right = valueExpression(3);
						}
						break;
					case 3:
						{
						_localctx = new ConcatenationContext(new ValueExpressionContext(_parentctx, _parentState));
						((ConcatenationContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_valueExpression);
						setState(498);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(499);
						match(CONCAT);
						setState(500);
						((ConcatenationContext)_localctx).right = valueExpression(2);
						}
						break;
					}
					} 
				}
				setState(505);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrimaryExpressionContext extends ParserRuleContext {
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
	 
		public PrimaryExpressionContext() { }
		public void copyFrom(PrimaryExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ColumnReferenceContext extends PrimaryExpressionContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ColumnReferenceContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterColumnReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitColumnReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitColumnReference(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullLiteralContext extends PrimaryExpressionContext {
		public TerminalNode NULL() { return getToken(SparrowSQLParser.NULL, 0); }
		public NullLiteralContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterNullLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitNullLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitNullLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RowConstructorContext extends PrimaryExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public RowConstructorContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterRowConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitRowConstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitRowConstructor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringLiteralContext extends PrimaryExpressionContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public StringLiteralContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeConstructorContext extends PrimaryExpressionContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public TypeConstructorContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterTypeConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitTypeConstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitTypeConstructor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParameterContext extends PrimaryExpressionContext {
		public ParameterContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumericLiteralContext extends PrimaryExpressionContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public NumericLiteralContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterNumericLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitNumericLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitNumericLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanLiteralContext extends PrimaryExpressionContext {
		public BooleanValueContext booleanValue() {
			return getRuleContext(BooleanValueContext.class,0);
		}
		public BooleanLiteralContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitBooleanLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_primaryExpression);
		int _la;
		try {
			setState(525);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				_localctx = new NullLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(506);
				match(NULL);
				}
				break;
			case 2:
				_localctx = new TypeConstructorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(507);
				identifier();
				setState(508);
				string();
				}
				break;
			case 3:
				_localctx = new NumericLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(510);
				number();
				}
				break;
			case 4:
				_localctx = new BooleanLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(511);
				booleanValue();
				}
				break;
			case 5:
				_localctx = new StringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(512);
				string();
				}
				break;
			case 6:
				_localctx = new ColumnReferenceContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(513);
				identifier();
				}
				break;
			case 7:
				_localctx = new ParameterContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(514);
				match(T__4);
				}
				break;
			case 8:
				_localctx = new RowConstructorContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(515);
				match(T__0);
				setState(516);
				expression();
				setState(519); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(517);
					match(T__1);
					setState(518);
					expression();
					}
					}
					setState(521); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__1 );
				setState(523);
				match(T__2);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringContext extends ParserRuleContext {
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
	 
		public StringContext() { }
		public void copyFrom(StringContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BasicStringLiteralContext extends StringContext {
		public TerminalNode STRING() { return getToken(SparrowSQLParser.STRING, 0); }
		public BasicStringLiteralContext(StringContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterBasicStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitBasicStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitBasicStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_string);
		try {
			_localctx = new BasicStringLiteralContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(527);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public List<TypeParameterContext> typeParameter() {
			return getRuleContexts(TypeParameterContext.class);
		}
		public TypeParameterContext typeParameter(int i) {
			return getRuleContext(TypeParameterContext.class,i);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(529);
			qualifiedName();
			setState(541);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(530);
				match(T__0);
				setState(531);
				typeParameter();
				setState(536);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(532);
					match(T__1);
					setState(533);
					typeParameter();
					}
					}
					setState(538);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(539);
				match(T__2);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeParameterContext extends ParserRuleContext {
		public TerminalNode INTEGER_VALUE() { return getToken(SparrowSQLParser.INTEGER_VALUE, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterTypeParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitTypeParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitTypeParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeParameterContext typeParameter() throws RecognitionException {
		TypeParameterContext _localctx = new TypeParameterContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_typeParameter);
		try {
			setState(545);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER_VALUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(543);
				match(INTEGER_VALUE);
				}
				break;
			case IDENTIFIER:
			case DIGIT_IDENTIFIER:
			case QUOTED_IDENTIFIER:
			case BACKQUOTED_IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(544);
				type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparisonOperatorContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(SparrowSQLParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(SparrowSQLParser.NEQ, 0); }
		public TerminalNode LT() { return getToken(SparrowSQLParser.LT, 0); }
		public TerminalNode LTE() { return getToken(SparrowSQLParser.LTE, 0); }
		public TerminalNode GT() { return getToken(SparrowSQLParser.GT, 0); }
		public TerminalNode GTE() { return getToken(SparrowSQLParser.GTE, 0); }
		public ComparisonOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterComparisonOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitComparisonOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitComparisonOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonOperatorContext comparisonOperator() throws RecognitionException {
		ComparisonOperatorContext _localctx = new ComparisonOperatorContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_comparisonOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(547);
			_la = _input.LA(1);
			if ( !(((((_la - 63)) & ~0x3f) == 0 && ((1L << (_la - 63)) & ((1L << (EQ - 63)) | (1L << (NEQ - 63)) | (1L << (LT - 63)) | (1L << (LTE - 63)) | (1L << (GT - 63)) | (1L << (GTE - 63)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanValueContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(SparrowSQLParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(SparrowSQLParser.FALSE, 0); }
		public BooleanValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterBooleanValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitBooleanValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitBooleanValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanValueContext booleanValue() throws RecognitionException {
		BooleanValueContext _localctx = new BooleanValueContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_booleanValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(549);
			_la = _input.LA(1);
			if ( !(_la==FALSE || _la==TRUE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifiedNameContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterQualifiedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitQualifiedName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitQualifiedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_qualifiedName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(551);
			identifier();
			setState(556);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(552);
					match(T__3);
					setState(553);
					identifier();
					}
					} 
				}
				setState(558);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
	 
		public IdentifierContext() { }
		public void copyFrom(IdentifierContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BackQuotedIdentifierContext extends IdentifierContext {
		public TerminalNode BACKQUOTED_IDENTIFIER() { return getToken(SparrowSQLParser.BACKQUOTED_IDENTIFIER, 0); }
		public BackQuotedIdentifierContext(IdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterBackQuotedIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitBackQuotedIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitBackQuotedIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QuotedIdentifierContext extends IdentifierContext {
		public TerminalNode QUOTED_IDENTIFIER() { return getToken(SparrowSQLParser.QUOTED_IDENTIFIER, 0); }
		public QuotedIdentifierContext(IdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterQuotedIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitQuotedIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitQuotedIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DigitIdentifierContext extends IdentifierContext {
		public TerminalNode DIGIT_IDENTIFIER() { return getToken(SparrowSQLParser.DIGIT_IDENTIFIER, 0); }
		public DigitIdentifierContext(IdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterDigitIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitDigitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitDigitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnquotedIdentifierContext extends IdentifierContext {
		public TerminalNode IDENTIFIER() { return getToken(SparrowSQLParser.IDENTIFIER, 0); }
		public UnquotedIdentifierContext(IdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterUnquotedIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitUnquotedIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitUnquotedIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_identifier);
		try {
			setState(563);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new UnquotedIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(559);
				match(IDENTIFIER);
				}
				break;
			case QUOTED_IDENTIFIER:
				_localctx = new QuotedIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(560);
				match(QUOTED_IDENTIFIER);
				}
				break;
			case BACKQUOTED_IDENTIFIER:
				_localctx = new BackQuotedIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(561);
				match(BACKQUOTED_IDENTIFIER);
				}
				break;
			case DIGIT_IDENTIFIER:
				_localctx = new DigitIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(562);
				match(DIGIT_IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
	 
		public NumberContext() { }
		public void copyFrom(NumberContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DecimalLiteralContext extends NumberContext {
		public TerminalNode DECIMAL_VALUE() { return getToken(SparrowSQLParser.DECIMAL_VALUE, 0); }
		public DecimalLiteralContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterDecimalLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitDecimalLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitDecimalLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DoubleLiteralContext extends NumberContext {
		public TerminalNode DOUBLE_VALUE() { return getToken(SparrowSQLParser.DOUBLE_VALUE, 0); }
		public DoubleLiteralContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterDoubleLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitDoubleLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitDoubleLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntegerLiteralContext extends NumberContext {
		public TerminalNode INTEGER_VALUE() { return getToken(SparrowSQLParser.INTEGER_VALUE, 0); }
		public IntegerLiteralContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).enterIntegerLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparrowSQLListener ) ((SparrowSQLListener)listener).exitIntegerLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SparrowSQLVisitor) return ((SparrowSQLVisitor<? extends T>)visitor).visitIntegerLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_number);
		try {
			setState(568);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECIMAL_VALUE:
				_localctx = new DecimalLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(565);
				match(DECIMAL_VALUE);
				}
				break;
			case DOUBLE_VALUE:
				_localctx = new DoubleLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(566);
				match(DOUBLE_VALUE);
				}
				break;
			case INTEGER_VALUE:
				_localctx = new IntegerLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(567);
				match(INTEGER_VALUE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 16:
			return relation_sempred((RelationContext)_localctx, predIndex);
		case 25:
			return booleanExpression_sempred((BooleanExpressionContext)_localctx, predIndex);
		case 28:
			return valueExpression_sempred((ValueExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean relation_sempred(RelationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean booleanExpression_sempred(BooleanExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean valueExpression_sempred(ValueExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\\\u023b\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001V\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u0001]\b\u0001\n\u0001\f\u0001`\t\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001e\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001k\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001r\b\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001{\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001\u0081\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"\u008c\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001\u0093\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u009d\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"\u00a4\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001\u00ac\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u00b4\b\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001\u00b8\b\u0001\u0001\u0002\u0001\u0002\u0003\u0002"+
		"\u00bc\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"\u00c2\b\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u00c6\b\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u00d3"+
		"\b\u0006\n\u0006\f\u0006\u00d6\t\u0006\u0003\u0006\u00d8\b\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00dd\b\u0006\u0003\u0006\u00df"+
		"\b\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00e3\b\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005"+
		"\b\u00ee\b\b\n\b\f\b\u00f1\t\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b"+
		"\u00f7\b\b\u0001\t\u0001\t\u0003\t\u00fb\b\t\u0001\n\u0001\n\u0003\n\u00ff"+
		"\b\n\u0001\n\u0001\n\u0001\n\u0005\n\u0104\b\n\n\n\f\n\u0107\t\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0005\n\u010d\b\n\n\n\f\n\u0110\t\n\u0003\n"+
		"\u0112\b\n\u0001\n\u0001\n\u0003\n\u0116\b\n\u0001\n\u0001\n\u0001\n\u0003"+
		"\n\u011b\b\n\u0001\u000b\u0003\u000b\u011e\b\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0005\u000b\u0123\b\u000b\n\u000b\f\u000b\u0126\t\u000b\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u012e\b\r\n\r\f\r\u0131"+
		"\t\r\u0003\r\u0133\b\r\u0001\r\u0001\r\u0003\r\u0137\b\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0003\u000f\u013d\b\u000f\u0001\u000f\u0003"+
		"\u000f\u0140\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0003\u000f\u0147\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0003\u0010\u015a\b\u0010\u0005\u0010\u015c\b\u0010"+
		"\n\u0010\f\u0010\u015f\t\u0010\u0001\u0011\u0003\u0011\u0162\b\u0011\u0001"+
		"\u0011\u0001\u0011\u0003\u0011\u0166\b\u0011\u0001\u0011\u0001\u0011\u0003"+
		"\u0011\u016a\b\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u016e\b\u0011"+
		"\u0003\u0011\u0170\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0003\u0013\u017c\b\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"+
		"\u0003\u0015\u0182\b\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0186\b"+
		"\u0015\u0003\u0015\u0188\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0005\u0016\u018e\b\u0016\n\u0016\f\u0016\u0191\t\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u019e\b\u0017"+
		"\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0003\u0019\u01a6\b\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0005\u0019\u01ae\b\u0019\n\u0019\f\u0019\u01b1"+
		"\t\u0019\u0001\u001a\u0001\u001a\u0003\u001a\u01b5\b\u001a\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u01bb\b\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b"+
		"\u01c3\b\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0005\u001b\u01ca\b\u001b\n\u001b\f\u001b\u01cd\t\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0003\u001b\u01d2\b\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u01db"+
		"\b\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u01e0\b\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u01e5\b\u001b\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u01eb\b\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0005\u001c\u01f6\b\u001c\n\u001c\f\u001c\u01f9"+
		"\t\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0004\u001d\u0208\b\u001d\u000b\u001d\f\u001d\u0209"+
		"\u0001\u001d\u0001\u001d\u0003\u001d\u020e\b\u001d\u0001\u001e\u0001\u001e"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0005\u001f"+
		"\u0217\b\u001f\n\u001f\f\u001f\u021a\t\u001f\u0001\u001f\u0001\u001f\u0003"+
		"\u001f\u021e\b\u001f\u0001 \u0001 \u0003 \u0222\b \u0001!\u0001!\u0001"+
		"\"\u0001\"\u0001#\u0001#\u0001#\u0005#\u022b\b#\n#\f#\u022e\t#\u0001$"+
		"\u0001$\u0001$\u0001$\u0003$\u0234\b$\u0001%\u0001%\u0001%\u0003%\u0239"+
		"\b%\u0001%\u0000\u0003 28&\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJ\u0000\b\u0001"+
		"\u000034\u0002\u0000\u000b\u000b\u0015\u0015\u0002\u0000\u0007\u0007\u0016"+
		"\u0016\u0002\u0000\f\f66\u0001\u0000EF\u0001\u0000GI\u0001\u0000?D\u0002"+
		"\u0000\u001b\u001b;;\u027a\u0000L\u0001\u0000\u0000\u0000\u0002\u00b7"+
		"\u0001\u0000\u0000\u0000\u0004\u00bb\u0001\u0000\u0000\u0000\u0006\u00bd"+
		"\u0001\u0000\u0000\u0000\b\u00c7\u0001\u0000\u0000\u0000\n\u00ca\u0001"+
		"\u0000\u0000\u0000\f\u00cc\u0001\u0000\u0000\u0000\u000e\u00e4\u0001\u0000"+
		"\u0000\u0000\u0010\u00f6\u0001\u0000\u0000\u0000\u0012\u00f8\u0001\u0000"+
		"\u0000\u0000\u0014\u00fc\u0001\u0000\u0000\u0000\u0016\u011d\u0001\u0000"+
		"\u0000\u0000\u0018\u0127\u0001\u0000\u0000\u0000\u001a\u0136\u0001\u0000"+
		"\u0000\u0000\u001c\u0138\u0001\u0000\u0000\u0000\u001e\u0146\u0001\u0000"+
		"\u0000\u0000 \u0148\u0001\u0000\u0000\u0000\"\u016f\u0001\u0000\u0000"+
		"\u0000$\u0171\u0001\u0000\u0000\u0000&\u0174\u0001\u0000\u0000\u0000("+
		"\u017d\u0001\u0000\u0000\u0000*\u017f\u0001\u0000\u0000\u0000,\u0189\u0001"+
		"\u0000\u0000\u0000.\u019d\u0001\u0000\u0000\u00000\u019f\u0001\u0000\u0000"+
		"\u00002\u01a5\u0001\u0000\u0000\u00004\u01b2\u0001\u0000\u0000\u00006"+
		"\u01e4\u0001\u0000\u0000\u00008\u01ea\u0001\u0000\u0000\u0000:\u020d\u0001"+
		"\u0000\u0000\u0000<\u020f\u0001\u0000\u0000\u0000>\u0211\u0001\u0000\u0000"+
		"\u0000@\u0221\u0001\u0000\u0000\u0000B\u0223\u0001\u0000\u0000\u0000D"+
		"\u0225\u0001\u0000\u0000\u0000F\u0227\u0001\u0000\u0000\u0000H\u0233\u0001"+
		"\u0000\u0000\u0000J\u0238\u0001\u0000\u0000\u0000LM\u0003\u0002\u0001"+
		"\u0000MN\u0005\u0000\u0000\u0001N\u0001\u0001\u0000\u0000\u0000O\u00b8"+
		"\u0003\n\u0005\u0000PQ\u0005\u0012\u0000\u0000QU\u00057\u0000\u0000RS"+
		"\u0005 \u0000\u0000ST\u0005*\u0000\u0000TV\u0005\u001a\u0000\u0000UR\u0001"+
		"\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000"+
		"WX\u0003F#\u0000XY\u0005\u0001\u0000\u0000Y^\u0003\u0004\u0002\u0000Z"+
		"[\u0005\u0002\u0000\u0000[]\u0003\u0004\u0002\u0000\\Z\u0001\u0000\u0000"+
		"\u0000]`\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000"+
		"\u0000\u0000_a\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000ad\u0005"+
		"\u0003\u0000\u0000bc\u0005\u0011\u0000\u0000ce\u0003<\u001e\u0000db\u0001"+
		"\u0000\u0000\u0000de\u0001\u0000\u0000\u0000e\u00b8\u0001\u0000\u0000"+
		"\u0000fg\u0005\u0017\u0000\u0000gj\u00057\u0000\u0000hi\u0005 \u0000\u0000"+
		"ik\u0005\u001a\u0000\u0000jh\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000"+
		"\u0000kl\u0001\u0000\u0000\u0000l\u00b8\u0003F#\u0000mn\u0005#\u0000\u0000"+
		"no\u0005$\u0000\u0000oq\u0003F#\u0000pr\u0003,\u0016\u0000qp\u0001\u0000"+
		"\u0000\u0000qr\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000st\u0003"+
		"\n\u0005\u0000t\u00b8\u0001\u0000\u0000\u0000uv\u0005\u0014\u0000\u0000"+
		"vw\u0005\u001c\u0000\u0000wz\u0003F#\u0000xy\u0005>\u0000\u0000y{\u0003"+
		"2\u0019\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{\u00b8"+
		"\u0001\u0000\u0000\u0000|}\u0005\b\u0000\u0000}\u0080\u00057\u0000\u0000"+
		"~\u007f\u0005 \u0000\u0000\u007f\u0081\u0005\u001a\u0000\u0000\u0080~"+
		"\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0082"+
		"\u0001\u0000\u0000\u0000\u0082\u0083\u0003F#\u0000\u0083\u0084\u00051"+
		"\u0000\u0000\u0084\u0085\u0005:\u0000\u0000\u0085\u0086\u0003F#\u0000"+
		"\u0086\u00b8\u0001\u0000\u0000\u0000\u0087\u0088\u0005\b\u0000\u0000\u0088"+
		"\u008b\u00057\u0000\u0000\u0089\u008a\u0005 \u0000\u0000\u008a\u008c\u0005"+
		"\u001a\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008b\u008c\u0001"+
		"\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u008e\u0003"+
		"F#\u0000\u008e\u008f\u00051\u0000\u0000\u008f\u0092\u0005\u0010\u0000"+
		"\u0000\u0090\u0091\u0005 \u0000\u0000\u0091\u0093\u0005\u001a\u0000\u0000"+
		"\u0092\u0090\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000\u0000\u0000"+
		"\u0093\u0094\u0001\u0000\u0000\u0000\u0094\u0095\u0003H$\u0000\u0095\u0096"+
		"\u0005:\u0000\u0000\u0096\u0097\u0003H$\u0000\u0097\u00b8\u0001\u0000"+
		"\u0000\u0000\u0098\u0099\u0005\b\u0000\u0000\u0099\u009c\u00057\u0000"+
		"\u0000\u009a\u009b\u0005 \u0000\u0000\u009b\u009d\u0005\u001a\u0000\u0000"+
		"\u009c\u009a\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000"+
		"\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u009f\u0003F#\u0000\u009f\u00a0"+
		"\u0005\u0017\u0000\u0000\u00a0\u00a3\u0005\u0010\u0000\u0000\u00a1\u00a2"+
		"\u0005 \u0000\u0000\u00a2\u00a4\u0005\u001a\u0000\u0000\u00a3\u00a1\u0001"+
		"\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a6\u0003F#\u0000\u00a6\u00b8\u0001\u0000\u0000"+
		"\u0000\u00a7\u00a8\u0005\b\u0000\u0000\u00a8\u00ab\u00057\u0000\u0000"+
		"\u00a9\u00aa\u0005 \u0000\u0000\u00aa\u00ac\u0005\u001a\u0000\u0000\u00ab"+
		"\u00a9\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac"+
		"\u00ad\u0001\u0000\u0000\u0000\u00ad\u00ae\u0003F#\u0000\u00ae\u00af\u0005"+
		"\u0006\u0000\u0000\u00af\u00b3\u0005\u0010\u0000\u0000\u00b0\u00b1\u0005"+
		" \u0000\u0000\u00b1\u00b2\u0005*\u0000\u0000\u00b2\u00b4\u0005\u001a\u0000"+
		"\u0000\u00b3\u00b0\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000"+
		"\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b5\u00b6\u0003\u0006\u0003"+
		"\u0000\u00b6\u00b8\u0001\u0000\u0000\u0000\u00b7O\u0001\u0000\u0000\u0000"+
		"\u00b7P\u0001\u0000\u0000\u0000\u00b7f\u0001\u0000\u0000\u0000\u00b7m"+
		"\u0001\u0000\u0000\u0000\u00b7u\u0001\u0000\u0000\u0000\u00b7|\u0001\u0000"+
		"\u0000\u0000\u00b7\u0087\u0001\u0000\u0000\u0000\u00b7\u0098\u0001\u0000"+
		"\u0000\u0000\u00b7\u00a7\u0001\u0000\u0000\u0000\u00b8\u0003\u0001\u0000"+
		"\u0000\u0000\u00b9\u00bc\u0003\u0006\u0003\u0000\u00ba\u00bc\u0003\b\u0004"+
		"\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bb\u00ba\u0001\u0000\u0000"+
		"\u0000\u00bc\u0005\u0001\u0000\u0000\u0000\u00bd\u00be\u0003H$\u0000\u00be"+
		"\u00c1\u0003>\u001f\u0000\u00bf\u00c0\u0005*\u0000\u0000\u00c0\u00c2\u0005"+
		"+\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000"+
		"\u0000\u0000\u00c2\u00c5\u0001\u0000\u0000\u0000\u00c3\u00c4\u0005\u0011"+
		"\u0000\u0000\u00c4\u00c6\u0003<\u001e\u0000\u00c5\u00c3\u0001\u0000\u0000"+
		"\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6\u0007\u0001\u0000\u0000"+
		"\u0000\u00c7\u00c8\u0005(\u0000\u0000\u00c8\u00c9\u0003F#\u0000\u00c9"+
		"\t\u0001\u0000\u0000\u0000\u00ca\u00cb\u0003\f\u0006\u0000\u00cb\u000b"+
		"\u0001\u0000\u0000\u0000\u00cc\u00d7\u0003\u000e\u0007\u0000\u00cd\u00ce"+
		"\u0005/\u0000\u0000\u00ce\u00cf\u0005\u000e\u0000\u0000\u00cf\u00d4\u0003"+
		"\u0012\t\u0000\u00d0\u00d1\u0005\u0002\u0000\u0000\u00d1\u00d3\u0003\u0012"+
		"\t\u0000\u00d2\u00d0\u0001\u0000\u0000\u0000\u00d3\u00d6\u0001\u0000\u0000"+
		"\u0000\u00d4\u00d2\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000"+
		"\u0000\u00d5\u00d8\u0001\u0000\u0000\u0000\u00d6\u00d4\u0001\u0000\u0000"+
		"\u0000\u00d7\u00cd\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000"+
		"\u0000\u00d8\u00de\u0001\u0000\u0000\u0000\u00d9\u00da\u0005,\u0000\u0000"+
		"\u00da\u00dc\u0005N\u0000\u0000\u00db\u00dd\u0007\u0000\u0000\u0000\u00dc"+
		"\u00db\u0001\u0000\u0000\u0000\u00dc\u00dd\u0001\u0000\u0000\u0000\u00dd"+
		"\u00df\u0001\u0000\u0000\u0000\u00de\u00d9\u0001\u0000\u0000\u0000\u00de"+
		"\u00df\u0001\u0000\u0000\u0000\u00df\u00e2\u0001\u0000\u0000\u0000\u00e0"+
		"\u00e1\u0005\'\u0000\u0000\u00e1\u00e3\u0005N\u0000\u0000\u00e2\u00e0"+
		"\u0001\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3\r\u0001"+
		"\u0000\u0000\u0000\u00e4\u00e5\u0003\u0010\b\u0000\u00e5\u000f\u0001\u0000"+
		"\u0000\u0000\u00e6\u00f7\u0003\u0014\n\u0000\u00e7\u00e8\u00057\u0000"+
		"\u0000\u00e8\u00f7\u0003F#\u0000\u00e9\u00ea\u0005<\u0000\u0000\u00ea"+
		"\u00ef\u00030\u0018\u0000\u00eb\u00ec\u0005\u0002\u0000\u0000\u00ec\u00ee"+
		"\u00030\u0018\u0000\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ee\u00f1\u0001"+
		"\u0000\u0000\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000\u00ef\u00f0\u0001"+
		"\u0000\u0000\u0000\u00f0\u00f7\u0001\u0000\u0000\u0000\u00f1\u00ef\u0001"+
		"\u0000\u0000\u0000\u00f2\u00f3\u0005\u0001\u0000\u0000\u00f3\u00f4\u0003"+
		"\f\u0006\u0000\u00f4\u00f5\u0005\u0003\u0000\u0000\u00f5\u00f7\u0001\u0000"+
		"\u0000\u0000\u00f6\u00e6\u0001\u0000\u0000\u0000\u00f6\u00e7\u0001\u0000"+
		"\u0000\u0000\u00f6\u00e9\u0001\u0000\u0000\u0000\u00f6\u00f2\u0001\u0000"+
		"\u0000\u0000\u00f7\u0011\u0001\u0000\u0000\u0000\u00f8\u00fa\u00030\u0018"+
		"\u0000\u00f9\u00fb\u0007\u0001\u0000\u0000\u00fa\u00f9\u0001\u0000\u0000"+
		"\u0000\u00fa\u00fb\u0001\u0000\u0000\u0000\u00fb\u0013\u0001\u0000\u0000"+
		"\u0000\u00fc\u00fe\u00055\u0000\u0000\u00fd\u00ff\u0003\u001c\u000e\u0000"+
		"\u00fe\u00fd\u0001\u0000\u0000\u0000\u00fe\u00ff\u0001\u0000\u0000\u0000"+
		"\u00ff\u0100\u0001\u0000\u0000\u0000\u0100\u0105\u0003\u001e\u000f\u0000"+
		"\u0101\u0102\u0005\u0002\u0000\u0000\u0102\u0104\u0003\u001e\u000f\u0000"+
		"\u0103\u0101\u0001\u0000\u0000\u0000\u0104\u0107\u0001\u0000\u0000\u0000"+
		"\u0105\u0103\u0001\u0000\u0000\u0000\u0105\u0106\u0001\u0000\u0000\u0000"+
		"\u0106\u0111\u0001\u0000\u0000\u0000\u0107\u0105\u0001\u0000\u0000\u0000"+
		"\u0108\u0109\u0005\u001c\u0000\u0000\u0109\u010e\u0003 \u0010\u0000\u010a"+
		"\u010b\u0005\u0002\u0000\u0000\u010b\u010d\u0003 \u0010\u0000\u010c\u010a"+
		"\u0001\u0000\u0000\u0000\u010d\u0110\u0001\u0000\u0000\u0000\u010e\u010c"+
		"\u0001\u0000\u0000\u0000\u010e\u010f\u0001\u0000\u0000\u0000\u010f\u0112"+
		"\u0001\u0000\u0000\u0000\u0110\u010e\u0001\u0000\u0000\u0000\u0111\u0108"+
		"\u0001\u0000\u0000\u0000\u0111\u0112\u0001\u0000\u0000\u0000\u0112\u0115"+
		"\u0001\u0000\u0000\u0000\u0113\u0114\u0005>\u0000\u0000\u0114\u0116\u0003"+
		"2\u0019\u0000\u0115\u0113\u0001\u0000\u0000\u0000\u0115\u0116\u0001\u0000"+
		"\u0000\u0000\u0116\u011a\u0001\u0000\u0000\u0000\u0117\u0118\u0005\u001e"+
		"\u0000\u0000\u0118\u0119\u0005\u000e\u0000\u0000\u0119\u011b\u0003\u0016"+
		"\u000b\u0000\u011a\u0117\u0001\u0000\u0000\u0000\u011a\u011b\u0001\u0000"+
		"\u0000\u0000\u011b\u0015\u0001\u0000\u0000\u0000\u011c\u011e\u0003\u001c"+
		"\u000e\u0000\u011d\u011c\u0001\u0000\u0000\u0000\u011d\u011e\u0001\u0000"+
		"\u0000\u0000\u011e\u011f\u0001\u0000\u0000\u0000\u011f\u0124\u0003\u0018"+
		"\f\u0000\u0120\u0121\u0005\u0002\u0000\u0000\u0121\u0123\u0003\u0018\f"+
		"\u0000\u0122\u0120\u0001\u0000\u0000\u0000\u0123\u0126\u0001\u0000\u0000"+
		"\u0000\u0124\u0122\u0001\u0000\u0000\u0000\u0124\u0125\u0001\u0000\u0000"+
		"\u0000\u0125\u0017\u0001\u0000\u0000\u0000\u0126\u0124\u0001\u0000\u0000"+
		"\u0000\u0127\u0128\u0003\u001a\r\u0000\u0128\u0019\u0001\u0000\u0000\u0000"+
		"\u0129\u0132\u0005\u0001\u0000\u0000\u012a\u012f\u00030\u0018\u0000\u012b"+
		"\u012c\u0005\u0002\u0000\u0000\u012c\u012e\u00030\u0018\u0000\u012d\u012b"+
		"\u0001\u0000\u0000\u0000\u012e\u0131\u0001\u0000\u0000\u0000\u012f\u012d"+
		"\u0001\u0000\u0000\u0000\u012f\u0130\u0001\u0000\u0000\u0000\u0130\u0133"+
		"\u0001\u0000\u0000\u0000\u0131\u012f\u0001\u0000\u0000\u0000\u0132\u012a"+
		"\u0001\u0000\u0000\u0000\u0132\u0133\u0001\u0000\u0000\u0000\u0133\u0134"+
		"\u0001\u0000\u0000\u0000\u0134\u0137\u0005\u0003\u0000\u0000\u0135\u0137"+
		"\u00030\u0018\u0000\u0136\u0129\u0001\u0000\u0000\u0000\u0136\u0135\u0001"+
		"\u0000\u0000\u0000\u0137\u001b\u0001\u0000\u0000\u0000\u0138\u0139\u0007"+
		"\u0002\u0000\u0000\u0139\u001d\u0001\u0000\u0000\u0000\u013a\u013f\u0003"+
		"0\u0018\u0000\u013b\u013d\u0005\n\u0000\u0000\u013c\u013b\u0001\u0000"+
		"\u0000\u0000\u013c\u013d\u0001\u0000\u0000\u0000\u013d\u013e\u0001\u0000"+
		"\u0000\u0000\u013e\u0140\u0003H$\u0000\u013f\u013c\u0001\u0000\u0000\u0000"+
		"\u013f\u0140\u0001\u0000\u0000\u0000\u0140\u0147\u0001\u0000\u0000\u0000"+
		"\u0141\u0142\u0003F#\u0000\u0142\u0143\u0005\u0004\u0000\u0000\u0143\u0144"+
		"\u0005G\u0000\u0000\u0144\u0147\u0001\u0000\u0000\u0000\u0145\u0147\u0005"+
		"G\u0000\u0000\u0146\u013a\u0001\u0000\u0000\u0000\u0146\u0141\u0001\u0000"+
		"\u0000\u0000\u0146\u0145\u0001\u0000\u0000\u0000\u0147\u001f\u0001\u0000"+
		"\u0000\u0000\u0148\u0149\u0006\u0010\uffff\uffff\u0000\u0149\u014a\u0003"+
		"&\u0013\u0000\u014a\u015d\u0001\u0000\u0000\u0000\u014b\u0159\n\u0002"+
		"\u0000\u0000\u014c\u014d\u0005\u0013\u0000\u0000\u014d\u014e\u0005\u001f"+
		"\u0000\u0000\u014e\u015a\u0003&\u0013\u0000\u014f\u0150\u0003\"\u0011"+
		"\u0000\u0150\u0151\u0005\u001f\u0000\u0000\u0151\u0152\u0003 \u0010\u0000"+
		"\u0152\u0153\u0003$\u0012\u0000\u0153\u015a\u0001\u0000\u0000\u0000\u0154"+
		"\u0155\u0005)\u0000\u0000\u0155\u0156\u0003\"\u0011\u0000\u0156\u0157"+
		"\u0005\u001f\u0000\u0000\u0157\u0158\u0003&\u0013\u0000\u0158\u015a\u0001"+
		"\u0000\u0000\u0000\u0159\u014c\u0001\u0000\u0000\u0000\u0159\u014f\u0001"+
		"\u0000\u0000\u0000\u0159\u0154\u0001\u0000\u0000\u0000\u015a\u015c\u0001"+
		"\u0000\u0000\u0000\u015b\u014b\u0001\u0000\u0000\u0000\u015c\u015f\u0001"+
		"\u0000\u0000\u0000\u015d\u015b\u0001\u0000\u0000\u0000\u015d\u015e\u0001"+
		"\u0000\u0000\u0000\u015e!\u0001\u0000\u0000\u0000\u015f\u015d\u0001\u0000"+
		"\u0000\u0000\u0160\u0162\u0005\"\u0000\u0000\u0161\u0160\u0001\u0000\u0000"+
		"\u0000\u0161\u0162\u0001\u0000\u0000\u0000\u0162\u0170\u0001\u0000\u0000"+
		"\u0000\u0163\u0165\u0005&\u0000\u0000\u0164\u0166\u00050\u0000\u0000\u0165"+
		"\u0164\u0001\u0000\u0000\u0000\u0165\u0166\u0001\u0000\u0000\u0000\u0166"+
		"\u0170\u0001\u0000\u0000\u0000\u0167\u0169\u00052\u0000\u0000\u0168\u016a"+
		"\u00050\u0000\u0000\u0169\u0168\u0001\u0000\u0000\u0000\u0169\u016a\u0001"+
		"\u0000\u0000\u0000\u016a\u0170\u0001\u0000\u0000\u0000\u016b\u016d\u0005"+
		"\u001d\u0000\u0000\u016c\u016e\u00050\u0000\u0000\u016d\u016c\u0001\u0000"+
		"\u0000\u0000\u016d\u016e\u0001\u0000\u0000\u0000\u016e\u0170\u0001\u0000"+
		"\u0000\u0000\u016f\u0161\u0001\u0000\u0000\u0000\u016f\u0163\u0001\u0000"+
		"\u0000\u0000\u016f\u0167\u0001\u0000\u0000\u0000\u016f\u016b\u0001\u0000"+
		"\u0000\u0000\u0170#\u0001\u0000\u0000\u0000\u0171\u0172\u0005-\u0000\u0000"+
		"\u0172\u0173\u00032\u0019\u0000\u0173%\u0001\u0000\u0000\u0000\u0174\u017b"+
		"\u0003*\u0015\u0000\u0175\u0176\u00058\u0000\u0000\u0176\u0177\u0003("+
		"\u0014\u0000\u0177\u0178\u0005\u0001\u0000\u0000\u0178\u0179\u00030\u0018"+
		"\u0000\u0179\u017a\u0005\u0003\u0000\u0000\u017a\u017c\u0001\u0000\u0000"+
		"\u0000\u017b\u0175\u0001\u0000\u0000\u0000\u017b\u017c\u0001\u0000\u0000"+
		"\u0000\u017c\'\u0001\u0000\u0000\u0000\u017d\u017e\u0007\u0003\u0000\u0000"+
		"\u017e)\u0001\u0000\u0000\u0000\u017f\u0187\u0003.\u0017\u0000\u0180\u0182"+
		"\u0005\n\u0000\u0000\u0181\u0180\u0001\u0000\u0000\u0000\u0181\u0182\u0001"+
		"\u0000\u0000\u0000\u0182\u0183\u0001\u0000\u0000\u0000\u0183\u0185\u0003"+
		"H$\u0000\u0184\u0186\u0003,\u0016\u0000\u0185\u0184\u0001\u0000\u0000"+
		"\u0000\u0185\u0186\u0001\u0000\u0000\u0000\u0186\u0188\u0001\u0000\u0000"+
		"\u0000\u0187\u0181\u0001\u0000\u0000\u0000\u0187\u0188\u0001\u0000\u0000"+
		"\u0000\u0188+\u0001\u0000\u0000\u0000\u0189\u018a\u0005\u0001\u0000\u0000"+
		"\u018a\u018f\u0003H$\u0000\u018b\u018c\u0005\u0002\u0000\u0000\u018c\u018e"+
		"\u0003H$\u0000\u018d\u018b\u0001\u0000\u0000\u0000\u018e\u0191\u0001\u0000"+
		"\u0000\u0000\u018f\u018d\u0001\u0000\u0000\u0000\u018f\u0190\u0001\u0000"+
		"\u0000\u0000\u0190\u0192\u0001\u0000\u0000\u0000\u0191\u018f\u0001\u0000"+
		"\u0000\u0000\u0192\u0193\u0005\u0003\u0000\u0000\u0193-\u0001\u0000\u0000"+
		"\u0000\u0194\u019e\u0003F#\u0000\u0195\u0196\u0005\u0001\u0000\u0000\u0196"+
		"\u0197\u0003\n\u0005\u0000\u0197\u0198\u0005\u0003\u0000\u0000\u0198\u019e"+
		"\u0001\u0000\u0000\u0000\u0199\u019a\u0005\u0001\u0000\u0000\u019a\u019b"+
		"\u0003 \u0010\u0000\u019b\u019c\u0005\u0003\u0000\u0000\u019c\u019e\u0001"+
		"\u0000\u0000\u0000\u019d\u0194\u0001\u0000\u0000\u0000\u019d\u0195\u0001"+
		"\u0000\u0000\u0000\u019d\u0199\u0001\u0000\u0000\u0000\u019e/\u0001\u0000"+
		"\u0000\u0000\u019f\u01a0\u00032\u0019\u0000\u01a01\u0001\u0000\u0000\u0000"+
		"\u01a1\u01a2\u0006\u0019\uffff\uffff\u0000\u01a2\u01a6\u00034\u001a\u0000"+
		"\u01a3\u01a4\u0005*\u0000\u0000\u01a4\u01a6\u00032\u0019\u0003\u01a5\u01a1"+
		"\u0001\u0000\u0000\u0000\u01a5\u01a3\u0001\u0000\u0000\u0000\u01a6\u01af"+
		"\u0001\u0000\u0000\u0000\u01a7\u01a8\n\u0002\u0000\u0000\u01a8\u01a9\u0005"+
		"\t\u0000\u0000\u01a9\u01ae\u00032\u0019\u0003\u01aa\u01ab\n\u0001\u0000"+
		"\u0000\u01ab\u01ac\u0005.\u0000\u0000\u01ac\u01ae\u00032\u0019\u0002\u01ad"+
		"\u01a7\u0001\u0000\u0000\u0000\u01ad\u01aa\u0001\u0000\u0000\u0000\u01ae"+
		"\u01b1\u0001\u0000\u0000\u0000\u01af\u01ad\u0001\u0000\u0000\u0000\u01af"+
		"\u01b0\u0001\u0000\u0000\u0000\u01b03\u0001\u0000\u0000\u0000\u01b1\u01af"+
		"\u0001\u0000\u0000\u0000\u01b2\u01b4\u00038\u001c\u0000\u01b3\u01b5\u0003"+
		"6\u001b\u0000\u01b4\u01b3\u0001\u0000\u0000\u0000\u01b4\u01b5\u0001\u0000"+
		"\u0000\u0000\u01b55\u0001\u0000\u0000\u0000\u01b6\u01b7\u0003B!\u0000"+
		"\u01b7\u01b8\u00038\u001c\u0000\u01b8\u01e5\u0001\u0000\u0000\u0000\u01b9"+
		"\u01bb\u0005*\u0000\u0000\u01ba\u01b9\u0001\u0000\u0000\u0000\u01ba\u01bb"+
		"\u0001\u0000\u0000\u0000\u01bb\u01bc\u0001\u0000\u0000\u0000\u01bc\u01bd"+
		"\u0005\r\u0000\u0000\u01bd\u01be\u00038\u001c\u0000\u01be\u01bf\u0005"+
		"\t\u0000\u0000\u01bf\u01c0\u00038\u001c\u0000\u01c0\u01e5\u0001\u0000"+
		"\u0000\u0000\u01c1\u01c3\u0005*\u0000\u0000\u01c2\u01c1\u0001\u0000\u0000"+
		"\u0000\u01c2\u01c3\u0001\u0000\u0000\u0000\u01c3\u01c4\u0001\u0000\u0000"+
		"\u0000\u01c4\u01c5\u0005!\u0000\u0000\u01c5\u01c6\u0005\u0001\u0000\u0000"+
		"\u01c6\u01cb\u00030\u0018\u0000\u01c7\u01c8\u0005\u0002\u0000\u0000\u01c8"+
		"\u01ca\u00030\u0018\u0000\u01c9\u01c7\u0001\u0000\u0000\u0000\u01ca\u01cd"+
		"\u0001\u0000\u0000\u0000\u01cb\u01c9\u0001\u0000\u0000\u0000\u01cb\u01cc"+
		"\u0001\u0000\u0000\u0000\u01cc\u01ce\u0001\u0000\u0000\u0000\u01cd\u01cb"+
		"\u0001\u0000\u0000\u0000\u01ce\u01cf\u0005\u0003\u0000\u0000\u01cf\u01e5"+
		"\u0001\u0000\u0000\u0000\u01d0\u01d2\u0005*\u0000\u0000\u01d1\u01d0\u0001"+
		"\u0000\u0000\u0000\u01d1\u01d2\u0001\u0000\u0000\u0000\u01d2\u01d3\u0001"+
		"\u0000\u0000\u0000\u01d3\u01d4\u0005!\u0000\u0000\u01d4\u01d5\u0005\u0001"+
		"\u0000\u0000\u01d5\u01d6\u0003\n\u0005\u0000\u01d6\u01d7\u0005\u0003\u0000"+
		"\u0000\u01d7\u01e5\u0001\u0000\u0000\u0000\u01d8\u01da\u0005%\u0000\u0000"+
		"\u01d9\u01db\u0005*\u0000\u0000\u01da\u01d9\u0001\u0000\u0000\u0000\u01da"+
		"\u01db\u0001\u0000\u0000\u0000\u01db\u01dc\u0001\u0000\u0000\u0000\u01dc"+
		"\u01e5\u0005+\u0000\u0000\u01dd\u01df\u0005%\u0000\u0000\u01de\u01e0\u0005"+
		"*\u0000\u0000\u01df\u01de\u0001\u0000\u0000\u0000\u01df\u01e0\u0001\u0000"+
		"\u0000\u0000\u01e0\u01e1\u0001\u0000\u0000\u0000\u01e1\u01e2\u0005\u0016"+
		"\u0000\u0000\u01e2\u01e3\u0005\u001c\u0000\u0000\u01e3\u01e5\u00038\u001c"+
		"\u0000\u01e4\u01b6\u0001\u0000\u0000\u0000\u01e4\u01ba\u0001\u0000\u0000"+
		"\u0000\u01e4\u01c2\u0001\u0000\u0000\u0000\u01e4\u01d1\u0001\u0000\u0000"+
		"\u0000\u01e4\u01d8\u0001\u0000\u0000\u0000\u01e4\u01dd\u0001\u0000\u0000"+
		"\u0000\u01e57\u0001\u0000\u0000\u0000\u01e6\u01e7\u0006\u001c\uffff\uffff"+
		"\u0000\u01e7\u01eb\u0003:\u001d\u0000\u01e8\u01e9\u0007\u0004\u0000\u0000"+
		"\u01e9\u01eb\u00038\u001c\u0004\u01ea\u01e6\u0001\u0000\u0000\u0000\u01ea"+
		"\u01e8\u0001\u0000\u0000\u0000\u01eb\u01f7\u0001\u0000\u0000\u0000\u01ec"+
		"\u01ed\n\u0003\u0000\u0000\u01ed\u01ee\u0007\u0005\u0000\u0000\u01ee\u01f6"+
		"\u00038\u001c\u0004\u01ef\u01f0\n\u0002\u0000\u0000\u01f0\u01f1\u0007"+
		"\u0004\u0000\u0000\u01f1\u01f6\u00038\u001c\u0003\u01f2\u01f3\n\u0001"+
		"\u0000\u0000\u01f3\u01f4\u0005J\u0000\u0000\u01f4\u01f6\u00038\u001c\u0002"+
		"\u01f5\u01ec\u0001\u0000\u0000\u0000\u01f5\u01ef\u0001\u0000\u0000\u0000"+
		"\u01f5\u01f2\u0001\u0000\u0000\u0000\u01f6\u01f9\u0001\u0000\u0000\u0000"+
		"\u01f7\u01f5\u0001\u0000\u0000\u0000\u01f7\u01f8\u0001\u0000\u0000\u0000"+
		"\u01f89\u0001\u0000\u0000\u0000\u01f9\u01f7\u0001\u0000\u0000\u0000\u01fa"+
		"\u020e\u0005+\u0000\u0000\u01fb\u01fc\u0003H$\u0000\u01fc\u01fd\u0003"+
		"<\u001e\u0000\u01fd\u020e\u0001\u0000\u0000\u0000\u01fe\u020e\u0003J%"+
		"\u0000\u01ff\u020e\u0003D\"\u0000\u0200\u020e\u0003<\u001e\u0000\u0201"+
		"\u020e\u0003H$\u0000\u0202\u020e\u0005\u0005\u0000\u0000\u0203\u0204\u0005"+
		"\u0001\u0000\u0000\u0204\u0207\u00030\u0018\u0000\u0205\u0206\u0005\u0002"+
		"\u0000\u0000\u0206\u0208\u00030\u0018\u0000\u0207\u0205\u0001\u0000\u0000"+
		"\u0000\u0208\u0209\u0001\u0000\u0000\u0000\u0209\u0207\u0001\u0000\u0000"+
		"\u0000\u0209\u020a\u0001\u0000\u0000\u0000\u020a\u020b\u0001\u0000\u0000"+
		"\u0000\u020b\u020c\u0005\u0003\u0000\u0000\u020c\u020e\u0001\u0000\u0000"+
		"\u0000\u020d\u01fa\u0001\u0000\u0000\u0000\u020d\u01fb\u0001\u0000\u0000"+
		"\u0000\u020d\u01fe\u0001\u0000\u0000\u0000\u020d\u01ff\u0001\u0000\u0000"+
		"\u0000\u020d\u0200\u0001\u0000\u0000\u0000\u020d\u0201\u0001\u0000\u0000"+
		"\u0000\u020d\u0202\u0001\u0000\u0000\u0000\u020d\u0203\u0001\u0000\u0000"+
		"\u0000\u020e;\u0001\u0000\u0000\u0000\u020f\u0210\u0005K\u0000\u0000\u0210"+
		"=\u0001\u0000\u0000\u0000\u0211\u021d\u0003F#\u0000\u0212\u0213\u0005"+
		"\u0001\u0000\u0000\u0213\u0218\u0003@ \u0000\u0214\u0215\u0005\u0002\u0000"+
		"\u0000\u0215\u0217\u0003@ \u0000\u0216\u0214\u0001\u0000\u0000\u0000\u0217"+
		"\u021a\u0001\u0000\u0000\u0000\u0218\u0216\u0001\u0000\u0000\u0000\u0218"+
		"\u0219\u0001\u0000\u0000\u0000\u0219\u021b\u0001\u0000\u0000\u0000\u021a"+
		"\u0218\u0001\u0000\u0000\u0000\u021b\u021c\u0005\u0003\u0000\u0000\u021c"+
		"\u021e\u0001\u0000\u0000\u0000\u021d\u0212\u0001\u0000\u0000\u0000\u021d"+
		"\u021e\u0001\u0000\u0000\u0000\u021e?\u0001\u0000\u0000\u0000\u021f\u0222"+
		"\u0005N\u0000\u0000\u0220\u0222\u0003>\u001f\u0000\u0221\u021f\u0001\u0000"+
		"\u0000\u0000\u0221\u0220\u0001\u0000\u0000\u0000\u0222A\u0001\u0000\u0000"+
		"\u0000\u0223\u0224\u0007\u0006\u0000\u0000\u0224C\u0001\u0000\u0000\u0000"+
		"\u0225\u0226\u0007\u0007\u0000\u0000\u0226E\u0001\u0000\u0000\u0000\u0227"+
		"\u022c\u0003H$\u0000\u0228\u0229\u0005\u0004\u0000\u0000\u0229\u022b\u0003"+
		"H$\u0000\u022a\u0228\u0001\u0000\u0000\u0000\u022b\u022e\u0001\u0000\u0000"+
		"\u0000\u022c\u022a\u0001\u0000\u0000\u0000\u022c\u022d\u0001\u0000\u0000"+
		"\u0000\u022dG\u0001\u0000\u0000\u0000\u022e\u022c\u0001\u0000\u0000\u0000"+
		"\u022f\u0234\u0005Q\u0000\u0000\u0230\u0234\u0005S\u0000\u0000\u0231\u0234"+
		"\u0005T\u0000\u0000\u0232\u0234\u0005R\u0000\u0000\u0233\u022f\u0001\u0000"+
		"\u0000\u0000\u0233\u0230\u0001\u0000\u0000\u0000\u0233\u0231\u0001\u0000"+
		"\u0000\u0000\u0233\u0232\u0001\u0000\u0000\u0000\u0234I\u0001\u0000\u0000"+
		"\u0000\u0235\u0239\u0005O\u0000\u0000\u0236\u0239\u0005P\u0000\u0000\u0237"+
		"\u0239\u0005N\u0000\u0000\u0238\u0235\u0001\u0000\u0000\u0000\u0238\u0236"+
		"\u0001\u0000\u0000\u0000\u0238\u0237\u0001\u0000\u0000\u0000\u0239K\u0001"+
		"\u0000\u0000\u0000JU^djqz\u0080\u008b\u0092\u009c\u00a3\u00ab\u00b3\u00b7"+
		"\u00bb\u00c1\u00c5\u00d4\u00d7\u00dc\u00de\u00e2\u00ef\u00f6\u00fa\u00fe"+
		"\u0105\u010e\u0111\u0115\u011a\u011d\u0124\u012f\u0132\u0136\u013c\u013f"+
		"\u0146\u0159\u015d\u0161\u0165\u0169\u016d\u016f\u017b\u0181\u0185\u0187"+
		"\u018f\u019d\u01a5\u01ad\u01af\u01b4\u01ba\u01c2\u01cb\u01d1\u01da\u01df"+
		"\u01e4\u01ea\u01f5\u01f7\u0209\u020d\u0218\u021d\u0221\u022c\u0233\u0238";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}