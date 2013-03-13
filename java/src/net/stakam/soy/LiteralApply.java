package net.stakam.soy;

import java.util.List;
import java.util.Set;
import com.google.common.collect.ImmutableSet;
import com.google.template.soy.jssrc.restricted.JsExpr;
import com.google.template.soy.jssrc.restricted.SoyJsSrcFunction;


class LiteralApply implements SoyJsSrcFunction 
{
    @Override public String getName() { 
        return "literalApply";
    } 
    
    @Override public Set<Integer> getValidArgsSizes() { 
        return ImmutableSet.of(2); 
    }
    
    @Override public JsExpr computeForJsSrc(List<JsExpr> args) { 
        String output = args.get(0).getText();
        output += ".apply(null,";
        output += args.get(1).getText();
        output += ")";
        return new JsExpr(output, Integer.MAX_VALUE); 
    } 
    
    // TODO: Implement.
    // @Override public JavaExpr computeForJavaSrc(List<JavaExpr> args) {
    // }
} 
