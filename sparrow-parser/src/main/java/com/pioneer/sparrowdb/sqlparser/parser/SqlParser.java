package com.pioneer.sparrowdb.sqlparser.parser;

import com.pioneer.sparrowdb.sqlparser.ParsingException;
import com.pioneer.sparrowdb.sqlparser.codegen.SparrowSQLLexer;
import com.pioneer.sparrowdb.sqlparser.codegen.SparrowSQLParser;
import com.pioneer.sparrowdb.sqlparser.tree.Node;
import com.pioneer.sparrowdb.sqlparser.tree.Statement;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.util.function.Function;

public class SqlParser {

    public Statement createStatement(String sql) {
        return (Statement) invokeParser("statement", sql, SparrowSQLParser::singleStatement);
    }

    private Node invokeParser(String name, String sql, Function<SparrowSQLParser, ParserRuleContext> parseFunction) {
        try {
            SparrowSQLLexer lexer = new SparrowSQLLexer(new CaseInsensitiveStream(CharStreams.fromString(sql)));
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            SparrowSQLParser parser = new SparrowSQLParser(tokenStream);

            // Override the default error strategy to not attempt inserting or deleting a token.
            // Otherwise, it messes up error reporting
            parser.setErrorHandler(new DefaultErrorStrategy() {
                @Override
                public Token recoverInline(Parser recognizer) throws RecognitionException {
                    if (nextTokensContext == null) {
                        throw new InputMismatchException(recognizer);
                    } else {
                        throw new InputMismatchException(recognizer, nextTokensState, nextTokensContext);
                    }
                }
            });

            parser.removeErrorListeners();

            ParserRuleContext tree;
            try {
                // first, try parsing with potentially faster SLL mode
                parser.getInterpreter().setPredictionMode(PredictionMode.SLL);
                tree = parseFunction.apply(parser);
            } catch (ParseCancellationException ex) {
                // if we fail, parse with LL mode
                tokenStream.reset(); // rewind input stream
                parser.reset();

                parser.getInterpreter().setPredictionMode(PredictionMode.LL);
                tree = parseFunction.apply(parser);
            }

            return new AstBuilder(new ParsingOptions()).visit(tree);
        } catch (StackOverflowError e) {
            throw new ParsingException(name + " is too large (stack overflow while parsing)");
        }
    }
}
